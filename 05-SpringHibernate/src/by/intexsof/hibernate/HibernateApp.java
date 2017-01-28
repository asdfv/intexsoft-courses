package by.intexsof.hibernate;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsof.hibernate.config.Config;
import by.intexsof.hibernate.model.User;
import by.intexsof.hibernate.service.UserService;
import by.intexsof.hibernate.service.impl.UserServiceImpl;

public class HibernateApp {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = initContext();

		UserServiceImpl userService = context.getBean(UserServiceImpl.class);

		printAllUsers(userService);

		printUserById(userService, 4);

		closeContext(context);
	}

	private static void closeContext(ConfigurableApplicationContext context) {
		((ConfigurableApplicationContext) context).close();
	}

	private static void printUserById(UserService userService, int id) {
		System.out.println("\nCall custom query for id = " + id + ": \n" + userService.findUserById(id).name);
	}

	private static void printAllUsers(UserService userService) {
		System.out.println("All users: ");
		for (User user : userService.findAllUsers()) {
			System.out.println(user.name);
		}
	}

	private static AnnotationConfigApplicationContext initContext() {
		return new AnnotationConfigApplicationContext(Config.class);
	}
}
