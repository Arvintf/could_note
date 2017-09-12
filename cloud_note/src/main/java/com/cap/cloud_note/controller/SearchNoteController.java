package com.cap.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cap.cloud_note.entity.NoteShare;
import com.cap.cloud_note.service.NoteShareService;
import com.cap.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class SearchNoteController {
	@Resource
	private NoteShareService noteShareService;
	
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<NoteShare>> execute(String content,int page){
		NoteResult<List<NoteShare>> result = noteShareService.searchNoteShare(content,page);
		System.out.println(result);
		return result;
		
	}
}
