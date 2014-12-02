package com.bemach.ui;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html","junit:target/cucumber-junit/Webpage.xml", "pretty"},
				 features = "src/test/resources/com/bemach/ui/features",
				 tags = "@wip")
public class UIRunCukesTest {

}