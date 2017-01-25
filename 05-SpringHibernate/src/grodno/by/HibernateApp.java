package grodno.by;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateApp {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		UserRepository repository = context.getBean(UserRepository.class);
		

		System.out.println("All users: ");
		for (User user : repository.findAll()) {
			System.out.println(user.getName());
		}
		
		System.out.println("\nCall custom query for id = 5: \n" + repository.findUserByCustomId(5).getName());
	}
}
