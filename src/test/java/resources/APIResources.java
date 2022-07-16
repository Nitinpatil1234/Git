 package resources;

//Enum is special class in java which mainly used for constant resources & methods.
public enum APIResources  {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");     //This consider as Class method and multiple method we can declare only by comma.
    
	private String resource;

	APIResources(String resource) {
		this.resource=resource;
		
	}
	
	public String getResource() {
		
		return resource;
	}
}
