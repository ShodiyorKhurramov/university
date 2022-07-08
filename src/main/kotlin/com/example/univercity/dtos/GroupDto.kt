package com.example.univercity.dtos

import com.example.univercity.entities.Group

data class GroupCreateDto(
    var name: String,
    var facultyId: Long,
    var year: Int


)

data class GroupUpdateDto(
    var name:String?,
    var facultyId:Long?,
    var year: Int?


)

data class GroupResponseDto(
    var id:Long?,
    var name:String?,
    var facultyId:Long?,
    var year:Int

) {
    companion object {
        fun toDto(r: Group) = r.run {
            GroupResponseDto(id,name,faculty.id,year)
        }
    }
}
