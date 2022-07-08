package com.example.univercity.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne


@Entity
class Mark(
    @ManyToOne
    var journal: Journal,
    @ManyToOne
    var subject: Subject,
    @ManyToOne
    var student: Student,
    var mark: Int

) : BaseEntity()