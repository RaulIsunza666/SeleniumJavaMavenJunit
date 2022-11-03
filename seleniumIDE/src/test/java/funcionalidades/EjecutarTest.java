package funcionalidades;

/*
import cucumber.api.CucumberOptions;
import cucumber.api.junit.CucumberOptions;
*/

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/feature"},
        glue = "steps", tags = "@pruebaDos", plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class EjecutarTest {
  
}
