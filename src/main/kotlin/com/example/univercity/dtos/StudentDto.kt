package com.example.univercity.dtos

import com.example.univercity.entities.Student

data class StudentCreateDto(
    var name: String,
    var groupId: Long


)

data class StudentUpdateDto(
    var name: String?,
    var groupId: Long?


)

data class StudentResponseDto(
    var id: Long?,
    var name: String?,

    ) {
    companion object {
        fun toDto(r: Student) = r.run {
            StudentResponseDto(id, name)
        }
    }
}

data class StudentSearchResultResponseDto(
    var name: String,
    var groupName:String?,
    var facultyName:String?
)

interface ListStudentDto {
    fun getStudentName():String
    fun getStudentMark():Long
}
