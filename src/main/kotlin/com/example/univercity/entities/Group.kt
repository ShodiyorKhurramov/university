package com.example.univercity.entities

import javax.persistence.*


@Entity(name = "groups")
class Group(
    var name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facultyId")
    var faculty: Faculty,
    var year: Int
  
) : BaseEntity()