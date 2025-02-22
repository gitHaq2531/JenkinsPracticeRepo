package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage 
{
	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;

	@FindBy(name="support_start_date")
	private WebElement startDateEdt;

	@FindBy(name="support_end_date")
	private WebElement endDateEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgImg;
	
	public WebElement getlastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrgImg() {
		return orgImg;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}
}
