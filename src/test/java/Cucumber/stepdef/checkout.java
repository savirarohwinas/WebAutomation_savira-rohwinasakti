package Cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("the user is on the checkout page of saucedemo")
    public void chckoutPageSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String getTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(getTitle, "Products");

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert,"Checkout: Your Information");
    }

    @When("the user provides their first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Savira");
    }

    @And("enters their last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Rohwinasakti");
    }

    @And("inputs the zip or postal code")
    public void inputZipPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("14045ff");
    }

    @And("clicks the Continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("the user should be redirected to the checkout overview page")
    public void userInCheckoutOverviewPage() {
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert,"Checkout: Overview");
        driver.close();
    }

}