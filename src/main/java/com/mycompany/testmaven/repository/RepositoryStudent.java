/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testmaven.repository;

import com.mycompany.testmaven.model.Student;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DELL
 */
public class RepositoryStudent {

    public List<Student> getList() {
        Session session = configurationHibernate.getFACTORY().openSession();
//        List<Student> list = session.createCriteria(Student.class).list();

        Query query = session.createQuery("From Student");
        List<Student> list = query.getResultList();

        return list;
    }

    public List<String> getListId() {
        Session session = configurationHibernate.getFACTORY().openSession();
        Query query = session.createQuery("select id From Student");
        return query.getResultList();
    }

    public boolean insert(Student s) {
        Transaction transaction = null;
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(s);
            transaction.commit();
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    public boolean delete(String id) {
        Transaction transaction = null;
        Student s = new Student();
        s.setId(id);
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(s);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String id, Student s) {
        Transaction transaction = null;
        try ( Session session = configurationHibernate.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(id, s);
            transaction.commit();
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public static void main(String[] args) {
        RepositoryStudent rs = new RepositoryStudent();

        for (String arg : rs.getListId()) {
            System.out.println(arg);
        }
    }

}
