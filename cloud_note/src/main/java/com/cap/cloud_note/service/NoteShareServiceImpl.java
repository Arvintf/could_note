package com.cap.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cap.cloud_note.dao.NoteDao;
import com.cap.cloud_note.dao.NoteShareDao;
import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.entity.NoteShare;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

@Service("noteShareService")
@Transactional
public class NoteShareServiceImpl implements NoteShareService{
	@Resource
	private NoteDao noteDao;
	@Resource
	private NoteShareDao noteShareDao;
	@Transactional
	public NoteResult<Object> saveShare(String noteId) {
		NoteResult<Object> result = new NoteResult<Object>(); 
		//����noteId������Ҫ�����note
		Note note = noteDao.findById(noteId);
		String noteTitle = note.getCn_note_title();
		String noteBody = note.getCn_note_body();
		//��������ʵ��
		NoteShare noteShare = new NoteShare();
		noteShare.setCn_note_id(noteId);
		noteShare.setCn_share_body(noteBody);
		noteShare.setCn_share_title(noteTitle);
		noteShare.setCn_share_id(NoteUtil.createId());
		int row = noteShareDao.saveShare(noteShare);
		//ģ���쳣
		String str=null;
		str.length();
		if(row==1) {
			result.setStatus(0);
			result.setMsg("�ʼǷ���ɹ�");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("�ʼǷ���ʧ��");
			return result;	
		}
	}

	public NoteResult<List<NoteShare>> searchNoteShare(String content,int page) {
		NoteResult<List<NoteShare>> result = new NoteResult<List<NoteShare>>();
		Map params = new HashMap<String, Integer>();
		params.put("content", content);
		params.put("begin", (page-1)*3);
		List<NoteShare> noteShares = noteShareDao.searchNoteShare(params);
		if(noteShares.size()>=1) {
			result.setStatus(0);
			result.setMsg("��ѯ����ʼǳɹ�");
			result.setData(noteShares);
		}else {
			result.setStatus(1);
			result.setMsg("��ѯû�м�¼");
		}
		return result;
	}

}
