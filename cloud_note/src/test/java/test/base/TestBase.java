package test.base;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class TestBase {
	public AbstractApplicationContext getContext() {
		String[] config= {"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		AbstractApplicationContext ac= new ClassPathXmlApplicationContext(config);
		return ac;
	}
}
