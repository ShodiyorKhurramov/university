package com.example.univercity.controllers

import com.example.univercity.dtos.MarkCreateDto
import com.example.univercity.dtos.MarkUpdateDto
import com.example.univercity.services.MarkService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("mark")
class MarkController(
    private val markService: MarkService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: MarkCreateDto) = markService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: MarkUpdateDto) = markService.update(id, dto)

    @GetMapping
    fun getAll() = markService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = markService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = markService.delete(id)
}