package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Hotel;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.HotelDao;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.HotelService;

@Service
public class HotelServiceImpl extends AbstractService implements HotelService {

	private HotelDao hotelDao;

	public HotelServiceImpl() {

	}

	@Autowired
	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public void add(Hotel bean) {
		hotelDao.add(bean);

	}

	@Override
	public Hotel getById(int id) {

		return hotelDao.getById(id);
	}

	@Override
	public void update(Hotel bean) {
		hotelDao.update(bean);
	}

	@Override
	public void remove(Hotel bean) {
		hotelDao.remove(bean);

	}

	@Override
	public List<Hotel> getAll() {

		return hotelDao.getAll();
	}

}
