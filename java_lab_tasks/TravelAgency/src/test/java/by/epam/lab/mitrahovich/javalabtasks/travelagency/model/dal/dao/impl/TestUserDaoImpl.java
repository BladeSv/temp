package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.opentable.db.postgres.embedded.FlywayPreparer;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.PreparedDbRule;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.User;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.UserDao;

public class TestUserDaoImpl {

	private UserDao userDao;

	@Rule
	public PreparedDbRule db = EmbeddedPostgresRules
			.preparedDatabase(FlywayPreparer.forClasspathLocation("classpath:testdb/migration"));

	public TestUserDaoImpl() {

	}

	@Before
	public void initDataBase() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.setJdbsTemplate(new JdbcTemplate(db.getTestDatabase()));
		userDao = userDaoImpl;

	}

	@Test
	public void addPositiveTest() {
		User expectedUser = new User();
		expectedUser.setId(1);
		expectedUser.setLogin("Mihail");
		expectedUser.setPassword("1234");
		userDao.add(expectedUser);
		System.out.println("asdasd");
		assertEquals(expectedUser, userDao.getById(1));
	}

//	@Override
//	public User getById(int id) {
//
//		
//	}
//
//	@Override
//	public void update(User bean) {
//	
//
//	}
//
//	@Override
//	public void remove(User bean) {
//		
//
//	}
//
//	@Override
//	public List<User> getAll() {
//
//		
//	}

}
