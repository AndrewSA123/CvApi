package com.qa.util;

import org.springframework.stereotype.Component;

import com.qa.persistence.domain.Admin;
@Component
public class AdminUtil {
	
	public Admin updateAdmin(Admin adminToPersist, Admin newAdmin) {
		return adminToPersist = newAdmin;
	}

}
