package com.example.univercity.services.impl

import com.example.univercity.dtos.UniversityCreateDto
import com.example.univercity.dtos.UniversityResponseDto
import com.example.univercity.dtos.UniversityUpdateDto
import com.example.univercity.entities.Faculty
import com.example.univercity.entities.University
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.UniversityRepository
import com.example.univercity.services.UniversityService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class UniversityImpl(
    private val universityRepository: UniversityRepository,
    private val answerService: AnswerService
) : UniversityService {


    override fun create(dto: UniversityCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            return  answerService.saveObject(universityRepository, University(name, address, openYear), true)
        }

    }
    override fun update(id: Long, dto: UniversityUpdateDto): HttpEntity<ApiResponse> {
        val university = universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") }
        dto.apply {
            name?.let {
                university.name = it
            }
            address?.let {
                university.address = it
            }
            openYear?.let {
                university.openYear = it
            }

        }
        return  answerService.saveObject(universityRepository, university, true)

    }

    override fun getAll() = universityRepository.findAll().map { UniversityResponseDto.toDto(it) }

    override fun getOne(id: Long) = UniversityResponseDto.toDto(universityRepository.findById(id).orElseThrow { Exception("University not found by id: $id") })

    override fun delete(id: Long) = answerService.deleteObject(universityRepository, id)

}