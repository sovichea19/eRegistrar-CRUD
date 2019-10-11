package edu.mum.cs.cs425.eregistrarcrudweb.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull(message = "*required")
    @Column(nullable = false, unique = true)
    private Long studentNumber;
    @NotNull@NotBlank@NotEmpty
    private String firstname;
    private String middlename;
    @NotNull@NotBlank@NotEmpty
    private String lastname;
    private Double cgpa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private Boolean isInternational;

    public Student() {
    }

    public Student(@NotNull(message = "*required") @NotBlank(message = "*required") @NotEmpty Long studentNumber, @NotNull @NotBlank @NotEmpty String firstname, String middlename, @NotNull @NotBlank @NotEmpty String lastname, Double cgpa, LocalDate enrollmentDate, Boolean isInternational) {
        this.studentNumber = studentNumber;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Student(@NotNull(message = "*required") @NotBlank(message = "*required") @NotEmpty Long studentNumber, @NotNull @NotBlank @NotEmpty String firstname, @NotNull @NotBlank @NotEmpty String lastname, LocalDate enrollmentDate) {
        this.studentNumber = studentNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.enrollmentDate = enrollmentDate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNumber=" + studentNumber +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternational=" + isInternational +
                '}';
    }
}