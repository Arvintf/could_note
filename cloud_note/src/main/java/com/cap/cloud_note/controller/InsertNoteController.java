package com.cap.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.service.NoteService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class InsertNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/addNote.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId, String bookId, String noteTitle){
		NoteResult<Object> result= noteService.insertNote(userId, bookId, noteTitle); 
		return result;
	}
}
