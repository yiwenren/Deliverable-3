# Deliverable-3

When I did this deliverable, I faced some issues. The reason is that I was not familiar with test methods. Here is an instance. I wanted to test whether a webElement existed, but I didn’t know how to implement it by codes. So I searched the solutions online. Then I found some people use “try catch” to solve this problem. That is, try {(driver.findElement()) catch(exception){fail()}. But I was not sure whether this was a common solution, because I didn’t see you use it in your related examples. So finally, I used method “assertNotNull” instead of “try catch” to prove whether an element exists.

The problems I met most frequently is related to the wait time. I always forgot to wait until some elements appear or wait for several seconds. So unfortunately, I experienced many test failures.      

Another problem I met was when I was testing login, my IP address was blocked because I had logged in many times, which made me depressed. I even searched different methods to try to change my IP address… But anyway, I finished my login test successfully:)





1. User Story 1     
  As a user     
  I would like to log in     
  So that I can access my purchase history

  1) Scenario 1     
        Given a correct username   
        And a correct password     
        When I try to log in with those credential       
        Then I should log in successfully

  2) Scenario 2      
        Given an incorrect username      
        And a correct password      
        When I try to log in with those credential       
        Then I should receive an error message with "ERROR: Invalid login credentials." on it

  3) Scenario 3       
        Given a correct username      
        And an incorrect password      
        When I try to log in with those credential       
        Then I should receive an error message with "ERROR: Invalid login credentials." on it


2. User Story 2      
        As a user       
        I would like to search products       
        So that I can find something I want

   1) Scenario 1       
        Given I go to the online store      
        When I try to search iPad       
        Then I should get all the iPads in the store returned

    2) Scenario 2      
        Given I go to the online store      
        When I search products which doesn't exist in the store     
        Then I will get a sorry message shown on the website

    3) Scenario 3        
        Given I go to the online store      
        When I input nothing in the search box and clicks return     
        Then there should be products shown on the website

3. User Story 3     
  As a user     
  I would like to select products      
  So that I can purchase

    1) Scenario 1      
        Given I have searched iPad in the online store      
        When I add an iPad into the cart    
        And I go to checkout    
        Then there should be one iPad in the cart

    2) Scenario 2     
        Given there is already one iPad in the cart    
        When I remove one iPad from the cart     
        Then the cart should be empty

    3) Scenario 3     
        Given there is already one iPad in the cart     
        When I update the quantity from 1 to 5     
        Then there should be five iPads in the cart

