package test.dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cap.cloud_note.dao.UserDao;
import com.cap.cloud_note.entity.User;

public class Test {
	@org.junit.Test
	public void testUserDao() {
		String config= "conf/spring-mybatis.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
		User user = userDao.findByName("pc");
		System.out.println(user);
	}
	@org.junit.Test
	public void testSave() {
		String config= "conf/spring-mybatis.xml";
		ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext(config);
		UserDao userDao = ac.getBean("userDao",UserDao.class);
		User user= new User();
		user.setCn_user_id("acasdassdsassda");
		user.setCn_user_name("scott");
		user.setCn_user_password("123456");
		user.setCn_user_desc("ly");
		userDao.save(user);
	}
}
