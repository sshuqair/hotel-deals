package com.jsf.rest.exercise;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.json.JSONException;

import com.test.model.Hotel;
import com.util.DateUtil;

@ManagedBean
@SessionScoped
public class TripBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String destinationName;
	private Date minTripStartDate;
	private Date maxTripStartDate;
	private Integer maxStarRating;
	private Integer minStarRating;
	private Integer maxTotalRate;
	private Integer minTotalRate;
	private Integer maxGuestRating;
	private Integer minGuestRating;
	private String travelStartDate;
	private String travelEndDate;
	private List<Hotel> hotelList;
	
	public String submit() {
		try {
			
			TripDetails detailsService = new TripDetailsImpl();
			String apiUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
			
			//Fill criteria object
			HotelCriteria criteria = new HotelCriteria();
									
			String destName = getDestinationName();
			
			criteria.setDestinationName(destName);
			criteria.setMinTripStartDate(DateUtil.formatDate(getMinTripStartDate()));
			criteria.setMaxTripStartDate(DateUtil.formatDate(getMaxTripStartDate()));
			criteria.setMinStarRating(minStarRating);
			criteria.setMaxStarRating(maxStarRating);
			criteria.setMinGuestRating(minGuestRating);
			criteria.setMaxGuestRating(maxGuestRating);
			criteria.setMinTotalRate(minTotalRate);
			criteria.setMaxTotalRate(maxTotalRate);

						
			// get required data
			List<Hotel> content = detailsService.getTripDetails(apiUrl, criteria);
			setHotelList(content);
						
		} catch (JSONException | NullPointerException e) {
			e.printStackTrace();
			// redirect to not found page
			return "notfound.xhtml";
		}
		return "result.xhtml";
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

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
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

	public List<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public Date getMinTripStartDate() {
		return minTripStartDate;
	}

	public void setMinTripStartDate(Date minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}

	public Date getMaxTripStartDate() {
		return maxTripStartDate;
	}

	public void setMaxTripStartDate(Date maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}

}
