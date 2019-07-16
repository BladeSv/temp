package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.User;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.UserDao;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.UserService;

@Service
public class UserServiceImpl extends AbstractService implements UserService {
	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User bean) {
		userDao.add(bean);
		log.trace("user- " + bean + " add in data base");

	}

	@Override
	public User getById(int id) {

		return userDao.getById(id);
	}

	@Override
	public void update(User bean) {
		userDao.update(bean);

	}

	@Override
	public void remove(User bean) {
		userDao.remove(bean);

	}

	@Override
	public List<User> getAll() {

		return userDao.getAll();
	}

}
