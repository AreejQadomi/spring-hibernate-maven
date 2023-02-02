package com.springdemo.mvc.models;

import com.springdemo.mvc.validators.CourseCode;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
public class Student {
    @NotNull(message = "null - is required")
    @Size(min = 1, max = 14, message = "is required")
    private String firstName;
    private String lastName;

    @NotNull(message = "null - is required")
    @Min(value = 15, message = "Must be 15 years or older!")
    @Max(value = 61, message = "Must be younger than 60 years!")
    private Integer age;

    private String country;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;
    private String language;

    private String[] operatingSystem;

    @CourseCode(value = "LUV", message = "must starts with LUV")
    private String courseCode;

    public Student() {
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


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryDisplayName() {
//        return CountryUtil.COUNTRY_OPTIONS.containsKey(this.country)
//                ? CountryUtil.COUNTRY_OPTIONS.get(this.country)
//                : "";

        return "";
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
