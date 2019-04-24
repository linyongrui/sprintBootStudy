package com.terry.sprintbootstudy.services;

import com.terry.sprintbootstudy.dto.ClassDTO;
import com.terry.sprintbootstudy.dto.StudentDTO;

import java.util.List;

public interface ClassService {
    boolean save(ClassDTO classDTO);
    List<ClassDTO> findClassByTeacher(String teacherID);
    List<StudentDTO> findStudentByClass(Integer classID);
}
