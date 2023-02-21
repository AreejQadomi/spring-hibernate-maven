package com.springdemo.mvc.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "instructor_id")
    private Instructor instructorProperty;

    // When you delete a course, also delete the reviews
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviewsProperty;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    // Look at the course_id column in the course_student table
    // For the other side (inverse), look at the student_id column in the course_student table
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentTable> studentsList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Instructor getInstructorProperty() {
        return instructorProperty;
    }

    public void setInstructorProperty(Instructor instructorProperty) {
        this.instructorProperty = instructorProperty;
    }

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public void addReview(Review review) {
        if (reviewsProperty == null) reviewsProperty = new ArrayList<>();

        reviewsProperty.add(review);
    }

    public List<Review> getReviews() {
        return reviewsProperty;
    }

    public List<StudentTable> getStudentsList() {
        return studentsList;
    }

    public void addStudent(StudentTable student) {
        if (studentsList == null) studentsList = new ArrayList<>();
        studentsList.add(student);
    }
}
