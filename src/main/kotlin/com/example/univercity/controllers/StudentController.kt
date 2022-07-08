package com.example.univercity.controllers

import com.example.univercity.dtos.StudentCreateDto
import com.example.univercity.dtos.StudentUpdateDto
import com.example.univercity.services.StudentService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("student")
class StudentController(
    private val studentService: StudentService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: StudentCreateDto) = studentService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: StudentUpdateDto) = studentService.update(id, dto)

    @GetMapping
    fun getAll() = studentService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = studentService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = studentService.delete(id)


    @GetMapping("subjects/{id}")
    fun getAllSubjectsStudent(@PathVariable id: Long) = studentService.getAllSubjectsStudent(id)

    @GetMapping("search/{name}")
    fun getStudent(@PathVariable name:String) = studentService.getStudent(name)

    @GetMapping("group/{id}")
    fun getStudentMark(@PathVariable id: Long) = studentService.getStudentMark(id)

}