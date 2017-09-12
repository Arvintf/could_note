package com.cap.cloud_note.service;

import java.util.List;
import java.util.Map;

import com.cap.cloud_note.entity.NoteShare;
import com.cap.cloud_note.util.NoteResult;

public interface NoteShareService {
	public NoteResult<Object> saveShare(String noteId);
	public NoteResult<List<NoteShare>> searchNoteShare(String content,int page);
}
