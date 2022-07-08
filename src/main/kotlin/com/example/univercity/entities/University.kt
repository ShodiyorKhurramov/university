package com.example.univercity.entities

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class University(
    @Column(unique = true)
    var name: String,
    var address: String,
    var openYear: Int


) : BaseEntity()