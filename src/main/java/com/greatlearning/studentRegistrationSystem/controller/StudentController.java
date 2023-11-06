package com.greatlearning.studentRegistrationSystem.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentRegistrationSystem.entity.Student;
import com.greatlearning.studentRegistrationSystem.serviceImplementation.StudentServiceImplementation;

@Controller
public class StudentController {

	@Autowired
	StudentServiceImplementation service;

	@GetMapping("/")
	private String start() {
		return "entry_page";
	}

	// Viewing all student
	@GetMapping("/students")
	private String viewAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}

	// Creating and saving new student entry

	@GetMapping("/students/new")
	private String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	private String saveStudent(@ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("student", student);
			return "create_student";
		}
		service.saveStudent(student);
		return "redirect:/students";
	}

	// Editing and updating existing record

	@GetMapping("/students/edit/{id}")
	private String editStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", service.getStudentsById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	private String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		student.setId(id);
		service.updateStudent(student, id);
		return "redirect:/students";
	}

	// Deleting existing record
	@GetMapping("/students/{id}")
	private String deleteTicket(@PathVariable int id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}

	// Access Denied page
	@RequestMapping(value = "/403")
	private ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", You are not authorized to access this page!!");
		} else {
			model.addObject("msg", "You are not authorized to access this page!!");
		}

		model.setViewName("access_denied");
		return model;
	}
}
