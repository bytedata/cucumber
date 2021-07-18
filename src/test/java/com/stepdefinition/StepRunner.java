package com.stepdefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/", glue = { "com.stepdefinition" }, 
plugin = {"pretty","html:target/HtmlReports"})
public class StepRunner {

}
