package com.sft.pages;

import com.sft.automation.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }


    public String getProductsHeading() {
        return driver.findElement(By.cssSelector("[data-test='title']")).getText();
    }

}
