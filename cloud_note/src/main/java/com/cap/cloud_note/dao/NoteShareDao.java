package com.cap.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.cap.cloud_note.entity.NoteShare;

public interface NoteShareDao {
	public int saveShare(NoteShare noteShare);
	public List<NoteShare> searchNoteShare(Map params);
}
