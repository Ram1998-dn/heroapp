package heroapp;
/**
 *
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Set up Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current URL.
 * 5. Print the page source.
 * 6. Click on the ‘Forgot your password?’ link.
 * 7. Print the current URL.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email in the email field.
 * 11. Enter the password in the password field.
 * 12. Click on the Login Button.
 * 13. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTesting {

    // WebDriver instance
    WebDriver driver;

    // Method to set up the Chrome browser and open URL
    public void setUp(){

        driver = new ChromeDriver();

        // Open the URL
        driver.get("http://the-internet.herokuapp.com/login");

        // Print the title, current URL, and page source
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Page Source: " + driver.getPageSource());
    }
    // Method to perform login actions
    public void loginTest() {
        // Locate email and password fields and login button
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Enter email and password
        emailField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");

        // Click the login button
        loginButton.click();

        // Print the current URL after login
        System.out.println("URL after Login: " + driver.getCurrentUrl());

        // Refresh the page
        driver.navigate().refresh();
    }

    // Method to close the browser
    public void quitDown() {
        driver.quit();
    }

    // Main method to run the program
    public static void main(String[] args) {
        ChromeTesting testing = new ChromeTesting();
        testing.setUp();
        testing.loginTest();
        testing.quitDown();
    }
}
