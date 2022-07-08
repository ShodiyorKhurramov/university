package com.example.univercity.services.impl

import com.example.univercity.dtos.GroupCreateDto
import com.example.univercity.dtos.GroupResponseDto
import com.example.univercity.dtos.GroupUpdateDto
import com.example.univercity.entities.Group
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.FacultyRepository
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.services.GroupService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class GroupImpl(
    private val groupRepository: GroupRepository,
    private val facultyRepository: FacultyRepository,
    private val answerService: AnswerService
) : GroupService {


    override fun create(dto: GroupCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val faculty = facultyRepository.findById(facultyId)
                .orElseThrow { Exception("Faculty not found by id: $facultyId") }
            return answerService.saveObject(groupRepository, Group(name, faculty, year), true)
        }

    }

    override fun update(id: Long, dto: GroupUpdateDto): HttpEntity<ApiResponse> {
        val group = groupRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") }
        dto.apply {
            name?.let {
                group.name = it
            }

            facultyId?.let {
                val faculty = facultyRepository.findById(it).orElseThrow { Exception("Faculty not by id: $id") }
                group.faculty = faculty
            }

            year?.let {
                group.year = it
            }
        }
        return answerService.saveObject(groupRepository, group, true)

    }

    override fun getAll() = groupRepository.findAll().map { GroupResponseDto.toDto(it) }
    override fun getOne(id: Long) = GroupResponseDto.toDto(
        groupRepository.findById(id).orElseThrow { Exception("Group not found by id: $id") })


    override fun delete(id: Long) = answerService.deleteObject(groupRepository, id)


}