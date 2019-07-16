package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.UserTour;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.UserTourDao;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.UserTourService;

@Service
public class UserTourServiceImpl extends AbstractService implements UserTourService {

	private UserTourDao userTourDao;

	public UserTourServiceImpl() {

	}

	@Autowired
	public void setUserTourDao(UserTourDao userTourDao) {
		this.userTourDao = userTourDao;
	}

	@Override
	public void add(UserTour bean) {
		userTourDao.add(bean);

	}

	@Override
	public UserTour getById(int id) {

		return userTourDao.getById(id);
	}

	@Override
	public void update(UserTour bean) {
		userTourDao.update(bean);

	}

	@Override
	public void remove(UserTour bean) {
		userTourDao.remove(bean);

	}

	@Override
	public List<UserTour> getAll() {

		return userTourDao.getAll();
	}

}
