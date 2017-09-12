package test.service;

import org.junit.Before;
import org.junit.Test;

import com.cap.cloud_note.service.NoteShareService;
import com.cap.cloud_note.util.NoteResult;

import test.base.TestBase;

public class TestNoteShareService extends TestBase {
	private NoteShareService service;
	@Before
	public void init() {
		service= getContext().getBean("noteShareService",NoteShareService.class);
	}
	@Test
	public void test() {
		NoteResult<Object> result = service.saveShare("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(result);
	}
}
