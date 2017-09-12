package com.cap.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.service.NoteService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/saveNote.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId,String title,String body){
		NoteResult<Object> result =noteService.updateNote(noteId, title, body);
		System.out.println(result);
		return result;
	}
}
