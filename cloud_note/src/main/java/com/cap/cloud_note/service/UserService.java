package com.cap.cloud_note.service;

import com.cap.cloud_note.entity.User;
import com.cap.cloud_note.util.NoteResult;

public interface UserService {
	public NoteResult<User> checkLogin(String name,String password);
	public NoteResult<User> register(String name,String password,String nickname);
}
