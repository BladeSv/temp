package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Hotel;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.HotelDao;

@Repository
public class HotelDaoImpl extends AbstractDao implements HotelDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static final String SQL_ADD_HOTEL = "INSERT INTO public.hotel (name, stars, webside, lalitude, longitude, features) VALUES (:name, :stars, :webside, :lalitude, :longitude, :features)";
	public static final String SQL_UPDATE_HOTEL = "UPDATE public.hotel SET stars=:stars, webside=:webside, lalitude=:lalitude, longitude=:longitude, features=:features WHERE id=:id";
	public static final String SQL_GET_HOTEL_BY_ID = "SELECT id, stars, webside, lalitude, longitude, features FROM public.hotel WHERE id=:id";
	public static final String SQL_DELETE_HOTEL = "DELETE FROM public.hotel WHERE id=?";
	public static final String SQL_GET_HOTEL_ALL = "SELECT id, stars, webside, lalitude, longitude, features FROM public.hotel";

	public HotelDaoImpl() {

	}

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void add(Hotel bean) {
		namedParameterJdbcTemplate.update(SQL_ADD_HOTEL, getNamedParametersHotel(bean));

	}

	@Override
	public Hotel getById(int id) {

		return namedParameterJdbcTemplate.queryForObject(SQL_GET_HOTEL_BY_ID,
				new MapSqlParameterSource().addValue("id", id), new HotelMapper());

	}

	@Override
	public void update(Hotel bean) {
		namedParameterJdbcTemplate.update(SQL_UPDATE_HOTEL, getNamedParametersHotel(bean));
	}

	@Override
	public void remove(Hotel bean) {
		namedParameterJdbcTemplate.update(SQL_DELETE_HOTEL, new MapSqlParameterSource().addValue("id", bean.getId()));

	}

	@Override
	public List<Hotel> getAll() {

		return namedParameterJdbcTemplate.query(SQL_GET_HOTEL_ALL, new HotelMapper());
	}

	private static Map<String, Object> getNamedParametersHotel(Hotel bean) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("id", bean.getId());
		namedParameters.put("name", bean.getName());
		namedParameters.put("stars", bean.getStars());
		namedParameters.put("webside", bean.getWebside());
		namedParameters.put("lalitude", bean.getLalitude());
		namedParameters.put("longitude", bean.getLongitude());
		namedParameters.put("features", bean.getFeatures().name());
		return namedParameters;

	}

	private static final class HotelMapper implements RowMapper<Hotel> {

		@Override
		public Hotel mapRow(ResultSet rs, int arg1) throws SQLException {
			Hotel hotel = new Hotel();
			hotel.setId(rs.getInt("id"));
			hotel.setName(rs.getString("name"));
			hotel.setStars(rs.getInt("stats"));
			hotel.setWebside(rs.getString("website"));
			hotel.setLalitude(rs.getLong("lalitude"));
			hotel.setLongitude(rs.getLong("longitude"));
			hotel.setFeatures(Hotel.FeaturesType.valueOf(rs.getString("features")));
			return hotel;
		}

	}
}
