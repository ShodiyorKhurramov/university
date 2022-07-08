package com.example.univercity.repositories

import com.example.univercity.entities.Group

interface GroupRepository : BaseRepository<Group> {

    fun findAllByFacultyId(faculty_id: Long):List<Group>?
}