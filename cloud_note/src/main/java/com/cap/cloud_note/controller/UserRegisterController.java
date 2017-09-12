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
public class UserRegisterController {
	@Resource
	private UserService userService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<User> execute(String name,String password,String nickname){
		NoteResult<User> result = userService.register(name, password, nickname);
		return result;
	}
}
