package com.cap.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.service.NoteShareService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class NoteShareController {
	@Resource
	private NoteShareService noteShareService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId){
		NoteResult<Object> result = noteShareService.saveShare(noteId);
		return result;
	}
}
