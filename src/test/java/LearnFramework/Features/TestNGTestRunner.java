package LearnFramework.Features;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/LearnFramework/Features", glue="LearnFramework.StepsFile",
monochrome=true, tags="@Regression",plugin= {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
