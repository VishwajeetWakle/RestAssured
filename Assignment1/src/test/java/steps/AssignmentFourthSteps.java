package steps;

import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class AssignmentFourthSteps {

	@Step
	public void validateRespose(Response res, String body) {
		String resBody = res.getBody().asString();
		boolean flag = false;
		if(resBody.contains(body)) {
			flag = true;
		}
		assertThat(resBody, flag);
	}

	
	@Step
	public void validateStatusCode(Response res, int code) {
		boolean flag = false;
		String expected = Integer.toString(res.getStatusCode());
		if(res.getStatusCode() == code) {
			flag = true;
		}
		assertThat(expected, flag);
	}
}
