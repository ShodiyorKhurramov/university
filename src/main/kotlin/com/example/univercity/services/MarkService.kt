package com.example.univercity.services

import com.example.univercity.dtos.MarkCreateDto
import com.example.univercity.dtos.MarkResponseDto
import com.example.univercity.dtos.MarkUpdateDto
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity


interface MarkService {

    fun create(dto: MarkCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: MarkUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<MarkResponseDto>
    fun getOne(id: Long): MarkResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>

}