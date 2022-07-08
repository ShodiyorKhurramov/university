package com.example.univercity.services.impl

import com.example.univercity.dtos.MarkCreateDto
import com.example.univercity.dtos.MarkResponseDto
import com.example.univercity.dtos.MarkUpdateDto
import com.example.univercity.entities.Mark
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.JournalRepository
import com.example.univercity.repositories.StudentRepository
import com.example.univercity.repositories.MarkRepository
import com.example.univercity.repositories.SubjectRepository
import com.example.univercity.services.MarkService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class MarkImpl(
    private val markRepository: MarkRepository,
    private val studentRepository: StudentRepository,
    private val subjectRepository: SubjectRepository,
    private val journalRepository: JournalRepository,
    private val answerService: AnswerService
) : MarkService {


    override fun create(dto: MarkCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val subject = subjectRepository.findById(subjectId)
                .orElseThrow { Exception("Student not found by id: $studentId") }
            val student = studentRepository.findById(studentId)
                .orElseThrow { Exception("Student not found by id: $studentId") }
            val journal = journalRepository.findById(journalId)
                .orElseThrow { Exception("Student not found by id: $studentId") }
            return answerService.saveObject(markRepository, Mark(journal, subject, student, mark), true)
        }

    }

    override fun update(id: Long, dto: MarkUpdateDto): HttpEntity<ApiResponse> {
        val markObject = markRepository.findById(id).orElseThrow { Exception("Mark not found by id: $id") }

        dto.mark?.let {
            markObject.mark = it
        }

        return answerService.saveObject(markRepository, markObject, true)

    }

    override fun getAll() = markRepository.findAll().map { MarkResponseDto.toDto(it) }
    override fun getOne(id: Long) = MarkResponseDto.toDto(
        markRepository.findById(id).orElseThrow { Exception("Mark not found by id: $id") })

    override fun delete(id: Long) = answerService.deleteObject(markRepository, id)


}