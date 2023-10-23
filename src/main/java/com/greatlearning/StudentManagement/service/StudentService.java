package com.greatlearning.StudentManagement.service;

import java.util.List;

import com.greatlearning.StudentManagement.entity.Student;

public interface StudentService {
	
	void addStudent(Student student);
	
	void updateStudent(Student student);
	
	void deleteStudentById(Long studentId);
	
	List<Student> viewAllStudents();
	
	Student viewStudentById(Long studentId);
	

}
