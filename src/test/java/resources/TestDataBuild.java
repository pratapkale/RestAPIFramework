package resources;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address) {
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);

		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");

		AddPlace addPlace = new AddPlace();
		addPlace.setAccuracy(50);
		addPlace.setAddress(address);
		addPlace.setLanguage(language);
		addPlace.setName(name);
		addPlace.setPhone_number("(+91) 983 893 3937");
		addPlace.setWebsite("http://google.com");
		addPlace.setLocation(location);
		addPlace.setTypes(types);
		
		return addPlace;
	}
	
	public String deletePlacePayload(String placeId) {
		
		return "{\r\n"
				+ "\"place_id\": \""+placeId+"\"\r\n"
				+ "}";
		
	}

}
