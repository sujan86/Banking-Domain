Feature: Login Feature

Background: User is successfully logged in
When user opens the "chrome" browser and exe "D:\\OwnPracticeProjectPrimus\\primusBank\\src\\test\\resources\\DRIVERS\\chromedriver.exe"
When user enters the url "http://primusbank.qedgetech.com/"


@SmokeTest
Scenario: Login Functionality for Valid Username and Password
When user enters "Admin" as username
When user enters "Admin" as password
When user click on Login button
Then user is on "Admin" main page and get msg as welcome to Admin 




  