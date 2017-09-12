package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cap.cloud_note.dao.NoteShareDao;
import com.cap.cloud_note.entity.NoteShare;
import com.cap.cloud_note.util.NoteUtil;

import test.base.TestBase;

public class TestNoteShareDao extends TestBase {

	private NoteShareDao noteShareDao;

	@Before
	public void init() {
		noteShareDao = getContext().getBean("noteShareDao", NoteShareDao.class);
	}

	@Test // ±£¥Ê∑÷œÌ«Î«Û
	public void test() {
		NoteShare noteShare = new NoteShare();
		noteShare.setCn_share_id(NoteUtil.createId());
		noteShare.setCn_note_id(NoteUtil.createId());
		noteShare.setCn_share_body("123123132131+++++++++++++++++");
		noteShare.setCn_share_title("≤‚ ‘∑÷œÌ");
		int row = noteShareDao.saveShare(noteShare);
		System.out.println(row);
	}
//	@Test
//	public void test2() {
//		Map params = new HashMap<String, Integer>();
//		params.put("content", "≤‚ ‘");
//		params.put("begin", (2-1)*3);
//		List<NoteShare> noteShares = noteShareDao.searchNoteShare(params);
//		for (NoteShare noteShare : noteShares) {
//			System.out.println(noteShare.getCn_share_title() + "===============" 
//					+ noteShare.getCn_share_body());
//		}
//	}
}
