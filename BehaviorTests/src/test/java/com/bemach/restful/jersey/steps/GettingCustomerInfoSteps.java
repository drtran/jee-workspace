package com.bemach.restful.jersey.steps;

import static org.junit.Assert.*;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GettingCustomerInfoSteps {
	private Customer customer;

	@Given("^that a customer exists with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void that_a_customer_exists_with_and(String customerId, String companyName, 
							String contactName, String contactTitle, String phone) throws Throwable {
		/**
		 * When a service provide me with an ability to remove and add a customer record
		 * into the system, I will use that to set up my 'given' environment. For now, I ignore
		 * this.
		 * 
		 * Remember, use to 'given' tp prep the data source as opposed to clean up after a test.
		 * 
		 */
	}

	@When("^I call MongoRS service with a given \"([^\"]*)\"$")
	public void I_call_MongoRS_service_with_a_given(String customerId) throws Throwable {
		RSClient rsClient = new RSClient();
		rsClient.setUrl("http://localhost:18080/MongoRS/services/customers");
		customer = rsClient.getCustomerById(customerId);
	}

	@Then("^I should receive a customer record with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void I_should_receive_a_customer_record_with_and(String customerId, String companyName, 
							String contactName, String contactTitle, String phone) throws Throwable {
	   assertEquals(customerId, customer.getCustomerId());
	   assertEquals(companyName, customer.getCompanyName());
	   assertEquals(contactName, customer.getContactName());
	   assertEquals(contactTitle, customer.getContactTitle());
	   assertEquals(phone, customer.getPhone());
	}


}
