package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.UserTour;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.UserTourDao;

@Repository
public class UserTourDaoImpl extends AbstractDao implements UserTourDao {

	private JdbcTemplate jdbcTemplate;

	public static final String SQL_ADD_USERTOUR = "INSERT INTO public.usertour (user_id, tour_id) VALUES (?,?)";
	public static final String SQL_UPDATE_USERTOUR = "UPDATE public.usertour SET tour_id=? WHERE user_id=?";
	public static final String SQL_GET_USERTOUR_BY_USER_ID = "SELECT user_id, tour_id FROM public.usertour WHERE user_id=?";
	public static final String SQL_DELETE_USERTOUR = "DELETE FROM public.usertour WHERE user_id=?";
	public static final String SQL_GET_USERTOUR_ALL = "SELECT user_id, tour_id FROM public.usertour";

	public UserTourDaoImpl() {

	}

	@Autowired
	public void setJdbsTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public void add(UserTour bean) {
		jdbcTemplate.update(SQL_ADD_USERTOUR, bean.getUser_id(), bean.getTour_id());

	}

	@Override
	public UserTour getById(int id) {

		return jdbcTemplate.queryForObject(SQL_GET_USERTOUR_BY_USER_ID, new Object[] { id }, (rs, rowNum) -> {
			UserTour userTour = new UserTour();
			userTour.setUser_id(id);
			userTour.setUser_id(rs.getInt("tour_id"));
			return userTour;

		});
	}

	@Override
	public void update(UserTour bean) {
		jdbcTemplate.update(SQL_UPDATE_USERTOUR, bean.getUser_id(), bean.getTour_id());

	}

	@Override
	public void remove(UserTour bean) {
		jdbcTemplate.update(SQL_DELETE_USERTOUR, bean.getUser_id());

	}

	@Override
	public List<UserTour> getAll() {
		return jdbcTemplate.query(SQL_GET_USERTOUR_ALL, (rs, rowNum) -> {
			UserTour userTour = new UserTour();
			userTour.setUser_id(rs.getInt("user_id"));
			userTour.setUser_id(rs.getInt("tour_id"));
			return userTour;
		});

	}
}
