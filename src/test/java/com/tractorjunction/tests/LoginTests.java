package com.tractorjunction.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tractorjunction.base.BaseTest;
import com.tractorjunction.pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testValidLogin() {
        getDriver().get(baseUrl + "login/");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginWithPassword("rajkumardalwai@tractorjunction.com", "9730535423");

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".new-btn")));

        String actualButtonText = profileButton.getText().trim();
        Assert.assertEquals(actualButtonText, "Testqa", "Login failed or button text not updated correctly");
    }
}
