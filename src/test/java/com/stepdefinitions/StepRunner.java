package com.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/", glue = { "com.stepdefinitions" }, plugin = {
		"pretty", "html:target/HtmlReports" })
public class StepRunner {

}
