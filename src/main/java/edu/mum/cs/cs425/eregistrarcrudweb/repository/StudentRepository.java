package edu.mum.cs.cs425.eregistrarcrudweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.eregistrarcrudweb.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
