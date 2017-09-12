package com.cap.cloud_note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.service.NoteService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService noteService;
	@RequestMapping("/loadNotes.do")
	@ResponseBody
	public NoteResult<List<Map>> execute(String bookId){
		NoteResult<List<Map>> result = noteService.loadNotes(bookId);
		return result;
	}
	@RequestMapping("/showNote.do")
	@ResponseBody
	public NoteResult<Note> showNote(String noteId){
		NoteResult<Note> result = noteService.showNote(noteId);
		System.out.println(result);
		return result;
	}
}
