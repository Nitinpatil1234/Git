package com.runner;



import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"com.stepDefinitions"},
monochrome = true, plugin = {"pretty","html:HTMLReport", "json:Reports\\JsonReports\\Cucumber.json", "junit:Reports\\JUnitReports\\Cucumber.xml"},
dryRun=false
)

public class Runner {

}
