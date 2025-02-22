package com.client.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindAll({@FindBy(name="user_name"), @FindBy(xpath="//div/input[@type='text']")})
private WebElement usernameEdt;

@FindBys({@FindBy(name="user_password"), @FindBy(xpath="//input[@type='password']")})
private WebElement passwordEdt;

@FindBy(xpath="//div/input[@type='submit']")
private WebElement loginEdt;

public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getPasswordEdt() {
	return passwordEdt;
}

public WebElement getLoginEdt() {
	return loginEdt;
}

public void loginToApp(String username, String password)
{
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginEdt.click();
}
}
