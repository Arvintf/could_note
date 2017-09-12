package com.cap.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.cap.cloud_note.entity.Note;

public interface NoteDao {
	public List<Map> findNoteByBookId(String bookId);
	public Note findById(String noteId);
	public int updateNote(Note note);
	public int insertNote(Note note);
	public int deleteNote(String noteId); 
}
