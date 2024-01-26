package com.jspiders.smswithspringrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.smswithspringrest.pojo.Admin;
import com.jspiders.smswithspringrest.response.AdminResponse;
import com.jspiders.smswithspringrest.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/admin",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> addAdmin(@RequestBody Admin admin) {
		Admin adminToBeAdded=adminService.addAdmin(admin);
		AdminResponse adminResponse=new AdminResponse();
		adminResponse.setMessage("admin added");
		adminResponse.setAdmin(adminToBeAdded);
		adminResponse.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<AdminResponse>(adminResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody Admin admin) {
		Admin adminToBeLogin=adminService.login(admin);
		if(adminToBeLogin!=null) {
			AdminResponse adminResponse=new AdminResponse();
			adminResponse.setMessage("login successfully");
			adminResponse.setAdmin(adminToBeLogin);
			adminResponse.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<AdminResponse>(adminResponse, HttpStatus.FOUND);
		}else {
			AdminResponse adminResponse=new AdminResponse();
			adminResponse.setMessage("login unsuccessfully");
			adminResponse.setAdmin(null);
			adminResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<AdminResponse>(adminResponse,HttpStatus.NOT_FOUND);
		}
		
		
	}

}
