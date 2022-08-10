package com.mycompany.testmaven.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "english")
    private Integer english;

    @Column(name = "java")
    private Integer java;

    @Column(name = "php")
    private Integer php;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student;

    public Point() {

    }

    public Point(Integer english, Integer java, Integer php, Student student) {
        this.english = english;
        this.java = java;
        this.php = php;
        this.student = student;
    }

    public Point(Integer id, Integer english, Integer java, Integer php, Student student) {
        this.id = id;
        this.english = english;
        this.java = java;
        this.php = php;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnglish() {
        return english;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getJava() {
        return java;
    }

    public void setJava(Integer java) {
        this.java = java;
    }

    public Integer getPhp() {
        return php;
    }

    public void setPhp(Integer php) {
        this.php = php;
    }
    public static void main(String[] args) {
        System.out.println("heh");
    }

}
