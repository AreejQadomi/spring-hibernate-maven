package com.springdemo.mvc.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {

    // One-to-one mapping with instructor_detail table
    // @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetailProperty;

    // @OneToMany default -> fetch = FetchType.LAZY
    // Do not apply cascading delete
    // The best practice is to make use of Lazy loading
    @OneToMany(fetch = FetchType.LAZY,
               mappedBy = "instructorProperty",
               cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private List<Course> courses;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto increment id
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public InstructorDetail getInstructorDetailProperty() {
        return instructorDetailProperty;
    }

    public void setInstructorDetailProperty(InstructorDetail instructorDetail) {
        this.instructorDetailProperty = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Add convenient methods for Bi-directional
    public void addCourse(Course course) {
        course.setInstructorProperty(this);
        courses.add(course);
    }
}
