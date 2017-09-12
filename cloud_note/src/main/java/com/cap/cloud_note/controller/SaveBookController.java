package com.cap.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.service.BookService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class SaveBookController {
	@Resource
	private BookService bookService;
	@RequestMapping("/addBook.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId, String bookName){
		NoteResult<Object> result = bookService.savaBook(userId, bookName);
		System.out.println(result);
		return result;
		
	} 
}
