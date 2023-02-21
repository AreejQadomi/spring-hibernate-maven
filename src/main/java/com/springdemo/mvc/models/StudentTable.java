package com.springdemo.mvc.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> coursesList;



    public StudentTable() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCoursesList() {
        return coursesList;
    }

    public void addCourse(Course course) {
        if (coursesList == null) coursesList = new ArrayList<>();
        coursesList.add(course);
    }


    public StudentTable(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
