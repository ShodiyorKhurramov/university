package com.example.univercity.controllers

import com.example.univercity.dtos.GroupCreateDto
import com.example.univercity.dtos.GroupUpdateDto
import com.example.univercity.services.GroupService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("group")
class GroupController(
    private val groupService: GroupService

) {

    @PostMapping("create")
    fun create(@RequestBody dto: GroupCreateDto) = groupService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: GroupUpdateDto) = groupService.update(id, dto)

    @GetMapping
    fun getAll() = groupService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = groupService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = groupService.delete(id)
}