package com.mg.qa.test;

import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DifferentDrame {

	WebDriver driver;
	// Shafik
	@BeforeTest
	public void setup() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--no-default-browser-check"));
		HashMap<String, String> chromePreferences = new HashMap<String, String>();
		chromePreferences.put("profile.password_manager_enabled", "false");
		capabilities.setCapability("chrome.prefs", chromePreferences);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("--no-sandbox");
		capabilities.setCapability("chrome.binary", "chromedriver.exe");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		this.driver = new ChromeDriver(capabilities);
		driver.get("http://www.ankur.com/projects/FrameGlider/demo/simple/a.html");
		driver.manage().window().maximize();

	}

	@Test
	public void dragAndDropTestCaseWithinFrame() {

		WebElement messagPrint = driver.findElement(By.id("messages"));
		System.out.println(messagPrint.getText());

		WebElement bFrameSwitch = driver.findElement(By.id("b"));
		driver.switchTo().frame(bFrameSwitch);
		WebElement dra1FrameElement = driver.findElement(By.id("Dra1"));
		Actions acts = new Actions(driver);
		acts.clickAndHold(dra1FrameElement);
		acts.build().perform();

		WebElement cFrameSwitch = driver.findElement(By.id("c"));
		driver.switchTo().frame(cFrameSwitch);
		WebElement dro2FrameElement = driver.findElement(By.id("Dro2"));
		acts.release(dro2FrameElement);
		acts.build().perform();
		driver.switchTo().parentFrame().switchTo().parentFrame();
		System.out.println(messagPrint.getText());

	}

}
