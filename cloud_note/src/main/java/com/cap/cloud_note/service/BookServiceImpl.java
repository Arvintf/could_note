package com.cap.cloud_note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cap.cloud_note.dao.BookDao;
import com.cap.cloud_note.entity.Book;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;

	public NoteResult<List<Book>> findBooks(String userId) {
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		List<Book> books = bookDao.findByUserId(userId);
		result.setData(books);
		result.setStatus(0);
		result.setMsg("查询成功");
		return result;
	}

	public NoteResult<Object> savaBook(String userId, String bookName) {
		NoteResult<Object> result = new NoteResult<Object>();
		Book book = new Book();
		book.setCn_user_id(userId);
		book.setCn_notebook_name(bookName);
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		book.setCn_notebook_id(NoteUtil.createId());
		int row = bookDao.saveBook(book);
		if (row == 1) {
			result.setStatus(0);
			result.setMsg("创建成功");
			result.setData(book);
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("创建失败");
			return result;
		}
	}

}
