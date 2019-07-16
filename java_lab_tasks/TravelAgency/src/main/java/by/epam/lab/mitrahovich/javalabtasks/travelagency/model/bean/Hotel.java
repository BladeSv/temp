package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.bean;

import org.springframework.stereotype.Component;

@Component
public class Hotel {

	private int id;
	private String name;
	private int stars;
	private String webside;
	private long lalitude;
	private long longitude;
	private FeaturesType features;

	public Hotel() {

	}

	public Hotel(int id, String name, int stars, String webside, long lalitude, long longitude, FeaturesType features) {
		super();
		this.id = id;
		this.name = name;
		this.stars = stars;
		this.webside = webside;
		this.lalitude = lalitude;
		this.longitude = longitude;
		this.features = features;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getWebside() {
		return webside;
	}

	public void setWebside(String webside) {
		this.webside = webside;
	}

	public long getLalitude() {
		return lalitude;
	}

	public void setLalitude(long lalitude) {
		this.lalitude = lalitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public FeaturesType getFeatures() {
		return features;
	}

	public void setFeatures(FeaturesType features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (lalitude ^ (lalitude >>> 32));
		result = prime * result + (int) (longitude ^ (longitude >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + stars;
		result = prime * result + ((webside == null) ? 0 : webside.hashCode());
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
		Hotel other = (Hotel) obj;
		if (features != other.features)
			return false;
		if (id != other.id)
			return false;
		if (lalitude != other.lalitude)
			return false;
		if (longitude != other.longitude)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stars != other.stars)
			return false;
		if (webside == null) {
			if (other.webside != null)
				return false;
		} else if (!webside.equals(other.webside))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", name: " + name + ", stars: " + stars + ", webside: " + webside + ", lalitude: "
				+ lalitude + ", longitude: " + longitude + ", features:" + features.toString();
	}

	public enum FeaturesType {
		 WIFI, AIR_CONDITIONING,  ALL_INCLISIVE, SWIMMING_POOL, MINI_BAR, PARKING, CINEMA, LUXURY_ROOM, LOW_COST, JACUZZI

	}
}
