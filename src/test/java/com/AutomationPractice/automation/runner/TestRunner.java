package com.AutomationPractice.automation.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="com.AutomationPractice.automation.stepdefs", 
        tags="@SocialMedia",
        plugin = {"pretty", 
            "html:target/html/htmlreport.html",
            "json:target/json/file.json",
            "junit:target/cucumberXML.xml",
            "rerun:target/failedrerun.txt"
            
            },
        publish=true,
        monochrome = true,
        dryRun=false 
        )

public class TestRunner {
	

}
