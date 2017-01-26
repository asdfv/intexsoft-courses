package by.intexsoft.vasili;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.vasili.config.Config;
import by.intexsoft.vasili.repository.UserRepository;

public class HibernateApp {

	public static void main(String[] args) {
		ApplicationContext context = initContext();
		try {
			printAllUsers(context);
		} finally {
			closeContext(context);
		}
	}

	private static void printAllUsers(ApplicationContext context) {
		System.out.println("All users: ");
		UserRepository repository = getUserRepository(context);

		List<String> names = repository.findAll().stream().map(user -> user.name).collect(Collectors.toList());
		System.out.println(Arrays.toString(names.toArray()));
	}

	private static UserRepository getUserRepository(ApplicationContext context) {
		return context.getBean(UserRepository.class);
	}

	private static void closeContext(ApplicationContext context) {
		((ConfigurableApplicationContext) context).close();
	}

	private static ConfigurableApplicationContext initContext() {
		return new AnnotationConfigApplicationContext(Config.class);
	}
}
