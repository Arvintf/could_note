package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.service.NoteService;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

import test.base.TestBase;

public class TestNoteService extends TestBase {
	private NoteService noteService;
	@Before
	public void init() {
		noteService = getContext().getBean("noteService", NoteService.class);
	}
	@Test
	public void test1(){
		NoteResult<List<Map>> result = noteService.loadNotes("6dc39e41-8c9e-4791-9c13-52a8e537fe64");
		System.out.println(result);
	}
	@Test
	public void test2(){
		NoteResult<Note> result = noteService.showNote("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		System.out.println(result);
	}
	@Test
	public void test3(){
		NoteResult<Object> result = noteService.updateNote("046b0110-67f9-48c3-bef3-b0b23bda9d4e", "≤‚ ‘service", "≤‚ ‘==========");
		System.out.println(result);
	}
	@Test
	public void test4(){
		NoteResult<Object> result = noteService.insertNote(NoteUtil.createId(), NoteUtil.createId(), "≤‚ ‘ÃÌº”± º«");
		System.out.println(result);
	}
}
