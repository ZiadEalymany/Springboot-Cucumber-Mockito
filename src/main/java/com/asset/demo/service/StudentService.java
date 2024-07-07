package com.asset.demo.service;

import org.springframework.stereotype.Service;

import com.asset.demo.dto.StudentDTO;
import com.asset.demo.entity.Student;

@Service
public class StudentService {

	public StudentDTO toStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(student.getName());
		studentDTO.setAge(student.getAge());
		studentDTO.setCountry(student.getCountry());

		return studentDTO;
	}
	
	public Student toStudent(StudentDTO dto) {
		Student student = new Student();
		student.setName(dto.getName());
		student.setAge(dto.getAge());
		student.setCountry(dto.getCountry());

		return student;
	}
}
