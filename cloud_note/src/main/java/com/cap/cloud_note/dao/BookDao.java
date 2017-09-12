package com.cap.cloud_note.dao;

import java.util.List;

import com.cap.cloud_note.entity.Book;

public interface BookDao {
	public List<Book> findByUserId(String userId);
	public int saveBook(Book book);
}
