package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepDefinitions {

	WebDriver driver;

@Given("user starts {string} browser")
public void user_starts_browser(String browserName) {
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
  
	
}

@Given("user launch app using url {string}")
public void user_launch_app_using_url(String url) {
	
	driver.get(url);
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   
}

@When("user enters text {string} in textbox using xpath {string}")
public void user_enters_text_in_textbox_using_xpath(String text, String xpath) {
    
	driver.findElement(By.xpath(xpath)).sendKeys(text);
}

@When("user clicks button using xpath {string}")
public void user_clicks_button_using_xpath(String xpath) {
    
	driver.findElement(By.xpath(xpath)).click();
}

@Then("user verify the title of page to be {string}")
public void user_verify_the_title_of_page_to_be(String expTitle) {
	
	Assert.assertEquals(expTitle, driver.getTitle());
    
}


}
