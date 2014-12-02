package com.bemach.ui.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GettingCustomerInfoSteps {
	@Given("^that I am an authorized user \"([^\"]*)\" with password \"([^\"]*)\"$")
	public void that_I_am_an_authorized_user_with_password(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Given("^that the customer exists with:$")
	public void that_the_customer_exists_with(DataTable arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}

	@When("^I am at Customer Information page$")
	public void I_am_at_Customer_Information_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I enter the \"([^\"]*)\"$")
	public void I_enter_the(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@When("^I click on a retrieve button$")
	public void I_click_on_a_retrieve_button() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Then("^I should see a customer record with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void I_should_see_a_customer_record_with_and(String arg1, String arg2, String arg3, String arg4, String arg5, DataTable arg6) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}


}
