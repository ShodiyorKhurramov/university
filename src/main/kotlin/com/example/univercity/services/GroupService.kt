package com.example.univercity.services

import com.example.univercity.dtos.GroupCreateDto
import com.example.univercity.dtos.GroupResponseDto
import com.example.univercity.dtos.GroupUpdateDto
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity


interface GroupService {

    fun create(dto: GroupCreateDto): HttpEntity<ApiResponse>
    fun update(id:Long,dto: GroupUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<GroupResponseDto>
    fun getOne(id: Long): GroupResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
}