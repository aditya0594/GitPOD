package com.lambdatest.Tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class SingleTest {
	
	//Lambdatest Credentails can be found here at https://www.lambdatest.com/capabilities-generator
	String username = System.getenv("LT_USERNAME") == null ? "adityapawar180" : System.getenv("LT_USERNAME");
	String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "eZFjHaGIuMDJHoRSHwyP5iN5Z9INdXMvVBJpl2e3OLO1OunpDW" : System.getenv("LT_ACCESS_KEY");
	
	
	public static WebDriver driver;
	public static String status = "failed";

	@BeforeTest(alwaysRun=true)
	@Parameters(value = { "browser", "version", "platform" })
	public void setUp(String browser, String version, String platform) throws Exception {

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("122.0");
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "adityapawar180");
		ltOptions.put("accessKey", "6wud0mTK0TXmhC7F76FfTNByrGdUNLIIRtZ5eG8Oww7xYOkPYl");
		ltOptions.put("build", "Selenium java");
		ltOptions.put("project", "Selenium_101");
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");
		browserOptions.setCapability("LT:Options", ltOptions);

		String gridURL = "http://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub";
		try {
			driver = new RemoteWebDriver(new URL(gridURL), capability);
		} catch (Exception e) {
			System.out.println("driver error");
			System.out.println(e.getMessage());
		}
	}

	@Test
	public static void test() {

			// Launch the app
			driver.get("https://lambdatest.github.io/sample-todo-app/");


	}

	@AfterTest
	public static void afterTest() {
		driver.quit();
	}

}
