import java.util.ArrayList;

import org.json.JSONArray;

import com.example.Example;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jsf.rest.exercise.TripDetailsImpl;
import com.test.model.Hotel;
import com.test.model.OfferInfo;
import com.test.model.Offers;
import com.test.model.UserInfo;

public class Test {
	
	public static void main(String[] args) {
		//String apiUrl = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";
		
		try {
			/*String jsonStr = TripDetailsImpl.readUrl(apiUrl);
						
			JsonParser parser = new JsonParser();
			JsonObject element = (JsonObject)parser.parse(jsonStr);

			JsonElement responseWrapper = element.get("offerInfo");

			Gson gson = new Gson();
			OfferInfo data = gson.fromJson(responseWrapper, OfferInfo.class);
			System.out.println(data);
			
			responseWrapper = element.get("userInfo");
			
			UserInfo userData = gson.fromJson(responseWrapper, UserInfo.class);
			System.out.println(userData);
						
			element = element.getAsJsonObject("offers");
			JsonArray hotelArray = element.getAsJsonArray("Hotel");
						
			System.out.println(hotelArray);*/
						
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	

}
