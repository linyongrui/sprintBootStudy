package com.terry.sprintbootstudy.domain;

import com.terry.sprintbootstudy.utilities.DomainSchemaConfig;

import javax.persistence.*;

@Entity
@Table(name = "student", schema = DomainSchemaConfig.DEMO_SCHEMA_01, catalog = DomainSchemaConfig.DEMO_SCHEMA_01)
public class Student {
    private String id;
    private String name;
    private Clazz clazzByClassId;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false)
    public Clazz getClazzByClassId() {
        return clazzByClassId;
    }

    public void setClazzByClassId(Clazz clazzByClassId) {
        this.clazzByClassId = clazzByClassId;
    }
}
