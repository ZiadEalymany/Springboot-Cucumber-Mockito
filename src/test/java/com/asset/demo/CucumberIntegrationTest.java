package com.asset.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.asset.demo.cucumberglue" })
public class CucumberIntegrationTest {
}