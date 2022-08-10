/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testmaven.service;

import com.mycompany.testmaven.model.Point;
import com.mycompany.testmaven.model.PointCustom;
import com.mycompany.testmaven.model.Student;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface PointDaoInterFace {

    public List<PointCustom> getListTop3();

    public List<PointCustom> getList();

    public List<PointCustom> getOne(String id);

    public String insert(Point s);

    public String delete(String id);

    public String update(Point s);

}
