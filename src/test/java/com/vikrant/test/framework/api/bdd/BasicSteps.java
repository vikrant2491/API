package com.vikrant.test.framework.api.bdd;

import org.junit.Assert;

import com.vikrant.test.framework.api.action.APIAction;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class BasicSteps {
	
	@Given("^user creates an \"([^\"]*)\" request$")
	public void createAPIRequest(String request) throws Exception{
		try {
			boolean status = APIAction.createRequest(request);
			Assert.assertTrue("API request failed", status);
		} catch (AssertionError e) {
			throw new Exception("Assertion error occured", e);
		} catch(Exception e){
			throw new Exception("General error occured", e);
		}
		
	}
	
	@When("^user verifies the json$")
	public void verifyJson() throws Exception{
		try {
			boolean status = APIAction.verifyJson();
			Assert.assertTrue("API response not verified", status);
		} catch (AssertionError e) {
			throw new Exception("Assertion error occured", e);
		} catch(Exception e){
			throw new Exception("General error occured", e);
		}
		
	}


}
