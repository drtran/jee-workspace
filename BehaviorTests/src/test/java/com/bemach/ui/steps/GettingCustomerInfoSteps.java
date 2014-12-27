package com.bemach.ui.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bemach.restful.jersey.steps.Customer;
import com.bemach.restful.jersey.steps.RSClient;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GettingCustomerInfoSteps {
	private String userName;
	private String password;
	private WebDriver driver;
	private String url;
	private String restURL;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	@Given("^that I am an authorized user \"([^\"]*)\" with password \"([^\"]*)\"$")
	public void that_I_am_an_authorized_user_with_password(String userName, String password) throws Throwable {
		this.userName = userName;
		this.password = password;
		this.url = System.getProperty("URL");
		this.restURL = System.getProperty("REST_URL");
		driver.get(url);
		assertEquals("Northwind Web App", driver.getTitle());
	}
	
	@Given("^that the customer exists with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\":$")
	public void that_the_customer_exists_with_and_(String customerId, String companyName, 
				String contactName, String contactTitle, String phone) throws Throwable {
		RSClient rsClient = new RSClient();
		rsClient.setUrl(restURL);
		Customer customer = rsClient.getCustomerById(customerId);
		assertNotNull(customer);
	}
	

	@When("^I am at Customer Information page$")
	public void I_am_at_Customer_Information_page() throws Throwable {
	    WebElement customerLink = driver.findElement(By.id("customersPage"));
	    customerLink.click();
	    assertEquals("Customer information", driver.getTitle());
	}

	@When("^I enter the \"([^\"]*)\"$")
	public void I_enter_the(String customerId) throws Throwable {
		WebElement custIdInput = driver.findElement(By.id("customerIdInput"));
		custIdInput.sendKeys(customerId);
	}

	@When("^I click on a retrieve button$")
	public void I_click_on_a_retrieve_button() throws Throwable {
		WebElement retrieveButton = driver.findElement(By.id("retrieveButton"));
		retrieveButton.click();
	}

	@Then("^I should see a customer record with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
	public void I_should_see_a_customer_record_with_and(String customerId, String companyName, 
			String contactName, String contactTitle, String phone) throws Throwable {
		assertEquals(customerId, driver.findElement(By.id("customerId")).getText());
		assertEquals(companyName, driver.findElement(By.id("companyName")).getText());
		assertEquals(contactName, driver.findElement(By.id("contactName")).getText());
		assertEquals(contactTitle, driver.findElement(By.id("contactTitle")).getText());
		assertEquals(phone, driver.findElement(By.id("phone")).getText());
	}


}
