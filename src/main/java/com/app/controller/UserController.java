package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.User;
import com.app.servcie.UserService;
import com.app.util.CustomerContextHolder;


@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/insertUser")
	@ResponseBody
	public 	void insertUser(User user) {
		System.out.println();
	}
}
