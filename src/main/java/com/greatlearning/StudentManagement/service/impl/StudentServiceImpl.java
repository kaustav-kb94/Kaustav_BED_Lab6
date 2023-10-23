package com.greatlearning.StudentManagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentManagement.entity.Student;
import com.greatlearning.StudentManagement.repository.StudentRepository;
import com.greatlearning.StudentManagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);		
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudentById(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<Student> viewAllStudents() {		
		return studentRepository.findAll();
	}

	@Override
	public Student viewStudentById(Long studentId) {
		Optional<Student> st = studentRepository.findById(studentId);
		if(st.isPresent()) {
			return studentRepository.findById(studentId).get();
		}else {
			throw new RuntimeException("Student does not exist");
		}

	}

}
