package com.app.servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.mapper.UserMapper;

@Service(value = "userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;




/*	@Override
	public String findByOracle() {
		// TODO Auto-generated method stub
		return userMapper.findByOracle();
	}*/

}
