package com.example.univercity.entities


import javax.persistence.*


@Entity
@Table(uniqueConstraints = [
    UniqueConstraint(columnNames = ["name", "universityId"])
])
 class Faculty(
    var name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "universityId")
    var university: University
) : BaseEntity()