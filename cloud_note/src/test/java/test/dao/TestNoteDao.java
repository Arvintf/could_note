package test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cap.cloud_note.dao.NoteDao;
import com.cap.cloud_note.entity.Note;
import com.cap.cloud_note.util.NoteUtil;
import com.sun.jmx.snmp.Timestamp;

import test.base.TestBase;

public class TestNoteDao extends TestBase {
	private NoteDao noteDao;
	@Before
	public void init() {
		noteDao = getContext().getBean("noteDao",NoteDao.class);
	}
	@Test//测试根据BookID查找notes
	public void test1() {
		List<Map> maps = noteDao.findNoteByBookId("6dc39e41-8c9e-4791-9c13-52a8e537fe64");
		for(Map map: maps) {
			System.out.println(map.get("cn_note_id")+"======"+map.get("cn_note_title"));
		}
	}
	@Test//根据noteId查找note
	public void test2() {
		Note note = noteDao.findById("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		System.out.println(note.getCn_note_body());
	}
	@Test//根据noteId查找note
	public void test3() {
		Note note = new Note();
		note.setCn_note_body("测试更新==================================");
		note.setCn_note_id("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		note.setCn_note_title("测试===================================");
		int row = noteDao.updateNote(note);  
		System.out.println(row);
	}
	@Test
	public void test4() {
		Note note = new Note();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_user_id(NoteUtil.createId());
		note.setCn_note_title("=========================");
		note.setCn_notebook_id(NoteUtil.createId());
		note.setCn_note_create_time(System.currentTimeMillis());
		int row = noteDao.insertNote(note);
		System.out.println(row+"impact");
	}
}
