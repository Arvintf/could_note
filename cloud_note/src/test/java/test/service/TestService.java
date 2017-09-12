package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cap.cloud_note.entity.User;
import com.cap.cloud_note.service.UserService;
import com.cap.cloud_note.util.NoteResult;
import com.cap.cloud_note.util.NoteUtil;

public class TestService {
	UserService userService;
	@Before
	public void init() {
		String[] config= {"conf/spring-mybatis.xml","conf/spring-mvc.xml","conf/spring-transaction.xml"};
		AbstractApplicationContext ac= new ClassPathXmlApplicationContext(config);
		userService = ac.getBean("userService",UserService.class);
	}
	@Test//����1-�����û���Ϊ��
	public void test1() {
		NoteResult<User> result = userService.checkLogin("���", "123");
		System.out.println(userService.getClass().getName());
//		System.out.println(result.getStatus()+result.getMsg()+result.getData());
	}
//	@Test
//	public void test2() {
//		NoteResult<User> result = userService.checkLogin("pc", "123");
//		System.out.println(result.getStatus()+result.getMsg()+result.getData());
//	}
//	@Test
//	public void test3() {
//		NoteResult<User> result = userService.checkLogin("pc", "123456");
//		System.out.println(result.getStatus()+result.getMsg()+result.getData());
//	}
//	@Test//�����û�������
//	public void test4() {
//		NoteResult<User> result = userService.register("scott", "123456", "ly");
//		System.out.println(result.getStatus()+result.getMsg()+result.getData());
//	}
//	@Test//�����û�������
//	public void test5() {
//		NoteResult<User> result = userService.register("scot", "123456", "ly");
//		System.out.println(result.getStatus()+result.getMsg()+result.getData());
//	}
}
