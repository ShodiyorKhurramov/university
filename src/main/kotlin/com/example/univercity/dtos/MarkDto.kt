package com.example.univercity.dtos

import com.example.univercity.entities.Mark

data class MarkCreateDto(
    var journalId: Long,
    var subjectId: Long,
    var studentId: Long,
    var mark: Int

)

data class MarkUpdateDto(
    var mark: Int?
)

data class MarkResponseDto(
    var id: Long?,
    var mark: Int
) {
    companion object {
        fun toDto(r: Mark) = r.run {
            MarkResponseDto(id, mark)
        }
    }
}
