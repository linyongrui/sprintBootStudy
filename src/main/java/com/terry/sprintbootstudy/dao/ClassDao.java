package com.terry.sprintbootstudy.dao;

import com.terry.sprintbootstudy.domain.Clazz;
import com.terry.sprintbootstudy.utilities.DomainSchemaConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao extends JpaRepository<Clazz, Integer> {

    @Query(value = "SELECT c.* FROM "+ DomainSchemaConfig.DEMO_SCHEMA_01+".class c" +
            " INNER JOIN  "+ DomainSchemaConfig.DEMO_SCHEMA_01+".teacher_class tc ON c.id=tc.class_id " +
            " INNER JOIN  "+ DomainSchemaConfig.DEMO_SCHEMA_02+".teacher t ON t.id=tc.teacher_id" +
            " where t.id=:teacherID", nativeQuery = true)
    public List<Clazz> findClassByTeacherBySql(@Param("teacherID") String teacherID);
}
