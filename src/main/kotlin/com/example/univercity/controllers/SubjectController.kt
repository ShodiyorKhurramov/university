package com.example.univercity.controllers

import com.example.univercity.dtos.SubjectCreateDto
import com.example.univercity.dtos.SubjectUpdateDto
import com.example.univercity.services.SubjectService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("subject")
class SubjectController(
    private val subjectService: SubjectService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: SubjectCreateDto) = subjectService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: SubjectUpdateDto) = subjectService.update(id, dto)

    @GetMapping
    fun getAll() = subjectService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = subjectService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = subjectService.delete(id)
}