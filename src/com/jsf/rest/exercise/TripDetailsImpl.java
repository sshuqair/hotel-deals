package com.jsf.rest.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.test.model.Hotel;
import com.test.model.OfferInfo;
import com.test.model.UserInfo;
import com.util.DateUtil;

public class TripDetailsImpl implements TripDetails{

	@Override
	public List<Hotel> getTripDetails(String apiUrl, HotelCriteria criteria) throws JSONException {
					
		List<Hotel> records = new ArrayList<Hotel>();
				
		try {   	
			//get json content
			String jsonStr = readUrl(apiUrl);
			
			JsonParser parser = new JsonParser();
			JsonObject element = (JsonObject)parser.parse(jsonStr);

			JsonElement responseWrapper = element.get("offerInfo");

			Gson gson = new Gson();
			OfferInfo data = gson.fromJson(responseWrapper, OfferInfo.class);
				
			responseWrapper = element.get("userInfo");
			
			UserInfo userData = gson.fromJson(responseWrapper, UserInfo.class);
			//System.out.println(userData);
									
			element = element.getAsJsonObject("offers");
			JsonArray hotelArray = element.getAsJsonArray("Hotel");
						
		    //start filtering data according to criteria   
		    Type type = new TypeToken<List<Hotel>>() {}.getType();
		    records = gson.fromJson(hotelArray, type);
	    
		        if (criteria.getDestinationName() != null && !criteria.getDestinationName().isEmpty()) {
					
		        	records = records.stream().filter(record -> record.getDestination().getCity().equals(criteria.getDestinationName())).collect(Collectors.toList());
				}			
				if (criteria.getMinTripStartDate() != null && !criteria.getMinTripStartDate().isEmpty()) {
					records = records.stream().filter(record -> 
					DateUtil.compareLessOrEqual(DateUtil.parseDate(criteria.getMinTripStartDate()),
												   DateUtil.getDate(record.getOfferDateRange().getTravelStartDate())))
					.collect(Collectors.toList());
					
				}		
				if (criteria.getMaxTripStartDate() != null && !criteria.getMaxTripStartDate().isEmpty()) {
					records = records.stream().filter(record -> 
						DateUtil.compareGreaterOrEqual(DateUtil.parseDate(criteria.getMaxTripStartDate()),
														DateUtil.getDate(record.getOfferDateRange().getTravelStartDate())))
						.collect(Collectors.toList());			
					
				}
				if (criteria.getMinStarRating() != null && criteria.getMinStarRating() > 0 && criteria.getMinStarRating() <= 5) {
					
		        	records = records.stream().filter(record -> 
		        		Double.parseDouble(record.getHotelInfo().getHotelStarRating()) >= criteria.getMinStarRating() ? true : false).collect(Collectors.toList());
				}
				if (criteria.getMaxStarRating() != null && criteria.getMaxStarRating() > 0 && criteria.getMaxStarRating() <= 5) {
					
		        	records = records.stream().filter(record -> 
		        		Double.parseDouble(record.getHotelInfo().getHotelStarRating()) <= criteria.getMaxStarRating() ? true : false).collect(Collectors.toList());
				}
				if (criteria.getMinGuestRating() != null && criteria.getMinGuestRating() > 0 && criteria.getMinGuestRating() <= 5) {
					
		        	records = records.stream().filter(record -> 
		        		record.getHotelInfo().getHotelGuestReviewRating() >= criteria.getMinGuestRating() ? true : false).collect(Collectors.toList());
				}
				if (criteria.getMaxGuestRating() != null && criteria.getMaxGuestRating() > 0 && criteria.getMaxGuestRating() <= 5) {
					
		        	records = records.stream().filter(record -> 
		        		record.getHotelInfo().getHotelGuestReviewRating() <= criteria.getMaxGuestRating() ? true : false).collect(Collectors.toList());
				}
				if (criteria.getMinTotalRate() != null && criteria.getMinTotalRate() > 0) {
					
		        	records = records.stream().filter(record -> 
		        		record.getHotelInfo().getHotelReviewTotal() >= criteria.getMinTotalRate() ? true : false).collect(Collectors.toList());
				}
				if (criteria.getMaxTotalRate() != null && criteria.getMaxTotalRate() > 0) {
					
		        	records = records.stream().filter(record -> 
		        		record.getHotelInfo().getHotelReviewTotal() <= criteria.getMaxTotalRate() ? true : false).collect(Collectors.toList());
				}	        	        
		              		    
		     
		     System.out.println(records);
			
									
		} catch (Exception ex) {
			System.err.println("Exception: " + ex.getMessage());
		}
		
		return records;
		
	}	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    }
	    catch (Exception e)
	    {
	    	throw e;
	    }
	    finally {
	        if (reader != null)
	            reader.close();
	    }
	}

}
