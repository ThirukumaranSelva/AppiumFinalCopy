package com.qa.runners;


import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/Oppo/cucumber", "summary"},
        /*tell Cucumber to use the two formatter plugins pretty, html & to print code snippets for missing step
        definitions */
        features = "src/test/resources",
        glue = "com/qa/stepdef",
        //snippets = CAMELCASE,
        /*The default option for snippets is UNDERSCORE. The way code snippets will be created by Cucumber*/
        dryRun = false,
        /*check all feature file steps have corresponding step definitions*/
        monochrome = false
        /*if you want console output from Cucumber in a readable format*/
        //   tags = "@foo and not @bar"
        /* only run the scenarios specified with specific tags*/
)
public class OppoTestNGTest extends BaseRunnerTest{

}
