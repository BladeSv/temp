package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Review;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.ReviewDao;
@Repository
public class ReviewDaoImpl extends AbstractDao implements ReviewDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static final String DATE_PARSE_REGEX = "dd-MM-yyyy";

	public static final String SQL_ADD_REVIEW = "INSERT INTO public.review (date, text, user_id, tour_id) VALUES (:date, :text, :user_id, :tour_id)";
	public static final String SQL_UPDATE_REVIEW = "UPDATE public.review SET date=:date, text=:text, user_id=:user_id, tour_id=:tour_id WHERE id=:id";
	public static final String SQL_GET_REVIEW_BY_ID = "SELECT id, date, text, user_id, tour_id FROM public.review WHERE id=:id";
	public static final String SQL_DELETE_REVIEW = "DELETE FROM public.review WHERE id=?";
	public static final String SQL_GET_REVIEW_ALL = "SELECT id, date, text, user_id, tour_id FROM public.review";

	public ReviewDaoImpl() {

	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void add(Review bean) {
		namedParameterJdbcTemplate.update(SQL_ADD_REVIEW, getNamedParametersReview(bean));

	}

	@Override
	public Review getById(int id) {
		return namedParameterJdbcTemplate.queryForObject(SQL_GET_REVIEW_BY_ID,
				new MapSqlParameterSource().addValue("id", id), new ReviewMapper());
	}

	@Override
	public void update(Review bean) {
		namedParameterJdbcTemplate.update(SQL_UPDATE_REVIEW, getNamedParametersReview(bean));

	}

	@Override
	public void remove(Review bean) {
		namedParameterJdbcTemplate.update(SQL_DELETE_REVIEW, new MapSqlParameterSource().addValue("id", bean.getId()));

	}

	@Override
	public List<Review> getAll() {
		return namedParameterJdbcTemplate.query(SQL_GET_REVIEW_ALL, new ReviewMapper());
	}

	private static Map<String, Object> getNamedParametersReview(Review bean) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("id", bean.getId());
		namedParameters.put("date", new SimpleDateFormat(DATE_PARSE_REGEX).format(bean.getDate()));
		namedParameters.put("text", bean.getDate());
		namedParameters.put("user_id", bean.getUser_id());
		namedParameters.put("tour_id", bean.getTour_id());

		return namedParameters;

	}

	private static final class ReviewMapper implements RowMapper<Review> {

		@Override
		public Review mapRow(ResultSet rs, int arg1) throws SQLException {
			Review review = new Review();
			review.setId(rs.getInt("id"));
			try {
				review.setDate(new SimpleDateFormat(DATE_PARSE_REGEX).parse(rs.getString("date")));
			} catch (ParseException e) {
				log.error("Set date in review - ReviewDaoImpl" + e.getStackTrace());
			}
			review.setText(rs.getString("text"));
			review.setUser_id(rs.getInt("user_id"));
			review.setTour_id(rs.getInt("tour_id"));
			return review;
		}
	}
}