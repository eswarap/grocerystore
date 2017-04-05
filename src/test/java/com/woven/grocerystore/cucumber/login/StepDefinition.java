package com.woven.grocerystore.cucumber.login;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
    String username = "admin";
	String password = "password";
	
	public static StepDefinition instance;
	public static StepDefinition getInstance(){
		if(instance == null)
			instance = new StepDefinition();
		return instance;
	}

    public	WebDriver dr;
	
	@Given("^Navigate to login page\\.$")
	public void navigate_to_the_facebook_login_page(){

		dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.get("http://node9.codenvy.io:33673/grocerystore-1.0");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@When("^User logs in with the username and password\\.$")
	public void user_logs_in_with_the_username_and_password() throws InterruptedException{
		try{
		dr.findElement(By.id("userName")).sendKeys(username);
		Thread.sleep(1000);
		dr.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(1000);
		if(username == "admin" && password == "password")
			dr.findElement(By.id("u_0_v")).click();
		else
			System.out.println("Invalid username or password");
		
		}catch(Exception e){
			System.out.println("No Internet Connection");
		}
	}
	@Then("^Home page should be displayed\\.$")
	public void home_page_should_be_displayed() throws InterruptedException{
		try{
		dr.findElement(By.xpath("//*[@id='blueBarNAXAnchor']/div[1]/div/div/div[2]/ul/li[1]/a/span")).click();
		String expected_title = "Facebook";
		String actual_title = dr.getTitle(); 
		Assert.assertEquals(expected_title, actual_title);
		}catch(Exception e){
			System.out.println("Homepage not found");
		}
	}
}
