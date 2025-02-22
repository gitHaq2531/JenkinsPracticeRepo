package com.client.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.vtiger.WebDriverUtility.WebDriverUtils;

public class OrganizationsPage 
{
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement createNewOrgButton;

@FindBy(name="search_field")
private WebElement searchDropDown;

@FindBy(name="search_text")
private WebElement searchEdt;

@FindBy(name="submit")
private WebElement searchButton;

public WebElement getCreateNewOrgButton() {
	return createNewOrgButton;
}

public WebElement getSearchDropDown() {
	return searchDropDown;
}

public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchButton() {
	return searchButton;
}



public void deleteOrg(WebDriverUtils wdu, String email)
{
	searchEdt.sendKeys(email);
	wdu.selectByVisibleText(searchDropDown, "Organization Name");
	searchButton.click();
	WebElement deleteLink = driver.findElement(By.xpath("//a[text()='"+email+"']/ancestor::tr[1]//a[text()='del']"));
	deleteLink.click();
	driver.switchTo().alert().accept();
}
}