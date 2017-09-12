package com.cap.cloud_note.dao;

import com.cap.cloud_note.entity.User;

public interface UserDao {
	public User findByName(String name) ;
	public void save(User user);
}
