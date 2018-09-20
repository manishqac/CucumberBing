package com.qa.Bing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingHome {
	@FindBy(xpath="//*[@id=\"sb_form_q\"]")
	private WebElement searchBox;
	
	@FindBy(id="//*[@id=\"sb_form_q\"]")
	private WebElement topResult;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	public WebElement getResults() {
		return topResult;
	}
}
