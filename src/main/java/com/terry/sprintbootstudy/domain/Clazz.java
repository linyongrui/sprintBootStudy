package com.terry.sprintbootstudy.domain;

import com.terry.sprintbootstudy.utilities.DomainSchemaConfig;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "class", schema = DomainSchemaConfig.DEMO_SCHEMA_01, catalog = DomainSchemaConfig.DEMO_SCHEMA_01)
public class Clazz {
    private int id;
    private String name;
    private Set<Teacher> teachers = new HashSet<Teacher>();
    private Set<Student> students = new HashSet<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity=Teacher.class)
    @JoinTable(name="teacher_class", catalog = DomainSchemaConfig.DEMO_SCHEMA_01,
            joinColumns={@JoinColumn(name="class_id")},
            inverseJoinColumns={@JoinColumn(name="teacher_id")}
    )
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @OneToMany(targetEntity=Student.class)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
