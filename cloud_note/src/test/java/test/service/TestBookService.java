package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.service.BookService;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

import test.base.TestBase;

public class TestBookService extends TestBase {
	private BookService bookService;
	@Before
	public void init() {
		bookService = getContext().getBean("bookService",BookService.class);
	}
	@Test
	public void test1() {
		NoteResult<List<Book>> result = bookService.findBooks("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		System.out.println(result.getStatus()+result.getMsg()+result.getData());
	}
	@Test
	public void test2() {
		NoteResult<Object> result = bookService.savaBook(NoteUtil.createId(), "≤‚ ‘");
		System.out.println(result.getStatus()+result.getMsg()+result.getData());
	}
}
