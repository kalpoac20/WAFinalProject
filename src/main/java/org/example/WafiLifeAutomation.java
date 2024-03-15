package org.example;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WafiLifeAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "D:\\SQA\\New folder\\Chrome Stable\\chromedriver-win64\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Step 1: Visit the website
        driver.get("https://www.wafilife.com/");

        // Step 2: Login
        // Assume login credentials are stored in variables
        String username = "tasirex349@fashlend.com";
        String password = "AAWAFP15";

        WebElement loginButton = driver.findElement(By.xpath("//a[@title='আমার অ্যাকাউন্ট']"));
        loginButton.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.name("login"));
        submitButton.click();

        // Step 3: Click on "Lakhok" from the menu
        WebElement lakhokMenu = driver.findElement(By.xpath("//span[contains(text(),'লেখক')]"));
        lakhokMenu.click();

        // Step 4: Scroll down to the next page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        // Step 5: Select any author
        // Assuming there's a list of authors and we're selecting the first one
        WebElement authorLink = driver.findElement(By.xpath("//h3[normalize-space()='Manjula Chaudhary']"));
        authorLink.click();

        // Step 6: View the details of any book
        // Assuming there's a list of books and we're selecting the first one
        WebElement bookLink = driver.findElement(By.cssSelector("div[class='product_thumbnail_wrapper'] a"));
        bookLink.click();

        // Step 7: Click on "Order Korun" (Order Now)
        WebElement orderNowButton = driver.findElement(By.xpath("//div[@class='body-wrapper']//button[2]"));
        orderNowButton.click();

        // Step 8: Click on "Order Shompurnu Korun" (Complete Order)
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement completeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'অর্ডার সম্পন্ন করুন')]")));
        completeOrderButton.click();

        // Step 9: Provide billing and shipping information
        // Assuming there are input fields for billing and shipping information
        // Fill in billing information
        WebElement nameField = driver.findElement(By.name("billing_first_name"));
        nameField.sendKeys("Foysal BHai On Board");



        WebElement addressField = driver.findElement(By.id("select2-billing_state-container"));

//        // Locate the dropdown element
//        WebElement dropdown = driver.findElement(By.id("dropdownId"));
        addressField.click();

        // Create a Select object
        Select select = new Select(addressField);


        // Select by Visible Text
        select.selectByVisibleText("Faridpur");


        WebElement areaField = driver.findElement(By.id("billing_area"));
        Select select2 = new Select(areaField);
        select2.selectByVisibleText("বোয়ালমারী");
        // Select by Value
        // select.selectByValue("value1");

        // Select by Index
        // select.selectByIndex(0);
        WebElement Thikana = driver.findElement(By.xpath("//textarea[@id='billing_address_1']"));
        Thikana.sendKeys("Augmedix BangLadesh");

        WebElement onnanno = driver.findElement(By.xpath("//div[@class='body-wrapper']//button[2]"));
        onnanno.sendKeys("Please do inform before delivery");

        // Add more fields as required

        // Step 10: Log out

        WebElement AmarACC = driver.findElement(By.xpath("//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]"));
        AmarACC.click();
        WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(),'লগআউট')]"));
        logoutButton.click();

        // Close the browser session
        driver.quit();
    }
}
// A test for gihub push and commit.
