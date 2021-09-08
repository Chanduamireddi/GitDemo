Feature: Login to Application

Scenario Outline: Positive test validation login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/"
And Click on login link on home page and navigate to login page
When User login with <Username> and <password>
Then User lands on landing page
And Close the Browser

Examples:
|Username         | password |
|test99@gmail.com | 123456   |
|test98@gmail.com | 123456   |