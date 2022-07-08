package com.example.univercity.services

import com.example.univercity.dtos.JournalCreateDto
import com.example.univercity.dtos.JournalResponseDto
import com.example.univercity.dtos.JournalUpdateDto
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity


interface JournalService {

    fun create(dto: JournalCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: JournalUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<JournalResponseDto>
    fun getOne(id: Long): JournalResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
}