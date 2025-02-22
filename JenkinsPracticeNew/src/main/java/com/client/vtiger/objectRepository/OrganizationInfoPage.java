package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
WebDriver driver;

public OrganizationInfoPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(className="dvHeaderText")
private WebElement headName;

@FindBy(id="dtlview_Phone")
private WebElement contactName;

@FindBy(id="dtlview_Type")
private WebElement typeName;

public WebElement getHeadName() {
	return headName;
}

public WebElement getContactName() {
	return contactName;
}

public WebElement getTypeName() {
	return typeName;
}



}
