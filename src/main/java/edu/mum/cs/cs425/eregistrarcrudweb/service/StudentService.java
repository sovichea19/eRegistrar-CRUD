package edu.mum.cs.cs425.eregistrarcrudweb.service;

import org.springframework.data.domain.Page;

import edu.mum.cs.cs425.eregistrarcrudweb.model.Student;

public interface StudentService {
    public abstract Student getStudentById(Long studentId);
    public abstract Page<Student> getAllStudentsPaged(int pageNum);
    public abstract Student saveStudent(Student student);
    public abstract void deleteStudentById(Long studentId);
}
