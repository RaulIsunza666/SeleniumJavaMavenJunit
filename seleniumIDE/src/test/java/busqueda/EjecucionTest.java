package busqueda;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature/Busqueda.feature",glue = "steps")
public class EjecucionTest extends AbstractTestNGCucumberTests{
	

}
