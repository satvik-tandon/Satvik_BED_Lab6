package com.greatlearning.studentRegistrationSystem.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Component;

import com.greatlearning.studentRegistrationSystem.entity.Student;

@Component
public interface StudentService {

	public List<Student> getAllStudents();

	public Student getStudentsById(int Id);

	public Student saveStudent(Student student);

	public Student updateStudent(Student student, int Id);

	public void deleteStudentById(int Id);

}
