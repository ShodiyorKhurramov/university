package com.example.univercity.services.impl

import com.example.univercity.dtos.JournalCreateDto
import com.example.univercity.dtos.JournalResponseDto
import com.example.univercity.dtos.JournalUpdateDto
import com.example.univercity.entities.Journal
import com.example.univercity.payload.ApiResponse
import com.example.univercity.repositories.GroupRepository
import com.example.univercity.repositories.JournalRepository
import com.example.univercity.services.JournalService
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Service


@Service
class JournalImpl(
    private val journalRepository: JournalRepository,
    private val groupRepository: GroupRepository,
    private val answerService: AnswerService
) : JournalService {


    override fun create(dto: JournalCreateDto): HttpEntity<ApiResponse> {
        dto.apply {
            val group = groupRepository.findById(groupId)
                .orElseThrow { Exception("Group not found by id: $groupId") }
            return answerService.saveObject(journalRepository, Journal(name, group), true)
        }

    }

    override fun update(id: Long, dto: JournalUpdateDto): HttpEntity<ApiResponse> {
        val journal = journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") }
        dto.apply {
            name?.let {
                journal.name = it
            }

            groupId?.let {
                val group = groupRepository.findById(it).orElseThrow { Exception("Group not by id: $id") }
                journal.group = group
            }

        }
        return answerService.saveObject(journalRepository, journal, true)

    }

    override fun getAll() = journalRepository.findAll().map { JournalResponseDto.toDto(it) }
    override fun getOne(id: Long) = JournalResponseDto.toDto(
        journalRepository.findById(id).orElseThrow { Exception("Journal not found by id: $id") })


    override fun delete(id: Long) = answerService.deleteObject(journalRepository, id)


}