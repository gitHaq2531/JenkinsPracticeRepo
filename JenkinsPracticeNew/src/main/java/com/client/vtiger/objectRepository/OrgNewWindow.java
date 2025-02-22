package com.client.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.vtiger.WebDriverUtility.WebDriverUtils;

public class OrgNewWindow 
{
	WebDriver driver;
	String email;
	public OrgNewWindow(WebDriver driver, String email) {
		this.driver = driver;
		this.email=email;
		PageFactory.initElements(driver, this);;
	}

	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	WebElement orgLink = driver.findElement(By.xpath("//a[text()='"+email+"']"));

	//business logic for org select in new window....
	public void selectOrg(WebDriverUtils wdu, String parentWid)
	{
		wdu.waitForElementToBeClickable(driver, searchEdt);
		searchEdt.click();
		searchEdt.sendKeys(email);
		searchButton.click();
		wdu.waitForElementToBePresent(driver, orgLink);
		orgLink.click();
		wdu.switchToParentWindow(driver, parentWid);
	}
	
	public void deleteOrg(WebDriverUtils wdu, String parentWid)
	{
		searchEdt.sendKeys(email);
		searchButton.click();
		wdu.waitForElementToBePresent(driver, orgLink);
		orgLink.click();
		wdu.switchToParentWindow(driver, parentWid);
	}
}
