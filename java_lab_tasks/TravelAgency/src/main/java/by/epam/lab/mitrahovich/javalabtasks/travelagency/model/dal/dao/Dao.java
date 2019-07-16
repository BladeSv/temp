package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.dal.dao;

import java.util.List;

public interface Dao<T> {

	void add(T bean);

	T getById(int id);

	void update(T bean);

	void remove(T bean);

	List<T> getAll();

}
