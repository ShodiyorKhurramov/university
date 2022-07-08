package com.example.univercity.services

import com.example.univercity.dtos.UniversityCreateDto
import com.example.univercity.dtos.UniversityResponseDto
import com.example.univercity.dtos.UniversityUpdateDto
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


interface UniversityService {

    fun create(dto: UniversityCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: UniversityUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<UniversityResponseDto>
    fun getOne(id: Long): UniversityResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
}