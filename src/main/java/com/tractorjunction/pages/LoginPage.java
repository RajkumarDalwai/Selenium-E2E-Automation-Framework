package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "mobile")
    private WebElement mobileField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "otp")
    private WebElement otpField;

    @FindBy(id = "otpbtn")
    private WebElement getOtpButton;

    @FindBy(id = "loginbtn")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterMobile(String mobile) {
        mobileField.sendKeys(mobile);
    }

    public void clickGetOtp() {
        getOtpButton.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterOtp(String otp) {
        otpField.sendKeys(otp);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void loginWithPassword(String mobile, String password) {
        enterMobile(mobile);
        enterPassword(password);
        clickLogin();
    }

    public void loginWithOtp(String mobile, String otp) {
        enterMobile(mobile);
        clickGetOtp();
        enterOtp(otp);
        clickLogin();
    }
}
