package com.greatlearning.studentRegistrationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.studentRegistrationSystem.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{	 

}
