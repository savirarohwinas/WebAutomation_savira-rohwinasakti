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
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("the user is logged into the website")
    public void userLogin() throws InterruptedException {
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

    @When("the user clicks on the navigation button")
    public void userTapNavigationButton() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("selects the Logout option")
    public void userClickLogoutButton() throws InterruptedException {
        driver.findElement(By.id("menu_button_container")).isDisplayed();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("the user should be redirected back to the login page")
    public void userBackToLoginPage() throws InterruptedException {
        driver.findElement(By.id("login_button_container")).isDisplayed();
        String loginPage = driver.findElement(By.xpath("//*[@id='root']/div/div[1]")).getText();
        Assert.assertEquals(loginPage, "Swag Labs");
        driver.close();
    }
}