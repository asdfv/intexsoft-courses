package hib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.repository.Repository;

public class HibernateApp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println(context.containsBean("ds"));
		System.out.println("Contex is loaded");
		
		UserRepository repository = context.getBean(UserRepository.class);
		
//		for (User user : repository.findAll()) {
//			System.out.println(user.getName());
//		}
		
	}
}
