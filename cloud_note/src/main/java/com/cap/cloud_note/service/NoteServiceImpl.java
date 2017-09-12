package com.cap.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cap.cloud_note.dao.NoteDao;
import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;
@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao noteDao;
	public NoteResult<List<Map>> loadNotes(String bookId) {
		NoteResult<List<Map>> result= new NoteResult<List<Map>>();
		List<Map> list = noteDao.findNoteByBookId(bookId);
		result.setStatus(0);
		result.setMsg("查询笔记成功");
		result.setData(list);
		return result;
	}
	public NoteResult<Note> showNote(String noteId) {	
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = noteDao.findById(noteId);
		if(note==null) {
			result.setStatus(1);
			result.setMsg("未查询到结果");
			return result;
		}else {
			result.setData(note);
			result.setStatus(0);
			result.setMsg("获取笔记信息成功");
			return result;
		}
	}
	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		NoteResult<Object> result = new NoteResult<Object>();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		int row = noteDao.updateNote(note);
		if(row==1) {
			result.setStatus(0);
			result.setMsg("更新成功");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("保存笔记失败");
			return result;
		}
	}
	public NoteResult<Object> insertNote(String userId, String bookId, String noteTitle) {
		NoteResult<Object> result = new NoteResult<Object>();
		Note note = new Note();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_user_id(userId);
		note.setCn_notebook_id(bookId);
		note.setCn_note_title(noteTitle);
		long time = System.currentTimeMillis();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		//状态1是normal 2是delete
		note.setCn_note_status_id("1");
		//状态1是normal 2是favor 3是share
		note.setCn_note_type_id("1");
		int row = noteDao.insertNote(note);
		if(row==1){
			result.setStatus(0);
			result.setMsg("笔记创建成功");
			result.setData(note);
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("笔记创建失败");
			return result;
		}
		
	}
	public NoteResult<Object> deleteNote(String noteId) {
		NoteResult<Object> result = new NoteResult<Object>();
		int row = noteDao.deleteNote(noteId);
		if(row==1) {
			result.setStatus(0);
			result.setMsg("删除笔记成功");
		}else {
			result.setStatus(1);
			result.setMsg("删除笔记失败");
		}
		return result;
	}

}
