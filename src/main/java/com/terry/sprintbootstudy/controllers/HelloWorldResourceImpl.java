package com.terry.sprintbootstudy.controllers;

import com.terry.sprintbootstudy.dto.ClassDTO;
import com.terry.sprintbootstudy.dto.StudentDTO;
import com.terry.sprintbootstudy.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/helloWorld")
public class HelloWorldResourceImpl implements HelloWorldResource {

    @Autowired
    @Qualifier("ClassService")
    private ClassService classService;

    @RequestMapping(value = "/classByTeacher/{teacherID}", method = RequestMethod.GET)
    @Override
    @ResponseBody
    public List<ClassDTO> findClassByTeacher(@PathVariable(value = "teacherID") String teacherID) {// 路径方式传入参  /XXX/=1
        List<ClassDTO> classDTOs = classService.findClassByTeacher(teacherID);
        return classDTOs;
    }

    @RequestMapping(value = "/studentByClass", method = RequestMethod.GET)
    @Override
    @ResponseBody
    public List<StudentDTO> findStudentByClass(Integer classID) {// 普通方式传入参 /XXX？classID=1
        List<StudentDTO> studentDTOs = classService.findStudentByClass(classID);
        return studentDTOs;
    }

    @RequestMapping(value = "/class", method = RequestMethod.POST)
    @Override
    @ResponseBody
    public boolean saveClass(@RequestBody ClassDTO classDTO) { //@RequestBody 入参为json格式
        boolean result = classService.save(classDTO);
        return result;
    }
}
