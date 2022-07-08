package com.example.univercity.dtos

import com.example.univercity.entities.Journal
import com.example.univercity.entities.Subject

data class JournalCreateDto(
    var name: String,
    var groupId: Long


)

data class JournalUpdateDto(
    var name: String?,
    var groupId: Long?


)

data class JournalResponseDto(
    var id: Long?,
    var name: String?,

    ) {
    companion object {
        fun toDto(r: Journal) = r.run {
            JournalResponseDto(id, name)
        }
    }
}
