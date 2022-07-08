package com.example.univercity.repositories

import com.example.univercity.dtos.ListStudentDto
import com.example.univercity.entities.Group
import com.example.univercity.entities.Student
import org.springframework.data.jpa.repository.Query

interface StudentRepository : BaseRepository<Student> {
    fun findAllByGroupIn(group: List<Group>?):List<Student>?
    fun findByName(name: String):Student


    @Query("select s.name as studentName ,avg(m.mark) as studentMark from student s inner join mark m on m.student_id = s.id where s.group_id = :groupId group by s.name order by avg(m.mark);", nativeQuery = true)
    fun findStudentMark(groupId: Long):List<ListStudentDto>
}