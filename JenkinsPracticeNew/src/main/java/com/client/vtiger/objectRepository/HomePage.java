package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(linkText="Organizations")
private WebElement organizationLink;

@FindBy(linkText = "Contacts")
private WebElement contactLink;

@FindBy(xpath="//img[contains(@src,'user')]")
private WebElement userImg;

@FindBy(linkText="Sign Out")
private WebElement signOutLink;

public WebElement getOrganizationLink() {
	return organizationLink;
}

public WebElement getContactLink() {
	return contactLink;
}

public WebElement getUserImg() {
	return userImg;
}

public void getSignOutFromApp() {
	userImg.click();
	signOutLink.click();
}
}
