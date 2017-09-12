package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cap.cloud_note.dao.RelationDao;
import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.entity.User;

import test.base.TestBase;

public class TestRelationDao extends TestBase {
	private RelationDao dao;
	@Before
	public void init() {
		dao = getContext().getBean("relationDao",RelationDao.class);
	}
	@Test
	public void test() {
		User user = dao.findUserAndBooks("48595f52-b22c-4485-9244-f4004255b972");
		String name = user.getCn_user_name();
		System.out.println(user.getCn_user_password());
		List<Book> books =  user.getBooks();
		for(Book book : books) {
			System.out.println(book.getCn_notebook_name());
		}
	}
	
	@Test
	public void test1() {
		User user = dao.findUserAndBooks1("48595f52-b22c-4485-9244-f4004255b972");
		String name = user.getCn_user_name();
		System.out.println(user.getCn_user_password());
		List<Book> books =  user.getBooks();
		for(Book book : books) {
			System.out.println(book.getCn_notebook_name());
		}
	}
	
	@Test
	public void test2() {
		List<Book> books =  dao.findBookAndUser();
		for(Book book : books) {
			System.out.println(book.getUser());
		}
	}
	@Test
	public void test3() {
		List<Book> books =  dao.findBookAndUser1();
		
		for(Book book : books) {
			System.out.println(book.getUser());
			System.out.println("========="+book.getCn_notebook_name());
		}
	}
}
