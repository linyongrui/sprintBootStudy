package com.terry.sprintbootstudy.domain;

import com.terry.sprintbootstudy.utilities.DomainSchemaConfig;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher", schema = DomainSchemaConfig.DEMO_SCHEMA_02, catalog = DomainSchemaConfig.DEMO_SCHEMA_02)
public class Teacher {
    private String id;
    private String name;
    private Set<Clazz> Clazzs = new HashSet<Clazz>();

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

    @ManyToMany(targetEntity=Clazz.class,mappedBy="teachers")
    public Set<Clazz> getClazzs() {
        return Clazzs;
    }

    public void setClazzs(Set<Clazz> clazzs) {
        Clazzs = clazzs;
    }
}
