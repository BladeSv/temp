package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean.User;
import by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao.UserDao;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public static final String SQL_ADD_USER = "INSERT INTO public.user (login, password) VALUES (?,?)";
	public static final String SQL_UPDATE_USER = "UPDATE public.user SET login=?, password=? WHERE id=?";
	public static final String SQL_GET_USER_BY_ID = "SELECT id,login,password FROM public.user WHERE id=?";
	public static final String SQL_DELETE_USER = "DELETE FROM public.user WHERE id=?";
	public static final String SQL_GET_USER_ALL = "SELECT id,login,password FROM public.user";

	public UserDaoImpl() {

	}

	@Autowired
	public void setJdbsTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}

	@Override
	public void add(User bean) {
		jdbcTemplate.update(SQL_ADD_USER, bean.getLogin(), bean.getPassword());
	}

	@Override
	public User getById(int id) {

		return jdbcTemplate.queryForObject(SQL_GET_USER_BY_ID, new Object[] { id }, new UserMapper());
	}

	@Override
	public void update(User bean) {
		jdbcTemplate.update(SQL_UPDATE_USER, bean.getLogin(), bean.getPassword(), bean.getId());

	}

	@Override
	public void remove(User bean) {
		jdbcTemplate.update(SQL_DELETE_USER, bean.getId());

	}

	@Override
	public List<User> getAll() {

		return jdbcTemplate.query(SQL_GET_USER_ALL, new UserMapper());
	}

	private static final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			user.setId(rs.getInt("id"));
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			return user;
		}

	}

}
