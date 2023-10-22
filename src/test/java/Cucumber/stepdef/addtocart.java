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

public class addtocart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user is on the products page of saucedemo")
    public void productsPageSaucedemo() {
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
    }

    @When("the user clicks the Add to Cart button for the product Sauce Labs Backpack")
    public void clickAddToCartButtonForSauceLabsBackpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("the shopping cart badge should display 1 item")
    public void shoppingCartBadgeBecomes() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String productPageAssert = driver.findElement(By.xpath("//span[contains(text(),1)]")).getText();
        Assert.assertEquals(productPageAssert,"1");
    }

    @And("the user clicks the shopping cart icon")
    public void clickCartButton() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("the user should be redirected to the shopping cart page")
    public void userInCartPage() {
        String productPageAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assert.assertEquals(productPageAssert,"Your Cart");
        driver.close();
    }
}