package com.greatlearning.studentRegistrationSystem.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentRegistrationSystem.entity.Student;
import com.greatlearning.studentRegistrationSystem.repository.StudentRepo;
import com.greatlearning.studentRegistrationSystem.serviceInterface.StudentService;

@Service
public class StudentServiceImplementation implements StudentService{
	
	@Autowired
	StudentRepo repo;
	
	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudentsById(int Id) {
		return repo.findById(Id).get();
	}

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student, int Id) {
		Student tempStudent = getStudentsById(Id);
		tempStudent.setFirstName(student.firstName);
		tempStudent.setLastName(student.lastName);
		tempStudent.setCourse(student.course);
		tempStudent.setCountry(student.country);
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(int Id) {
		repo.deleteById(Id);
	}

}
