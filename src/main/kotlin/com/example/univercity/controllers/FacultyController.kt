package com.example.univercity.controllers

import com.example.univercity.dtos.FacultyCreateDto
import com.example.univercity.dtos.FacultyUpdateDto
import com.example.univercity.services.FacultyService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("faculty")
class FacultyController(
    private val facultyService: FacultyService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: FacultyCreateDto) = facultyService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: FacultyUpdateDto) = facultyService.update(id, dto)

    @GetMapping
    fun getAll() = facultyService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = facultyService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = facultyService.delete(id)

    @GetMapping("size/{id}")
    fun getAllStudentsAndGroups(@PathVariable id:Long)=facultyService.getAllStudentsAndGroups(id)
}