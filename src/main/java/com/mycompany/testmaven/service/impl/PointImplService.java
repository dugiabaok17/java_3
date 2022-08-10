/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmaven.service.impl;

import com.mycompany.testmaven.model.Point;
import com.mycompany.testmaven.model.PointCustom;
import com.mycompany.testmaven.repository.RepositoryPoint;
import com.mycompany.testmaven.service.PointDaoInterFace;
import java.util.List;

/**
 *
 * @author DELL
 */
public class PointImplService implements PointDaoInterFace {

    private RepositoryPoint rs;

    public PointImplService() {
        rs = new RepositoryPoint();
    }

    @Override
    public List<PointCustom> getList() {
        return rs.getList();
    }

    @Override
    public String insert(Point s) {
        if (rs.insert(s)) {
            return "Insert successfully";
        } else {
            return "Insert failed";
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
    public String update(Point s) {
        if (rs.update(s)) {
            return "update successfully";
        } else {
            return "update failed";
        }
    }

    @Override
    public List<PointCustom> getListTop3() {
        return rs.getListTop3();
    }

    @Override
    public List<PointCustom> getOne(String id) {
        return rs.getOneStudent(id);
    }

}
