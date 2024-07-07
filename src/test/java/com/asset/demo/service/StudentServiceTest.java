package com.asset.demo.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.asset.demo.dto.StudentDTO;
import com.asset.demo.entity.Student;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

	@Mock
	private StudentService service;

	@BeforeEach
	public void init() {
		System.out.println("in before each method");
		service = new StudentService();
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetStudentDTO() throws Exception {
		System.out.println("start testGetStudentDTO");

		Student student = new Student("Ziad", 25, "Egypt");
		
		when(service.toStudentDTO(student)).thenReturn(new StudentDTO("Ziad", 25, "Egypt"));
		
		StudentDTO studentDTO = service.toStudentDTO(student);

		assertNotNull(studentDTO);
		assertEquals(student.getName(), studentDTO.getName());
		assertEquals(student.getAge(), studentDTO.getAge());
		assertEquals(student.getCountry(), studentDTO.getCountry());

		System.out.println("done");
	}

	@Test
	public void testGetStudent() throws Exception {
		System.out.println("start testGetStudent");

		StudentDTO studentDTO = new StudentDTO("Ziad", 25, "Egypt");
		
		when(service.toStudent(studentDTO)).thenReturn(new Student("Ziad", 25, "Egypt"));
		
		Student student = service.toStudent(studentDTO);

		assertNotNull(student);
		assertEquals(studentDTO.getName(), student.getName());
		assertEquals(studentDTO.getAge(), student.getAge());
		assertEquals(studentDTO.getCountry(), student.getCountry());

		System.out.println("done");
	}

}
