package com.example.univercity.dtos

import com.example.univercity.entities.Faculty

data class FacultyCreateDto(
    var name:String,
    var universityId:Long


)

data class FacultyUpdateDto(
    var name:String?,
    var universityId:Long?


)

data class FacultyResponseDto(
    var id:Long?,
    var name:String?,
) {
    companion object {
        fun toDto(r: Faculty) = r.run {
            FacultyResponseDto(id,name)
        }
    }
}

data class FacultySizeDto(
    val groupSize:Int,
    val studentSize:Int
)
