package com.collab.collabapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author Subhash
 *
 */
@Entity
@Table(name = "city")
public class City {

	@Id
	@Column(name = "city_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;

	@Column(name = "city_name", nullable = false, length = 30)
	private String cityName;

	

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
	
}
