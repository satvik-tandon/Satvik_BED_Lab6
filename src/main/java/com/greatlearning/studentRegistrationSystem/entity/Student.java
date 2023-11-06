package com.greatlearning.studentRegistrationSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	public int id;

	@Column 
	public String firstName;

	@Column
	public String lastName;

	@Column
	public String course;

	@Column
	public String country;
}
