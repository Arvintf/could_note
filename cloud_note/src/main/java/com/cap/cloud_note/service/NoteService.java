package com.cap.cloud_note.service;

import java.util.List;
import java.util.Map;

import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>>loadNotes(String bookId);
	public NoteResult<Note> showNote(String noteId);
	public NoteResult<Object> updateNote(String noteId,String title,String body);
	public NoteResult<Object> insertNote(String userId,String bookId,String noteTitle);
	public NoteResult<Object> deleteNote(String noteId);
}
