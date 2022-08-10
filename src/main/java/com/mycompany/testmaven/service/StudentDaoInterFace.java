/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testmaven.service;

import com.mycompany.testmaven.model.Student;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface StudentDaoInterFace {
    public List<Student> getList();
    public String insert(Student s);
    public String delete(String id);
    public String update(String id, Student s);
}
