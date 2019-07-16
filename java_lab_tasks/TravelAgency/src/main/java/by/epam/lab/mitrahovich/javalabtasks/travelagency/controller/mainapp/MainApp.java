package by.epam.lab.mitrahovich.javalabtasks.travelagency.controller.mainapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Hotel;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.config.AppConfig;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.UserService;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl.UserServiceImpl;

@Component

public class MainApp {

	public MainApp() {

	}

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Flyway flyway = applicationContext.getBean(Flyway.class);
//		flyway.repair();
		flyway.migrate();
		UserService userService = applicationContext.getBean(UserServiceImpl.class);

//		User user = new User();
//		user.setLogin("Mihail");
//		user.setPassword("root");
//		userService.add(user);
//		System.out.println(userService.getById(1));
//		StringBuffer f = new StringBuffer();
		Random r = new Random();
//		Faker faker = new Faker(new Locale("Ru"));
//		System.out.println(faker.name().firstName());
		File f = new File("D:\\123.sql");
//
		Lorem lor = new LoremIpsum().getInstance();

		try {
			FileWriter fw = new FileWriter(f);

			for (int i = 0; i < 100; i++) {

				String s = "INSERT INTO public.hotel (name, stars, webside, lalitude, longitude, features) VALUES ('"
						+ lor.getTitle(1) + "', '" + (r.nextInt(4) + 2) + "', '" + lor.getEmail() + "', '"
						+ r.nextInt(360) + "." + r.nextInt(10000) + "', '" + r.nextInt(360) + "." + r.nextInt(10000)
						+ "','" + Hotel.FeaturesType.values()[r.nextInt(Hotel.FeaturesType.values().length)] + "');\n";
				System.out.println(s);

				fw.write(s);
			}
			fw.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
//
//	public static String writeUser(String u) {
//
//		return "INSERT INTO public.hotel (name, stars, webside, lalitude, longitude, features) VALUES (:name, :stars, :webside, :lalitude, :longitude, :features)\n";
//	}
}
