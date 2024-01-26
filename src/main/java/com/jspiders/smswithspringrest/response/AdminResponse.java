package com.jspiders.smswithspringrest.response;

import com.jspiders.smswithspringrest.pojo.Admin;

import lombok.Data;

@Data
public class AdminResponse {

	private String message;
	private Admin admin;
	private int status;
}
