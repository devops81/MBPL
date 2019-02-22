package com.intelligen.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(plugin = {"com.infostretch.qmetrytestmanager.result.TestExecution"})
public class RunIntelliGenTest {
}
