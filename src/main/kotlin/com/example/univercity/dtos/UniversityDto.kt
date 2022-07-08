package com.example.univercity.dtos

import com.example.univercity.entities.University

data class UniversityCreateDto(
    var name: String,
    var address: String,
    var openYear: Int

)

data class UniversityUpdateDto(
    var name: String?,
    var address: String?,
    var openYear: Int?
)

data class UniversityResponseDto(
    var id: Long?,
    var name: String?,


    var address: String?,
    var openYear: Int?
) {
    companion object {
        fun toDto(r: University) = r.run {
            UniversityResponseDto(id, name, address, openYear)
        }
    }
}
