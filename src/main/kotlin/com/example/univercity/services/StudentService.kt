package com.example.univercity.services

import com.example.univercity.dtos.*
import com.example.univercity.entities.Subject
import com.example.univercity.payload.ApiResponse
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service

@Service
interface StudentService {

    fun create(dto: StudentCreateDto): HttpEntity<ApiResponse>
    fun update(id: Long, dto: StudentUpdateDto): HttpEntity<ApiResponse>
    fun getAll(): List<StudentResponseDto>
    fun getOne(id: Long): StudentResponseDto
    fun delete(id: Long): HttpEntity<ApiResponse>
    fun getAllSubjectsStudent(id:Long):List<SubjectResponseDto>?
    fun getStudent(name:String): StudentSearchResultResponseDto
    fun getStudentMark(id: Long): List<ListStudentDto>
}