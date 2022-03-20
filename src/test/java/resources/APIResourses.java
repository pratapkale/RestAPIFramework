/**
 * 
 */
package resources;

/**
 * @author pratap.kale
 *
 */
public enum APIResourses {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resourse;

	APIResourses(String resourse) {
		this.resourse = resourse;
	}
	
	public String getResourse() {
		return resourse;
	}
	
}
