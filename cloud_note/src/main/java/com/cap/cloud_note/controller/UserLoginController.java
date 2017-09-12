package com.cap.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.entity.User;
import com.cap.cloud_note.service.UserService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource
	private UserService userService;
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult<User> checkLogin(String name,String password) {
		NoteResult<User> result = new NoteResult<User>();
		result =  userService.checkLogin(name, password);
		return result;
	}
}
