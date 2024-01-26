package com.jspiders.smswithspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.smswithspringrest.pojo.Admin;
import com.jspiders.smswithspringrest.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.addAdmin(admin);
	}
	
	public Admin login(Admin admin) {
		Admin adminToBeLogin=null;
		List<Admin> admins=adminRepository.getAllAdmin();
		for(Admin ad:admins) {
			if(ad.getEmail().equals(admin.getEmail()) && ad.getPassword().equals(admin.getPassword())) {
				adminToBeLogin=ad;
			}
		}
		return adminToBeLogin;
		
	}

}
