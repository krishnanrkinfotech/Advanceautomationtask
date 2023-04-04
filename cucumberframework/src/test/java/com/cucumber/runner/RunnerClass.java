package com.cucumber.runner;

//import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\Features" }, glue = { "com.cucumber.stepdefinitions" }, plugin = {
		"pretty", "html:target/cucumber-reports","json:target/cucumber.json", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
		"timeline:test-output-thread/", "rerun:target/failscenario.txt" }, dryRun = false, monochrome = true)
public class RunnerClass {
	
}
