package com.jsf.rest.exercise;

import java.util.List;

import org.json.JSONException;
//import org.json.JSONObject;

//import com.jsf.rest.exercise.TripBean.OfferDateContent;
import com.test.model.Hotel;

public interface TripDetails {
	
	List<Hotel> getTripDetails(String apiUrl, HotelCriteria criteria) throws JSONException;
}
