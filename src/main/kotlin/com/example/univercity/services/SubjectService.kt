package com.example.univercity.services

import com.example.univercity.dtos.SubjectCreateDto
import com.example.univercity.dtos.SubjectResponseDto
import com.example.univercity.dtos.SubjectUpdateDto
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity


interface SubjectService {

    fun create(dto: SubjectCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: SubjectUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<SubjectResponseDto>
    fun getOne(id: Long): SubjectResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
}