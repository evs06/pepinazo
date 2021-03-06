package ejercicios;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//@Cucumber.Options(format = {"json", "html:target/cucumber"})
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/pepinazo/todoistLogin.feature",
        "src/test/java/pepinazo/todoistAddProject.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/login.json",
        "html:target/login.html"}
)


public class CucumberRunner {}
