package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage 
{
	WebDriver driver;

	public ContactsInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headName;
	
	@FindBy(xpath="//td[contains(@id,'Organization')]/a")
	private WebElement orgName;
	
	@FindBy(xpath="//span[contains(@id,'Start Date')]")
	private WebElement startDate;
	
	@FindBy(xpath="//span[contains(@id,'End Date')]")
	private WebElement endDate;
	
	public WebElement getHeadName() {
		return headName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
}
