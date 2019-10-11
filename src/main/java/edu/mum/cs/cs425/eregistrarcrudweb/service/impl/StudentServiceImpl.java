package edu.mum.cs.cs425.eregistrarcrudweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.eregistrarcrudweb.model.Student;
import edu.mum.cs.cs425.eregistrarcrudweb.repository.StudentRepository;
import edu.mum.cs.cs425.eregistrarcrudweb.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNum) {
        return studentRepository.findAll(PageRequest.of(pageNum,5, Sort.by("firstname")));
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}