package com.springdemo.mvc.models;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @OneToOne(mappedBy = "instructorDetailProperty", cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    // * Look at the instructorDetailProperty in the Instructor class
    // * Use the info. from the Instructor class @JoinColumn
    // * Find the associated instructor
    private Instructor instructorProperty;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private int instructorId;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column
    private String hobby;

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructorProperty() {
        return instructorProperty;
    }

    public void setInstructorProperty(Instructor instructor1) {
        this.instructorProperty = instructor1;
    }
}
