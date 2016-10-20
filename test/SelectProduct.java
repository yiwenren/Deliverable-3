/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * @author yiwenren
 * As a user
 * I would like to select products 
 * So that I can purchase
 */
public class SelectProduct extends BaseTest {
    
    /*
     *Given I have searched ipad in the online store
     *When I add an ipad into the cart
     *And I go to checkout
     *Then there should be one ipad in the cart
     */
    @Test
    public void addProductToCart() {
        //searched ipad in the online store
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys("ipad" + Keys.RETURN);
        
        //go to checkout
        waitUntil(d -> d.findElement(By.xpath("//input[@name='Buy']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='Buy']")).submit();
        waitUntil(d -> d.findElement(By.linkText("Go to Checkout")).isDisplayed());
        driver.findElement(By.linkText("Go to Checkout")).click();
        
        //there should be one ipad in the cart
        waitUntil(d -> d.findElement(By.xpath("//div[@id='checkout_page_container']/div")).isDisplayed());
        WebElement productContainer = driver.findElement(By.xpath("//div[@id='checkout_page_container']/div")); 
        assertTrue(productContainer.getText().contains("Apple iPad"));
        
    }
    
    /*
     *Given there is already one ipad in the cart
     *When I remove one ipad from the cart
     *Then the cart should be empty
     */
    @Test
    public void removeProduct(){
        //select one ipad 
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys("ipad" + Keys.RETURN);
        waitUntil(d -> d.findElement(By.xpath("//input[@name='Buy']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='Buy']")).submit();
        waitUntil(d -> d.findElement(By.linkText("Go to Checkout")).isDisplayed());
        driver.findElement(By.linkText("Go to Checkout")).click();
        
        //remove one ipad
        waitUntil(d -> d.findElement(By.xpath("//td[6]")).isDisplayed());
        WebElement remove = driver.findElement(By.xpath("//td[6]/form/input[4]"));
        remove.click();
        
        //the cart should be empty
        waitUntil(d -> d.findElement(By.xpath("//article/div")).getText().equals("Oops, there is nothing in your cart."));
        
    }
    
    /*
     *Given there is already one ipad in the cart
     *When I update the quantity from 1 to 5
     *Then there should be five ipads in the cart
     */
    @Test
    public void updateCart(){
        //select one ipad
        driver.get("http://store.demoqa.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@name='s']"));
        searchBar.clear();
        searchBar.sendKeys("ipad" + Keys.RETURN);
        waitUntil(d -> d.findElement(By.xpath("//input[@name='Buy']")).isDisplayed());
        driver.findElement(By.xpath("//input[@name='Buy']")).submit();
        waitUntil(d -> d.findElement(By.linkText("Go to Checkout")).isDisplayed());
        driver.findElement(By.linkText("Go to Checkout")).click();
        
        //modify the Quantity to 3
        waitUntil(d -> d.findElement(By.xpath("//form/input")).isDisplayed());
        WebElement quantity = driver.findElement(By.xpath("//form/input"));
        quantity.clear();
        quantity.sendKeys("5");
        driver.findElement(By.xpath("//form/input[4]")).click();
        
        //The quantity should be 5
       waitUntil(d -> d.findElement(By.xpath("//form/input")).getAttribute("value").equals("5")); 
        
    }
    
    
    
}
