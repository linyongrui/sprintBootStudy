package com.terry.sprintbootstudy.services;

import com.terry.sprintbootstudy.dao.ClassDao;
import com.terry.sprintbootstudy.dao.StudentDao;
import com.terry.sprintbootstudy.domain.Clazz;
import com.terry.sprintbootstudy.domain.Student;
import com.terry.sprintbootstudy.domain.Teacher;
import com.terry.sprintbootstudy.dto.ClassDTO;
import com.terry.sprintbootstudy.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service("ClassService")
@Transactional(readOnly = true)
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional(readOnly = false)
    public boolean save(@RequestBody ClassDTO classDTO) {

        Clazz clazz = new Clazz();
        clazz.setName(classDTO.getName());
        if(classDTO.getId()>0) {
            clazz.setId(classDTO.getId());
        }
         classDao.save(clazz);
        return true;
    }

    @Override
    public List<ClassDTO> findClassByTeacher(String teacherID){
        List<ClassDTO> result = new ArrayList<>();

        //查对象，再过滤
        List<Clazz> Clazzs = classDao.findAll();
        ClassDTO classDTO;
        for(Clazz clazz:Clazzs) {
            for(Teacher teacher:clazz.getTeachers()) {
                if(teacherID.equals(teacher.getId())) {
                    classDTO = new ClassDTO();
                    classDTO.setId(clazz.getId());
                    classDTO.setName(clazz.getName());
                    result.add(classDTO);
                    break;
                }
            }
        }

//        //直接用sql过滤
//        List<Clazz> Clazzs2 = classDao.findClassByTeacherBySql(teacherID);
//        for(Clazz clazz:Clazzs2) {
//            classDTO = new ClassDTO();
//            classDTO.setId(clazz.getId());
//            classDTO.setName(clazz.getName());
//            result.add(classDTO);
//        }

        return result;
    }

    @Override
    public List<StudentDTO> findStudentByClass(Integer classID){
        List<Student> studentDTOs =  studentDao.findStudentByClass(classID);

        List<StudentDTO> result = new ArrayList<>();
        StudentDTO studentDTO;
        for(Student student:studentDTOs) {
            studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setName(student.getName());
            result.add(studentDTO);
        }
        return result;
    }

}
