package com.jspiders.smswithspringrest.response;

import java.util.List;

import com.jspiders.smswithspringrest.pojo.Student;

import lombok.Data;

@Data
public class StudentResponse {
	
	private String message;
	private Student student;
	private List<Student> students;
	private int status;
	
	
	

}
