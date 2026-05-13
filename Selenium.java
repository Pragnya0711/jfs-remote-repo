/**
 * Author       : Marri Rajamani
 * Creation Date: 13/05/2026
 * Description  : Selenium automation script to test
 *                Login and Logout functionality
 *                with valid credentials.
 */

package com.app.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginLogoutTest {

    WebDriver driver;

    @Before
    public void setUp() {

        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");

        // Launch browser
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Open application URL
        driver.get("http://localhost:8080/LoginApp/login.html");
    }

    @Test
    public void testValidLoginAndLogout() throws InterruptedException {

        // Locate username field and enter value
        WebElement username =
                driver.findElement(By.id("username"));
        username.sendKeys("admin");

        // Locate password field and enter value
        WebElement password =
                driver.findElement(By.id("password"));
        password.sendKeys("Admin@123");

        // Click Login button
        driver.findElement(By.id("loginBtn")).click();

        // Wait for dashboard page
        Thread.sleep(2000);

        // Verify successful login
        WebElement welcomeMsg =
                driver.findElement(By.id("welcomeMsg"));

        Assert.assertTrue(
                "Login failed!",
                welcomeMsg.isDisplayed()
        );

        System.out.println("✅ Login successful");

        // Click Logout
        driver.findElement(By.id("logoutBtn")).click();

        Thread.sleep(2000);

        // Verify logout by checking login button visibility
        WebElement loginBtn =
                driver.findElement(By.id("loginBtn"));

        Assert.assertTrue(
                "Logout failed!",
                loginBtn.isDisplayed()
        );

        System.out.println("✅ Logout successful");
    }

    @After
    public void tearDown() {

        // Close browser
        driver.quit();
    }
}
