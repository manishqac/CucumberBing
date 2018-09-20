package com.qa.Bing;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class BingSteps {
	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	static int rowNum = 1;
	
	@Before
	public void setup() {
		ExcelUtils.setExcelFile(Constants.pathTestData + Constants.filesTestData, 0);
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\bingreport.html",false);
		test = report.startTest("test");
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
		report.flush();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
		test.log(LogStatus.INFO, "nav to bing");
		driver.get(Constants.websiteURL);
		
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
		BingHome bingHome = PageFactory.initElements(driver, BingHome.class);
		test.log(LogStatus.INFO, "search for"+arg1);
		bingHome.getSearchBox().sendKeys(arg1);
		bingHome.getSearchBox().submit();
	}

	@Then("^I can see the \"([^\"]*)\"$")
	public void i_can_see_the(String arg1)  {
	    // Write code here that turns the phrase above into concrete actions
//		BingHome bingHome = PageFactory.initElements(driver, BingHome.class);
		
		if(driver.getCurrentUrl().contains(arg1)) {
			test.log(LogStatus.PASS, "Search successful");
			ExcelUtils.setCellData("PASS", rowNum, 1);
			rowNum++;
			System.out.println(rowNum);
		}
		else {
			test.log(LogStatus.FAIL, "Search failed");
			ExcelUtils.setCellData("FAIL", rowNum, 1);
			rowNum++;
		}
		
		assertTrue(driver.getCurrentUrl().contains(arg1));
	}


}
