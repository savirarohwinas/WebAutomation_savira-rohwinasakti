package Cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Cucumber/features/",
        glue = "Cucumber.stepdef",
        plugin = {"html:target/Report_Tugas6_SaviraRohwina.html"},
        tags = "@Regression"
)
public class testrun {
}