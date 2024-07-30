package steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssignmentThirdStpes {
	
	@Step
	public void validateRespose(Response res, String body) {
		String resBody = res.getBody().asString();
		boolean flag = false;
		String expected ="";
		if(resBody.contains("Operation completed successfully")) {
			expected ="Operation completed successfully";
			flag = true;
		}
		assertThat(expected, flag);
	}

	
	@Step
	public void validateStatusCode(Response res, int code) {
		boolean flag = false;
		String expected ="Restul";
		if(res.getStatusCode() == code) {
			flag = true;
		}
		assertThat(expected, flag);
	}
}
