package com.greatlearning.StudentManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.StudentManagement.entity.Student;
import com.greatlearning.StudentManagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listStudents(Model theModel) {

		// get Students details from db
		List<Student> theStudents = studentService.viewAllStudents();		

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "listStudents";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "studentForm";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") Long theId, Model theModel) {
		// get the Student  from the service
		Student theStudent = studentService.viewStudentById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "studentForm";			
	}


	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") Long id, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("course") String course,@RequestParam("country") String country) {

		Student theStudent;
		if(id !=0){
			theStudent=studentService.viewStudentById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else
			theStudent=new Student(firstName, lastName, course,country);
		// save the Student Record
		studentService.addStudent(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}


	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") Long theId) {

		// delete the Student Record
		studentService.deleteStudentById(theId);

		// redirect to /student/list
		return "redirect:/student/list";

	}
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
