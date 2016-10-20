/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yiwenren
 * User Story 2
 * As a user
 * I would like to search products
 * So that I can find something I want
 */

public class SearchProduct extends BaseTest {
    
    /*
     *Given I go to the online store
     *When I try to search ipad
     *Then I should get all the ipads in the store returned
     */
    @Test
    public void searchProduct() {
        
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys("ipad" + Keys.RETURN);
        
        By productTitle = By.xpath("//h2/a");
        waitUntil(d -> d.findElement(productTitle).isDisplayed());
        assertNotNull(driver.findElement(productTitle).getText()); 
    }
    
    /*
     *Given I go to the online store
     *When I search products which doesn't exist in the store
     *Then I will get a sorry message shown on the website
     */
    @Test
    public void searchNoExistingProduct() {
        
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys("aaa" + Keys.RETURN);
        
        By message = By.xpath("//div[@id='content']/p");
        waitUntil(d -> d.findElement(message).isDisplayed());
        System.out.println(driver.findElement(message).getText());
        assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", driver.findElement(message).getText()); 
    }
    
    /*
     *Given I go to the online store
     *When I input nothing in the search box and clicks return
     *Then there should be products shown on the website
     */
    @Test
    public void inputNothingWhenSearch() {
        
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys(Keys.RETURN);
        searchBar.click();
        
        By productPrice = By.xpath("//p[2]/span");
        waitUntil(d -> d.findElement(productPrice).isDisplayed());
        assertNotNull(driver.findElement(productPrice).getText());  
    }

    
}
