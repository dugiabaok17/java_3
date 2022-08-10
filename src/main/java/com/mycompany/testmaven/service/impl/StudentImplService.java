/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmaven.service.impl;

import com.mycompany.testmaven.model.Student;
import com.mycompany.testmaven.repository.RepositoryStudent;
import com.mycompany.testmaven.service.StudentDaoInterFace;
import java.util.List;

/**
 *
 * @author DELL
 */
public class StudentImplService implements StudentDaoInterFace {

    private RepositoryStudent rs;

    public StudentImplService() {
        rs = new RepositoryStudent();
    }

    @Override
    public List<Student> getList() {
        return rs.getList();
    }

    @Override
    public String insert(Student s) {
        if (rs.insert(s)) {
            return "Insert successfully";
        } else {
            return "insert failed";
        }
    }

    @Override
    public String delete(String id) {
        if (rs.delete(id)) {
            return "delete successfully";
        } else {
            return "delete failed";
        }
    }

    @Override
    public String update(String id, Student s) {
        if (rs.update(id, s)) {
            return "update successfully";
        } else {
            return "update failed";
        }
    }

}
