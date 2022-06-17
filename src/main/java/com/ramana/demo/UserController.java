package com.ramana.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	JdbcTemplate jt;
	@PostMapping(path="addUser")
	public String addUser(User user) {
		
		//insert query
		String insert_query="insert into user"+"(user_id,username,email,dept,user_zone)"+"value"+"(?,?,?,?,?);";
		//return no.of rows inserted
		int rows=jt.update(insert_query,user.getUser_id(),user.getUsername(),user.getEmail(),user.getDept(),user.getUser_zone());
		
		if(rows==1) {
			return "success";//create success html page
		}
		else {
			return "error";//create error html page
		}
	}

}
