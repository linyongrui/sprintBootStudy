package com.terry.sprintbootstudy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class SprintbootstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintbootstudyApplication.class, args);
    }


}
