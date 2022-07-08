package com.example.univercity.services.impl

import com.example.univercity.dtos.*
import com.example.univercity.entities.Student
import com.example.univercity.entities.Subject
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.FacultyRepository
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.repositories.StudentRepository
import com.example.univercity.repositories.SubjectRepository
import com.example.univercity.services.StudentService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class StudentImpl(
    private val studentRepository: StudentRepository,
    private val groupRepository: GroupRepository,
    private val answerService: AnswerService,
    private val subjectRepository: SubjectRepository,
    private val facultyRepository: FacultyRepository
) : StudentService {


    override fun create(dto: StudentCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId)
                .orElseThrow { Exception("Group not found by id: $groupId") }
            return answerService.saveObject(studentRepository, Student(name, group), true)
        }

    }

    override fun update(id: Long, dto: StudentUpdateDto): HttpEntity<ApiResponse> {
        val student = studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") }
        dto.apply {
            name?.let {
                student.name = it
            }

            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                student.group = group
            }

        }
        return answerService.saveObject(studentRepository, student, true)

    }

    override fun getAll() = studentRepository.findAll().map { StudentResponseDto.toDto(it) }
    override fun getOne(id: Long) = StudentResponseDto.toDto(
        studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") })


    override fun delete(id: Long) = answerService.deleteObject(studentRepository, id)

    override fun getAllSubjectsStudent(id: Long): List<SubjectResponseDto>? {
        val student = studentRepository.findById(id).orElseThrow { Exception("Student not found by id: $id") }
        return subjectRepository.findByGroupId(student.group.id!!).map { SubjectResponseDto.toDto(it) }
    }

    override fun getStudent(name:String): StudentSearchResultResponseDto {
        val student = studentRepository.findByName(name)
        val group = student.group.id?.let { groupRepository.findById(it).orElseThrow() }
        val faculty = group!!.faculty.id?.let { facultyRepository.findById(it).orElseThrow() }
        return StudentSearchResultResponseDto(student.name,group.name, faculty!!.name)
    }


    override fun getStudentMark(id: Long): List<ListStudentDto> = studentRepository.findStudentMark(id)

}