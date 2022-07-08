package com.example.univercity.controllers

import com.example.univercity.dtos.UniversityCreateDto
import com.example.univercity.dtos.UniversityUpdateDto
import com.example.univercity.services.UniversityService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("university")
class UniversityController(
    private val universityService: UniversityService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: UniversityCreateDto) = universityService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: UniversityUpdateDto) = universityService.update(id, dto)

    @GetMapping
    fun getAll() = universityService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = universityService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = universityService.delete(id)
}