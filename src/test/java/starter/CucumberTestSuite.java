package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Comments",
        glue = {"starter.step_defs", "starter.utils"},
        plugin = {"pretty"},
        features = "classpath:features"
)
public class CucumberTestSuite {}
