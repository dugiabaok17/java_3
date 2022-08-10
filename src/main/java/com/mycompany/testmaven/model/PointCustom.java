/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmaven.model;

import jdk.jfr.DataAmount;

/**
 *
 * @author DELL
 */
public class PointCustom {

    private String idStudent;
    private String nameStudent;
    private Integer english;
    private Integer java;
    private Integer php;

    public PointCustom() {
    }

    public PointCustom(String idStudent, String nameStudent, Integer english, Integer java, Integer php) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.english = english;
        this.java = java;
        this.php = php;
    }

    public PointCustom(Integer english, Integer java, Integer php) {

        this.english = english;
        this.java = java;
        this.php = php;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Integer getEnglish() {
        return english;
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

    public PointCustom(String idStudent, String nameStudent) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
    }

    public Object[] rowData() {
        return new Object[]{idStudent, nameStudent, english, java, php, getPointAverage()};
    }

    @Override
    public String toString() {
        return "PointCustom{" + "idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", english=" + english + ", java=" + java + ", php=" + php + '}';
    }

    public double getPointAverage() {
        return (double) Math.round((english + php + java) * 100 / 3) / 100;
    }

}
