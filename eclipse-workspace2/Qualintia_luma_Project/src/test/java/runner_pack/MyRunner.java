package runner_pack;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features= "C:\\Users\\Admin3\\eclipse-workspace2\\luma_Project\\src\\test\\java\\test\\SignIn.feature",
		glue="step_definations"
		)
public class MyRunner {

}
