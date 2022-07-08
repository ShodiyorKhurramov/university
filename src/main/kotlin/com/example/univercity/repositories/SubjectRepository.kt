package com.example.univercity.repositories

import com.example.univercity.entities.Subject
import org.springframework.data.jpa.repository.Query

interface SubjectRepository : BaseRepository<Subject> {

    fun findByGroupId(group_id:Long):List<Subject>

    }