package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringProgram {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		HelloWorld helloWorldBean = (HelloWorld) context.getBean("helloWorld");
		
		helloWorldBean.displayMessage();
		
		((ConfigurableApplicationContext)context).close();
	}
}
