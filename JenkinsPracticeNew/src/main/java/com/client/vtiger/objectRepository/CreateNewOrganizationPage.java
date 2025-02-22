package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.vtiger.WebDriverUtility.WebDriverUtils;

public class CreateNewOrganizationPage 
{
WebDriver driver;

public CreateNewOrganizationPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name="accountname")
private WebElement orgNameEdt;

@FindBy(name="phone")
private WebElement contactEdt;

@FindBy(name="accounttype")
private WebElement typeDropDown;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveButton;

public WebElement getOrgNameEdt() {
	return orgNameEdt;
}

public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getContactEdt() {
	return contactEdt;
}

public WebElement getTypeDropDown() {
	return typeDropDown;
}

public void createOrgWithOrgName(String orgName)
{
	getOrgNameEdt().sendKeys(orgName);
	getSaveButton().click();
}

public void createOrgWithOrgNameAndContact(String orgName, String contact)
{
	getOrgNameEdt().sendKeys(orgName);
	getContactEdt().sendKeys(contact);
	getSaveButton().click();
}

public void createOrgWithOrgNameAndType(String orgName, String type)
{
	WebDriverUtils wdu=new WebDriverUtils();
	getOrgNameEdt().sendKeys(orgName);
	wdu.selectByVisibleText(typeDropDown, type);
	getSaveButton().click();
}
}
