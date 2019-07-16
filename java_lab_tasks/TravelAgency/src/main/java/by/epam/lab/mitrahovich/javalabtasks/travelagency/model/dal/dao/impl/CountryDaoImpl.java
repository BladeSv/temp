package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.Country;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.CountryDao;

@Repository
public class CountryDaoImpl extends AbstractDao implements CountryDao {

	private JdbcTemplate jdbcTemplate;

	public static final String SQL_ADD_COUNTRY = "INSERT INTO public.country (name) VALUES (?)";
	public static final String SQL_GET_COUNTRY_BY_ID = "SELECT id,name FROM public.country WHERE id=?";
	public static final String SQL_UPDATE_COUNTRY = "UPDATE public.country SET name=? WHERE id=?";
	public static final String SQL_DELETE_COUNTRY = "DELETE FROM public.country WHERE id=?";
	public static final String SQL_GET_COUNTRY_ALL = "SELECT id,name FROM public.country";

	public CountryDaoImpl() {

	}

	@Autowired
	public void setJdbsTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public void add(Country bean) {
		jdbcTemplate.update(SQL_ADD_COUNTRY, bean.getName());
	}

	@Override
	public Country getById(int id) {
		return jdbcTemplate.queryForObject(SQL_GET_COUNTRY_BY_ID, new Object[] { id }, new CountryMapper());

	}

	@Override
	public void update(Country bean) {
		jdbcTemplate.update(SQL_UPDATE_COUNTRY, bean.getName(), bean.getId());

	}

	@Override
	public void remove(Country bean) {
		jdbcTemplate.update(SQL_DELETE_COUNTRY, bean.getId());

	}

	@Override
	public List<Country> getAll() {
		return jdbcTemplate.query(SQL_GET_COUNTRY_ALL, new CountryMapper());
	}

	private static final class CountryMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int arg1) throws SQLException {

			Country country = new Country();
			country.setId(rs.getInt("id"));
			country.setName(rs.getString("name"));
			return country;
		}

	}
}
