package com.mycompany.testmaven.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Serializable{

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name_student" )
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "address")
    private String address;

    @Column(name = "figure")
    private String figure;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Point> listPoint;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String name, String email, String phone, Boolean gender, String address, String figure) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.figure = figure;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public List<Point> getListPoint() {
        return listPoint;
    }

    public void setListPoint(List<Point> listPoint) {
        this.listPoint = listPoint;
    }

    public Object[] rowData() {
        return new Object[]{id, name, email, phone, gender == true ? "nam" : "nữ", address, figure};
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", address=" + address + ", figure=" + figure + ", listPoint=" + listPoint + '}';
    }

}
