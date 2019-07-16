package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service;

import java.util.List;

public interface Service<T> {
	void add(T bean);

	T getById(int id);

	void update(T bean);

	void remove(T bean);

	List<T> getAll();

}
