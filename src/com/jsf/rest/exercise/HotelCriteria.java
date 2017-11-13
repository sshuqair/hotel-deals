package com.jsf.rest.exercise;

import java.io.Serializable;

public class HotelCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String destinationName;
	private String minTripStartDate;
	private String maxTripStartDate;
	private Integer maxStarRating;
	private Integer minStarRating;
	private Integer maxTotalRate;
	private Integer minTotalRate;
	private Integer maxGuestRating;
	private Integer minGuestRating;
	private String travelStartDate;
	private String travelEndDate;

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getMinTripStartDate() {
		return minTripStartDate;
	}

	public void setMinTripStartDate(String minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}

	public String getMaxTripStartDate() {
		return maxTripStartDate;
	}

	public void setMaxTripStartDate(String maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}

	public Integer getMaxStarRating() {
		return maxStarRating;
	}

	public void setMaxStarRating(Integer maxStarRating) {
		this.maxStarRating = maxStarRating;
	}

	public Integer getMinStarRating() {
		return minStarRating;
	}

	public void setMinStarRating(Integer minStarRating) {
		this.minStarRating = minStarRating;
	}

	public Integer getMaxTotalRate() {
		return maxTotalRate;
	}

	public void setMaxTotalRate(Integer maxTotalRate) {
		this.maxTotalRate = maxTotalRate;
	}

	public Integer getMinTotalRate() {
		return minTotalRate;
	}

	public void setMinTotalRate(Integer minTotalRate) {
		this.minTotalRate = minTotalRate;
	}

	public Integer getMaxGuestRating() {
		return maxGuestRating;
	}

	public void setMaxGuestRating(Integer maxGuestRating) {
		this.maxGuestRating = maxGuestRating;
	}

	public Integer getMinGuestRating() {
		return minGuestRating;
	}

	public void setMinGuestRating(Integer minGuestRating) {
		this.minGuestRating = minGuestRating;
	}

	public String getTravelStartDate() {
		return travelStartDate;
	}

	public void setTravelStartDate(String travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	public String getTravelEndDate() {
		return travelEndDate;
	}

	public void setTravelEndDate(String travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
}
