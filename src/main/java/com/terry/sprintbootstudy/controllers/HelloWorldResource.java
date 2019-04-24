package com.terry.sprintbootstudy.controllers;

import com.terry.sprintbootstudy.dto.ClassDTO;
import com.terry.sprintbootstudy.dto.StudentDTO;

import java.util.List;

public interface HelloWorldResource {
    boolean saveClass(ClassDTO classDTO);
    List<ClassDTO> findClassByTeacher(String teacherID);
    List<StudentDTO> findStudentByClass(Integer classID);
}
