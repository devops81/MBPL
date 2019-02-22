package com.intelligen.cucumber;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.AssertionFailedError;
import cucumber.api.java.After;
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
//import org.testng.annotations.AfterMethod;

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
		driver.manage().window().maximize();
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
   
   @Then("^Verify For Subscribe News Letter$")
   public void Verify_For_Subscribe_News_Letter() throws Throwable {
   //driver.findElement(By.linkText("Demo-github-Proj")).click();
	   driver.manage().window().maximize();
	   driver.get("http://35.154.85.200:6060/devops/index.html"); 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Thread.sleep(10000);
	 
	   driver.findElement(By.id("newsID")).click();
	   Thread.sleep(3000);
	   driver.findElement(By.id("name")).sendKeys("I am not a robot");
	   Thread.sleep(3000);
	   driver.findElement(By.id("email")).sendKeys("devops@genpact.com");
	   Thread.sleep(3000);
	   
	   //Code is written to move element to message box
	   Actions act = new Actions(driver);
	   act.moveToElement(driver.findElement(By.id("message"))).perform();
	   //
	   driver.findElement(By.id("message")).sendKeys("Need help on DevOps"); 
	   driver.quit();
     }
  
  
   @Then("^Textbox Validation Visit office$")
   public void Textbox_Validation() throws Throwable {
	   driver.get("http://35.154.85.200:6060/devops/index.html");
	   Thread.sleep(10000);
	   driver.findElement(By.id("contactus")).click();
	   Thread.sleep(3000);
	   Actions act = new Actions(driver);
	   act.moveToElement(driver.findElement(By.id("email_1"))).perform();
	   
	   WebElement emailField = driver.findElement(By.id("email_1"));
	   emailField.sendKeys("IntelliGENdevops@genpact.com");
	   
	   WebElement nameField = driver.findElement(By.id("message"));
	   nameField.click();
	   
	   WebElement errorField = driver.findElement(By.id("errormessage"));
	   assertTrue(errorField.getText().equalsIgnoreCase(""));
	   System.err.println(errorField.getTagName());
	   
	   driver.close();	   
   }
   
   
   @After 
   public void afterScenario(){
   System.out.println("After Hook is running");
   }  
 }
   

