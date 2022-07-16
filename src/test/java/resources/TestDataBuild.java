package resources;

import java.util.ArrayList;
import java.util.List;

import pojo1.AddLocation;
import pojo1.Location;

public class TestDataBuild {
	
	public AddLocation addPlacePayload(String name, String language, String address)
	{
		//Serialization---Java object to Request payload
		////Serialization---Java object to Request payload
		AddLocation add = new AddLocation();
		add.setAccuracy(50);
		add.setName(name);
		add.setPhone_number("(+91) 983 893 3937");
		add.setAddress(address); 
		add.setWebsite("http://google.com");
		add.setLanguage(language);
		
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		add.setLocation(l);
		
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		add.setTypes(myList);
		return add;
	}
		
	public String deletePlacePayload(String placeId) {
		
		return "{\n\"place_id\":\""+placeId+"\"\n}";
	}
	

}
