package com.woven.grocerystore.cucumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.woven.grocerystore.cucumber.login.StepDefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/features/login.feature"},
			format = {"pretty","html:target/"},
			tags = {"@Test"}
			)
public class RunBDDTest {
    @Test
	public void check() throws InterruptedException{
	    StepDefinition.getInstance().navigate_to_the_facebook_login_page();;
		Thread.sleep(1000);
		StepDefinition.getInstance().user_logs_in_with_the_username_and_password();
		Thread.sleep(1000);
		StepDefinition.getInstance().home_page_should_be_displayed();
		}
}
