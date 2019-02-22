package com.intelligen.cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinitionIntelliGen {
	WebDriver driver = null;

	public StepDefinitionIntelliGen() {
		super();
		String exePath = "C:\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		this.driver =  new ChromeDriver();
		
	}
	@Given("^Once The Page Load$")
    public void Once_The_Page_Load() throws Throwable {
		//driver.get("http://google.com"); 
		  
		driver.get("http://35.154.85.200:6060/devops/index.html"); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
   @Then("^Verify The Genpact Logo Is Present$")
    public void Verify_The_Genpact_Logo_Is_Present() throws Throwable {
	  /* System.err.println(driver.findElement(By.name("q")));
	   System.err.println(driver.findElement(By.name("q")).getTagName()); */
	   System.err.println(driver.findElement(By.name("logo")));
	   System.err.println(driver.findElement(By.name("logo")).getTagName()); 
	   driver.close();
    }
   
   @Then("^Verify Login Text Box Is Present$")
   public void Verify_Login_Text_Box_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("empId")));
	   System.err.println(driver.findElement(By.name("empId")).getTagName()); 
	   driver.close();
   }
   
   @Then("^Verify Password Text Box Is Present$")
   public void Verify_Password_Text_Box_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("password")));
	   System.err.println(driver.findElement(By.name("password")).getTagName()); 
	   driver.close();
   }
   
   @Then("^Verify Page Heading Is Present$")
   public void Verify_Page_Heading_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("pageHeading")));
	   System.err.println(driver.findElement(By.name("pageHeading")).getTagName()); 
	   driver.close();
   }
   
   @Then("^Verify Application Count Is Present$")
   public void Verify_Application_Count_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("appCount")));
	   System.err.println(driver.findElement(By.name("appCount")).getTagName()); 
	   driver.close();
   }
   
   @Then("^Verify Tool Version Is Present$")
   public void Verify_Tool_Version_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("toolVer")));
	   System.err.println(driver.findElement(By.name("toolVer")).getTagName()); 
	   driver.close();
   }
   
   @Then("^Verify About DevOps Heading Is Present$")
   public void Verify_About_DevOps_Heading_Is_Present() throws Throwable {
	   System.err.println(driver.findElement(By.name("aboutDevOps")));
	   System.err.println(driver.findElement(By.name("aboutDevOps")).getTagName()); 
	   driver.close();
   }
   @Then("^Verify That Login Text Box Is Empty$")
   public void Verify_That_Password_Login_Box_Is_Empty() throws Throwable {
	   System.err.println(driver.findElement(By.name("empId")));
	   System.err.println(driver.findElement(By.name("empId")).getTagName()); 
	   driver.close();
   }
   @Then("^Verify That Password Text Box Is Empty$")
   public void Verify_That_Password_Text_Box_Is_Empty() throws Throwable {
	   System.err.println(driver.findElement(By.name("password")));
	   System.err.println(driver.findElement(By.name("password")).getTagName()); 
	   driver.close();
   }
}
