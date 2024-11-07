package heroapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeTesting {

    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    // Method to set up the browser and perform actions
    public static void setupBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Soft\\Drivers\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Soft\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Soft\\Drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Unsupported browser! Please use 'chrome', 'firefox', or 'edge'.");
            return;
        }

        // Open URL
        driver.get(baseUrl);

        // Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Print the page source
        System.out.println("Page Source: " + driver.getPageSource());

        // Enter email in the email field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");

        // Enter password in the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        // Click on the Login Button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();

        // Print the current URL after login attempt
        System.out.println("Current URL after login: " + driver.getCurrentUrl());

        // Refresh the page
        driver.navigate().refresh();

        // Close the browser
        driver.quit();
    }

    // Main method to execute setup for different browsers
    public static void main(String[] args) {
        // Change this to test with other browsers
        String browser = "edge";  // You can use "chrome", "firefox", or "edge"

        // Run setupBrowser method for the selected browser
        setupBrowser(browser);
    }
}


