package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() {
		// Execute this code only when place id is null
		// write code that will give you place id
		StepDefinationPlace sdp = new StepDefinationPlace();
		if (StepDefinationPlace.place_id == null) {
			sdp.add_place_payload_with("B G Recidency", "Hindi", "India");
			sdp.user_calls_with_http_request("AddPlaceAPI", "POST");
			sdp.verify_place_id_created_maps_to_using("B G Recidency", "getPlaceAPI");
		}

	}

}
