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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("the user is on the login page saucedemo")
    public void loginPageSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert,"Swag Labs");
    }

    @When("the user enters a valid username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("the user enters a valid password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("clicks the login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void userInDashboardPage() {
        String getTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(getTitle, "Products");
        driver.close();
    }

    @And("the user enters an invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
    }

    @Then("the user should see an error message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")).getText();
        Assert.assertEquals(errorLogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}