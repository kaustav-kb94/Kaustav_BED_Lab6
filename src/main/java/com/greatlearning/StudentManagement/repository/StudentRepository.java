package com.greatlearning.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentManagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
