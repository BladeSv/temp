package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Review;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.ReviewDao;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.ReviewService;

@Service
public class ReviewServiceImpl extends AbstractService implements ReviewService {

	private ReviewDao reviewDao;

	public ReviewServiceImpl() {

	}

	@Autowired
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public void add(Review bean) {
		reviewDao.add(bean);

	}

	@Override
	public Review getById(int id) {

		return reviewDao.getById(id);
	}

	@Override
	public void update(Review bean) {
		reviewDao.update(bean);

	}

	@Override
	public void remove(Review bean) {
		reviewDao.remove(bean);

	}

	@Override
	public List<Review> getAll() {

		return reviewDao.getAll();
	}

}
