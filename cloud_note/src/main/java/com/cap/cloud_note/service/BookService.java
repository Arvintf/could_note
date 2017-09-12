package com.cap.cloud_note.service;

import java.util.List;

import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.util.NoteResult;

public interface BookService {
	public NoteResult<List<Book>> findBooks(String userId);
	public NoteResult<Object> savaBook(String userId,String bookName);
}
