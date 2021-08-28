package com.vikrant.test.framework.api.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/com/vikrant/test/framework/api/bdd",
		glue = "com.vikrant.test.framework.api.bdd",
		format = {"html:target/cucumber-html-report", "json:cucumber-json-report", "junit:target/cucumber-junit-report"}
		)
public class RunCukesTest {

}
