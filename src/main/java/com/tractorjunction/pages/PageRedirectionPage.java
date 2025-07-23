package com.tractorjunction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageRedirectionPage {

    WebDriver driver;

    public PageRedirectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 🧭 Header links
    @FindBy(css = ".headerMain.newmain-header a")
    public List<WebElement> headerLinks;

    // 🔻 Footer links (ignoring href="#")
    @FindBy(css = "footer.footer-main a[href]:not([href='#'])")
    public List<WebElement> footerLinks;

    // 🌐 All common links except header and footer
    @FindBy(css = "a:not(.headerMain a):not(footer a)")
    public List<WebElement> commonPageLinks;
}
