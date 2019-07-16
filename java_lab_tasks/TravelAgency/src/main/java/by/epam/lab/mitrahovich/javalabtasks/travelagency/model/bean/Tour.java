package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Tour {

	private int id;
	private String photo;
	private Date date;
	private String duration;
	private String description;
	private double cost;
	private TourType tour_type;
	private int hotel_id;
	private int coutry_id;

	public Tour() {

	}

	public Tour(int id, String photo, Date date, String duration, String description, double cost, TourType tour_type,
			int hotel_id, int coutry_id) {
		super();
		this.id = id;
		this.photo = photo;
		this.date = date;
		this.duration = duration;
		this.description = description;
		this.cost = cost;
		this.tour_type = tour_type;
		this.hotel_id = hotel_id;
		this.coutry_id = coutry_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public TourType getTour_type() {
		return tour_type;
	}

	public void setTour_type(TourType tour_type) {
		this.tour_type = tour_type;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getCoutry_id() {
		return coutry_id;
	}

	public void setCoutry_id(int coutry_id) {
		this.coutry_id = coutry_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + coutry_id;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + hotel_id;
		result = prime * result + id;
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((tour_type == null) ? 0 : tour_type.hashCode());
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
		Tour other = (Tour) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (coutry_id != other.coutry_id)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (hotel_id != other.hotel_id)
			return false;
		if (id != other.id)
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (tour_type != other.tour_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", photo: " + photo + ", date: " + date + ", duration: " + duration + ", description: "
				+ description + ", cost: " + cost + ", tour_type: " + tour_type.toString() + ", hotel_id: " + hotel_id
				+ ", coutry_id: " + coutry_id;
	}

	public enum TourType {
		WEEKED_TOUR, CRUISE, GUIDED_TOUR, SHOP_TOUR, WEDDING_TOUR, FISHING_TOUR, 
		GASTRONOMIC_TOUR, BIKE_TOUR, AUTO_TOUR, SPA_TOUR
	}
}
