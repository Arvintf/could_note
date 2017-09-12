package test.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cap.cloud_note.dao.BookDao;
import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.util.NoteUtil;

public class TestBookDao {
	@org.junit.Test//测试是否userId不存在
	public void test1() {
		String config= "conf/spring-mybatis.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		BookDao bookDao = ac.getBean("bookDao",BookDao.class);
		List<Book> books = bookDao.findByUserId("123");
		System.out.println(books);
	}
	@org.junit.Test//测试是否userId存在
	public void test2() {
		String config= "conf/spring-mybatis.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		BookDao bookDao = ac.getBean("bookDao",BookDao.class);
		List<Book> books = bookDao.findByUserId("52f9b276-38ee-447f-a3aa-0d54e7a736e4");
		for(Book book : books) {
			System.out.println(book);
		}
	}
	@org.junit.Test
	public void test3() {
		String config= "conf/spring-mybatis.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		BookDao bookDao = ac.getBean("bookDao",BookDao.class);
		Book book = new Book();
		book.setCn_user_id(NoteUtil.createId());
		book.setCn_notebook_id(NoteUtil.createId());
		book.setCn_notebook_name("测试新建笔记本");
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		bookDao.saveBook(book);
	}
}
