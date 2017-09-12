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
		result.setMsg("��ѯ�ʼǳɹ�");
		result.setData(list);
		return result;
	}
	public NoteResult<Note> showNote(String noteId) {	
		NoteResult<Note> result = new NoteResult<Note>();
		Note note = noteDao.findById(noteId);
		if(note==null) {
			result.setStatus(1);
			result.setMsg("δ��ѯ�����");
			return result;
		}else {
			result.setData(note);
			result.setStatus(0);
			result.setMsg("��ȡ�ʼ���Ϣ�ɹ�");
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
			result.setMsg("���³ɹ�");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("����ʼ�ʧ��");
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
		//״̬1��normal 2��delete
		note.setCn_note_status_id("1");
		//״̬1��normal 2��favor 3��share
		note.setCn_note_type_id("1");
		int row = noteDao.insertNote(note);
		if(row==1){
			result.setStatus(0);
			result.setMsg("�ʼǴ����ɹ�");
			result.setData(note);
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("�ʼǴ���ʧ��");
			return result;
		}
		
	}
	public NoteResult<Object> deleteNote(String noteId) {
		NoteResult<Object> result = new NoteResult<Object>();
		int row = noteDao.deleteNote(noteId);
		if(row==1) {
			result.setStatus(0);
			result.setMsg("ɾ���ʼǳɹ�");
		}else {
			result.setStatus(1);
			result.setMsg("ɾ���ʼ�ʧ��");
		}
		return result;
	}

}
