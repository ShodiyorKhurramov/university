package com.example.univercity.services.impl

import com.example.univercity.dtos.SubjectCreateDto
import com.example.univercity.dtos.SubjectResponseDto
import com.example.univercity.dtos.SubjectUpdateDto
import com.example.univercity.entities.Subject
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.repositories.SubjectRepository
import com.example.univercity.services.SubjectService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class SubjectImpl(
    private val subjectRepository: SubjectRepository,
    private val groupRepository: GroupRepository,
    private val answerService: AnswerService
) : SubjectService {


    override fun create(dto: SubjectCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId)
                .orElseThrow { Exception("Group not found by id: $groupId") }
            return answerService.saveObject(subjectRepository, Subject(name, group), true)
        }

    }

    override fun update(id: Long, dto: SubjectUpdateDto): HttpEntity<ApiResponse> {
        val subject = subjectRepository.findById(id).orElseThrow { Exception("Subject not found by id: $id") }
        dto.apply {
            name?.let {
                subject.name = it
            }

            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                subject.group = group
            }

        }
        return answerService.saveObject(subjectRepository, subject, true)

    }

    override fun getAll() = subjectRepository.findAll().map { SubjectResponseDto.toDto(it) }
    override fun getOne(id: Long) = SubjectResponseDto.toDto(
        subjectRepository.findById(id).orElseThrow { Exception("Subject not found by id: $id") })


    override fun delete(id: Long) = answerService.deleteObject(subjectRepository, id)


}