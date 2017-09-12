package com.cap.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.service.BookService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class FindBooksController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/loadNoteBooks.do")
	@ResponseBody
	public NoteResult<List<Book>> loadNoteBooks(String userId){
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		result = bookService.findBooks(userId);
		return result;
	}
}
