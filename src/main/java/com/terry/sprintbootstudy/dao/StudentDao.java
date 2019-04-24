package com.terry.sprintbootstudy.dao;

import com.terry.sprintbootstudy.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, String> {
    @Query(value = "SELECT s FROM Student s WHERE s.clazzByClassId.id=:classID")
    public List<Student> findStudentByClass(@Param("classID") Integer classID);
}
