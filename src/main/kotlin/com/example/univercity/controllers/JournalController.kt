package com.example.univercity.controllers

import com.example.univercity.dtos.JournalCreateDto
import com.example.univercity.dtos.JournalUpdateDto
import com.example.univercity.services.JournalService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("journal")
class JournalController(
    private val journalService: JournalService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: JournalCreateDto) = journalService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: JournalUpdateDto) = journalService.update(id, dto)

    @GetMapping
    fun getAll() = journalService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = journalService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = journalService.delete(id)
}