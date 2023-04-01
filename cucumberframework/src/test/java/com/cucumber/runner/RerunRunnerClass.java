package com.cucumber.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@target/failscenario.txt" }, glue = { "com.cucumber.stepdefinitions" }, plugin = {
		"pretty", "json:target/cucumber.json", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
		"timeline:test-output-thread/" }, dryRun = false, monochrome = true)
public class RerunRunnerClass {

}
