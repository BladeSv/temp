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

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Tour;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.TourDao;

@Repository
public class TourDaoImpl extends AbstractDao implements TourDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static final String DATE_PARSE_REGEX = "dd-MM-yyyy";

	public static final String SQL_ADD_TOUR = "INSERT INTO public.tour (photo, date, duration, description, cost, tour_type, hotel_id, coutry_id) VALUES (:photo, :date, :duration, :description, :cost, :tour_type, :hotel_id, :coutry_id)";
	public static final String SQL_UPDATE_TOUR = "UPDATE public.tour SET photo=:photo, date=:date, duration=:duration, description=:description, cost=:cost, tour_type=:tour_type, hotel_id=:hotel_id, coutry_id=:coutry_id WHERE id=:id";
	public static final String SQL_GET_TOUR_BY_ID = "SELECT id, photo, date, duration, description, cost, tour_type, hotel_id, coutry_id FROM public.tour WHERE id=:id";
	public static final String SQL_DELETE_TOUR = "DELETE FROM public.tour WHERE id=?";
	public static final String SQL_GET_TOUR_ALL = "SELECT id, photo, date, duration, description, cost, tour_type, hotel_id, coutry_id FROM public.tour";

	public TourDaoImpl() {

	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void add(Tour bean) {
		namedParameterJdbcTemplate.update(SQL_ADD_TOUR, getNamedParametersTour(bean));

	}

	@Override
	public Tour getById(int id) {
		return namedParameterJdbcTemplate.queryForObject(SQL_GET_TOUR_BY_ID,
				new MapSqlParameterSource().addValue("id", id), new TourMapper());
	}

	@Override
	public void update(Tour bean) {
		namedParameterJdbcTemplate.update(SQL_UPDATE_TOUR, getNamedParametersTour(bean));

	}

	@Override
	public void remove(Tour bean) {
		namedParameterJdbcTemplate.update(SQL_DELETE_TOUR, new MapSqlParameterSource().addValue("id", bean.getId()));

	}

	@Override
	public List<Tour> getAll() {
		return namedParameterJdbcTemplate.query(SQL_GET_TOUR_ALL, new TourMapper());
	}

	private static Map<String, Object> getNamedParametersTour(Tour bean) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("id", bean.getId());
		namedParameters.put("photo", bean.getPhoto());
		namedParameters.put("date", new SimpleDateFormat(DATE_PARSE_REGEX).format(bean.getDate()));
		namedParameters.put("duration", bean.getDuration());
		namedParameters.put("description", bean.getDescription());
		namedParameters.put("cost", bean.getCost());
		namedParameters.put("tour_type", bean.getTour_type().name());
		namedParameters.put("hotel_id", bean.getHotel_id());
		namedParameters.put("coutry_id", bean.getCoutry_id());
		return namedParameters;

	}

	private static final class TourMapper implements RowMapper<Tour> {

		@Override
		public Tour mapRow(ResultSet rs, int arg1) throws SQLException {

			Tour tour = new Tour();
			tour.setId(rs.getInt("id"));
			tour.setPhoto(rs.getString("photo"));
			try {
				tour.setDate(new SimpleDateFormat(DATE_PARSE_REGEX).parse(rs.getString("date")));
			} catch (ParseException e) {
				log.error("Set date in tour - TourDaoImpl" + e.getStackTrace());
			}
			tour.setDuration(rs.getString("duration"));
			tour.setDescription(rs.getString("description"));
			tour.setCost(rs.getDouble("cost"));
			tour.setTour_type(Tour.TourType.valueOf(rs.getString("tour_type")));
			tour.setHotel_id(rs.getInt("hotel_id"));
			tour.setCoutry_id(rs.getInt("coutry_id"));

			return tour;
		}

	}

}
