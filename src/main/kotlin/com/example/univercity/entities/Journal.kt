package com.example.univercity.entities

import javax.persistence.*


@Entity
class Journal(
    var name: String,
    @OneToOne(fetch = FetchType.LAZY)
    var group: Group,
    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var subjects: MutableList<Subject>? = null
) : BaseEntity()