package com.example.univercity.entities

import javax.persistence.*


@Entity
class Student(
    var name: String,
    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var group: Group

) : BaseEntity()