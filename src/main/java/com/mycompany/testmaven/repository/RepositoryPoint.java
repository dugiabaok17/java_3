/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmaven.repository;

import com.mycompany.testmaven.model.Point;
import com.mycompany.testmaven.model.PointCustom;
import com.mycompany.testmaven.model.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author DELL
 */
public class RepositoryPoint {

    public List<PointCustom> getList() {
        Session session = configurationHibernate.getFACTORY().openSession();
        Query query = session.createQuery("select new com.mycompany.testmaven.model.PointCustom(p.student.id,p.student.name,p.english,p.java,p.php)"
                + " from com.mycompany.testmaven.model.Point p");
        List<PointCustom> result = query.list();
        return result;
    }

    public List<PointCustom> getListTop3() {
        Session session = configurationHibernate.getFACTORY().openSession();
        Query query = session.createQuery("select new com.mycompany.testmaven.model.PointCustom("
                + "p.student.id,p.student.name,p.english,p.java,p.php) "
                + " from com.mycompany.testmaven.model.Point p "
                + "group by p.student.id,p.student.name,p.english,p.java,p.php "
                + "order by sum(p.english+p.php+p.java)/cast(3 as float) desc ").setMaxResults(3);
        List<PointCustom> result = query.list();
        return result;
    }

    public boolean insert(Point s) {
        Transaction transaction = null;
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(s);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public boolean delete(String id) {
        Transaction transaction = null;
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("delete Point where student.id = :id");
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Point p) {
        Transaction transaction = null;
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Point set english = :english,java = :java, php = :php where student.id = :id");
            query.setParameter("php", p.getJava());
            query.setParameter("english", p.getPhp());
            query.setParameter("java", p.getEnglish());
            query.setParameter("id", p.getStudent().getId());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PointCustom> getOneStudent(String id) {
        Session session = configurationHibernate.getFACTORY().openSession();

        Query query = session.createQuery("select new com.mycompany.testmaven.model.PointCustom(p.student.id,p.student.name,p.english,p.java,p.php) from com.mycompany.testmaven.model.Point p where p.student.id = :id");
        query.setParameter("id", id);
        List<PointCustom> result = query.list();
        return result;
    }

    public static void main(String[] args) {
        RepositoryPoint rp = new RepositoryPoint();
        for (PointCustom list : rp.getOneStudent("ph27911")) {
            System.out.println(list);
        }
    }
}
