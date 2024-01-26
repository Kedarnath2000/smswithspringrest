package com.jspiders.smswithspringrest.controller;

import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspiders.smswithspringrest.pojo.Student;
import com.jspiders.smswithspringrest.response.StudentResponse;
import com.jspiders.smswithspringrest.service.StudentService;

@Controller
@ResponseBody
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "/student",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<StudentResponse> addStudent(@RequestBody Student student) {
		Student addedStudent=studentService.addStudent(student);
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student added");
			studentResponse.setStudent(addedStudent);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getAllStudent() {
		List<Student> studens=studentService.getAllStudent();
		if(studens!=null && studens.size()>0) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("students fatched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(studens);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("students not fatched");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(path = "/student",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> getStudentById(@RequestParam long id) {
		Student student=studentService.getStudentById(id);
		if(student!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student fetched");
			studentResponse.setStudent(student);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.FOUND);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not found");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path = "/student",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> updateStudent(@RequestBody Student student) {
		Student updatedStudent=studentService.updateStudent(student);
		if(updatedStudent!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student updated");
			studentResponse.setStudent(updatedStudent);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not updated");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/student/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentResponse> deleteStudent(@PathVariable long id) {
		Student studentToBeDeleted=studentService.deleteStudent(id);
		if(studentToBeDeleted!=null) {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student deleted");
			studentResponse.setStudent(studentToBeDeleted);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.OK);
		}else {
			StudentResponse studentResponse=new StudentResponse();
			studentResponse.setMessage("student not deleted");
			studentResponse.setStudent(null);
			studentResponse.setStudents(null);
			studentResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<StudentResponse>(studentResponse, HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
