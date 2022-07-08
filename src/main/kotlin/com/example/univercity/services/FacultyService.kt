package com.example.univercity.services

import com.example.univercity.payload.ApiResponse
import com.example.univercity.dtos.FacultyCreateDto
import com.example.univercity.dtos.FacultyResponseDto
import com.example.univercity.dtos.FacultySizeDto
import com.example.univercity.dtos.FacultyUpdateDto
import org.springframework.http.HttpEntity
import org.springframework.http.ResponseEntity


interface FacultyService {

    fun create(dto: FacultyCreateDto):HttpEntity<ApiResponse>
    fun update(id:Long,dto: FacultyUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<FacultyResponseDto>
    fun getOne(id: Long):FacultyResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
    fun getAllStudentsAndGroups(id: Long): FacultySizeDto
}