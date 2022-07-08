package com.example.univercity.services.impl

import com.example.univercity.dtos.*
import com.example.univercity.payload.ApiResponse
import com.example.univercity.entities.Faculty
import com.example.univercity.repositories.FacultyRepository
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.repositories.StudentRepository
import com.example.univercity.repositories.UniversityRepository
import com.example.univercity.services.FacultyService
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class FacultyImpl(
    private val facultyRepository: FacultyRepository,
    private val universityRepository: UniversityRepository,
    private val answerService: AnswerService,
    private val groupRepository: GroupRepository,
    private val studentRepository: StudentRepository
) : FacultyService {


    override fun create(dto: FacultyCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val university = universityRepository.findById(universityId)
                .orElseThrow { Exception("University not found by id: $universityId") }
            return answerService.saveObject(facultyRepository, Faculty(name, university), true)
        }

    }

    override fun update(id: Long, dto: FacultyUpdateDto): HttpEntity<ApiResponse> {
        val faculty = facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") }
        dto.apply {
            name?.let {
                faculty.name = it
            }

            universityId?.let {
                val university = universityRepository.findById(it).orElseThrow { Exception("University not by id: $id") }
                faculty.university = university
            }
        }
        return answerService.saveObject(facultyRepository, faculty, true)

    }

    override fun getAll() = facultyRepository.findAll().map { FacultyResponseDto.toDto(it) }
    override fun getOne(id: Long) = FacultyResponseDto.toDto(
        facultyRepository.findById(id).orElseThrow { Exception("Faculty not found by id: $id") })


    override fun delete(id: Long) = answerService.deleteObject(facultyRepository, id)

    override fun getAllStudentsAndGroups(id: Long): FacultySizeDto {
        val faculty = facultyRepository.findById(id).orElseThrow()
        val groups = faculty.id?.let { groupRepository.findAllByFacultyId(it) }
        val student =  studentRepository.findAllByGroupIn(groups)
        return FacultySizeDto(groups!!.size, student!!.size)
    }


}