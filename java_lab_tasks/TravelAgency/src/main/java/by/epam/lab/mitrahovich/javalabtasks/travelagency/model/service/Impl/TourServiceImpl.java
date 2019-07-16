package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Tour;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.TourDao;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.TourService;

@Service
public class TourServiceImpl extends AbstractService implements TourService {

	private TourDao tourDao;

	public TourServiceImpl() {

	}

	@Autowired
	public void setTourDao(TourDao tourDao) {
		this.tourDao = tourDao;
	}

	@Override
	public void add(Tour bean) {
		tourDao.add(bean);

	}

	@Override
	public Tour getById(int id) {

		return tourDao.getById(id);
	}

	@Override
	public void update(Tour bean) {
		tourDao.update(bean);

	}

	@Override
	public void remove(Tour bean) {
		tourDao.remove(bean);

	}

	@Override
	public List<Tour> getAll() {

		return tourDao.getAll();
	}

}
