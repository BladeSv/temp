package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean;

import org.springframework.stereotype.Component;

@Component
public class UserTour {

	private int user_id;
	private int tour_id;

	public UserTour() {

	}

	public UserTour(int user_id, int tour_id) {
		super();
		this.user_id = user_id;
		this.tour_id = tour_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTour_id() {
		return tour_id;
	}

	public void setTour_id(int tour_id) {
		this.tour_id = tour_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tour_id;
		result = prime * result + user_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTour other = (UserTour) obj;
		if (tour_id != other.tour_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "user_id: " + user_id + ", tour_id: " + tour_id;
	}

}
