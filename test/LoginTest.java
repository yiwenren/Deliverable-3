/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yiwenren
 * User Story 1
 * As a user
 * I would like to log in
 * So that I can access my purchase history
 */
public class LoginTest extends BaseTest{

    /*
     *Given a correct username
     *And an correct password
     *When I try to log in with those credential
     *Then I should log in successfully
     */
    
    @Test
    public void loginSuccessfully(){
        //send correct password and username
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("YR");
        driver.findElement(By.id("pwd")).sendKeys("12345");
        driver.findElement(By.id("login")).click();
        
        //login
        By topToolBar = By.id("wp-admin-bar-my-account");
        waitUntil(d -> d.findElement(topToolBar).isDisplayed());
        assertEquals("Howdy, YR", driver.findElement(topToolBar).getText());
        
    }
            
    /*
     *Given a incorrect username
     *And an correct password
     *When I try to log in with those credential
     *Then I should receive an error message with "ERROR: Invalid login credentials." on it
     */
    @Test
    public void loginWithIncorrectName(){
        //send incorrect username and correct password
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("YR111");
        driver.findElement(By.id("pwd")).sendKeys("12345");
        driver.findElement(By.id("login")).click();
        
        By loginForm = By.xpath("//form[@id='ajax_loginform']/p");
        waitUntil(d -> d.findElement(loginForm).isDisplayed());
        assertEquals("ERROR: Invalid login credentials.", driver.findElement(loginForm).getText());
        
    }
    
            
    /*
     *Given a correct username
     *And an incorrect password
     *When I try to log in with those credential
     *Then I should receive an error message with "ERROR: Invalid login credentials." on it
     */
    @Test
    public void loginWithIncorrectPassword(){
        //send correct username and incorrect password
        driver.get("http://store.demoqa.com/products-page/your-account/");
        driver.findElement(By.id("log")).sendKeys("YR");
        driver.findElement(By.id("pwd")).sendKeys("111");
        driver.findElement(By.id("login")).click();
        
        By loginForm = By.xpath("//form[@id='ajax_loginform']/p");
        waitUntil(d -> d.findElement(loginForm).isDisplayed());
        assertEquals("ERROR: Invalid login credentials.", driver.findElement(loginForm).getText());
        
    }
    
}
