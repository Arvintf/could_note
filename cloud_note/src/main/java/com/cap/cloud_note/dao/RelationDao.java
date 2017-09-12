package com.cap.cloud_note.dao;

import java.util.List;

import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.entity.User;

public interface RelationDao {
	//�����������
	public User findUserAndBooks(String userId);
	
	public User findUserAndBooks1(String userId);
	
	//����һ������
	public List<Book> findBookAndUser();
	public List<Book> findBookAndUser1();
}
