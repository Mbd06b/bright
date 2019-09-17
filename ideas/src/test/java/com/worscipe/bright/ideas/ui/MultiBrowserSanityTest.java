package com.worscipe.bright.ideas.ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultiBrowserSanityTest {
	
	
	private static String CLIENT_URL = "http://localhost:4200";
	private static String PROVIDER_URL = "http://localhost:7000";
	private static String KNOWN_USER_EMAIL = "mbd06b@gmail.com";
	private static String KNOWN_USER_PASSWORD = "password";

	
	
	private WebDriver driver; 
	
	
	
	//@Before Tests should initialize TEST-RELATED Objects and dependencies
	// AND  check TEST-Related resources. 
	// Not to be confused with sanity tests @Test(groups="sanity") that check for basic SYSTEM functionality
	
	//tests by default run by Alphabetical order in the class, unless specified @Test(priority = n) starting with "n = -1");
	
	
	//Testing Multiple Browsers Reference - https://www.toolsqa.com/selenium-webdriver/testng-multi-browser-cross-browser/
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
	
		// Driver setup depends on having the webdriver in your system path, or property explicitly set as below 
		// System.setProperty("webdriver.chrome.driver","C:/Users/Your.user.name/webdriver/chromedriver.exe");
		
		// TODO Rebuild test Suite as an enum
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:/Users/Matthew.b.dowell/webdriver/chromedriver.exe");
			driver = new ChromeDriver();
	 
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:/Users/Matthew.b.dowell/webdriver/geckodriver.exe");
			driver = new FirefoxDriver();
	 
		}else if (browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", "C:/Users/Matthew.b.dowell/webdriver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
	
		} 
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(groups="sanity", description="Loads Google.com and confirms that we are connected and able to load CDN libraries")
	public void shouldGetGoogle() {
		driver.get("https://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test(groups="sanity", description="Checks that the provider stack is running")
	public void shouldGetProvider() {
		driver.get(PROVIDER_URL + "/swagger-ui.html");
		Assert.assertEquals(driver.getTitle(), "Swagger UI");
	}
	
	@Test(groups="sanity", description="Checks that the client stack is running")
	public void shouldGetClient() {
		driver.get(CLIENT_URL);
		Assert.assertEquals(driver.getTitle(), "Brightideas5");
	}
	
	
	@Test(groups="login", dependsOnGroups="sanity", description="Navigates to Login Page")
	public void shouldNavigateToLogin() {
		
		driver.get(CLIENT_URL);
		WebElement loginHref = driver.findElement(By.linkText("Login"));
		
	    loginHref.click();
	    
	    WebElement loginComponent = driver.findElement(By.tagName("bi-login"));
	    
	    Assert.assertEquals("bi-login", loginComponent.getTagName());
	}
	
	
	@Test(groups="login", dependsOnGroups="sanity", description="Logins to application with a known user")
	public void shouldLogin(){
		driver.get(CLIENT_URL + "/login");
		
		WebElement loginForm = driver.findElement(By.tagName("form"));
		List<WebElement> inputs = loginForm.findElements(By.tagName("input"));
		 
		WebElement emailInput = inputs.get(0);
		WebElement passwordInput = inputs.get(1);
		
		emailInput.sendKeys(KNOWN_USER_EMAIL);
		passwordInput.sendKeys(KNOWN_USER_PASSWORD);
		
		driver.findElement(By.tagName("button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Enter Application")));
	
		driver.findElement(By.linkText("Enter Application")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.user-context")));
		
		WebElement userContext = driver.findElement(By.cssSelector("button.user-context"));
		
		Assert.assertTrue(userContext.isDisplayed());
		
	}
	
	
	
	@Test(groups="register", dependsOnGroups="sanity", description="Registers a user to the application")
	public void shouldRegisterNewUserAndDisplayProfilePage() {
	  driver.get(CLIENT_URL + "/register");
	  
	  WebElement registrationForm = driver.findElement(By.tagName("form")); 
	  
	  List<WebElement> inputs = registrationForm.findElements(By.tagName("input"));
	  
	  //inputs.get(0).
	  WebElement firstNameInput = inputs.get(0);
	  WebElement lastNameInput = inputs.get(1);
	  WebElement emailInput = inputs.get(2);
	  WebElement passwordInput = inputs.get(3);
	  WebElement confirmPasswordInput = inputs.get(4);
	  
	  firstNameInput.sendKeys("Test");
	  lastNameInput.sendKeys("User");
	  emailInput.sendKeys("Test@invalid.com");
	  passwordInput.sendKeys("password");
	  confirmPasswordInput.sendKeys("password");
	
	  driver.findElement(By.tagName("button")).click(); 
	  
	  WebDriverWait wait = new WebDriverWait(driver, 2);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.user-context")));

	  Assert.assertTrue(driver.findElement(By.tagName("bi-profile")).isDisplayed());
	}
	
	
	@Test(groups="deleteNewRegister", dependsOnGroups="register", description="Deletes the registered test user")
	public void shouldDeleteRegisteredUser() {
		
		driver.get(CLIENT_URL + "/login");
		
		WebElement loginForm = driver.findElement(By.tagName("form"));
		List<WebElement> inputs = loginForm.findElements(By.tagName("input"));
		 
		WebElement emailInput = inputs.get(0);
		WebElement passwordInput = inputs.get(1);
		
		emailInput.sendKeys(KNOWN_USER_EMAIL);
		passwordInput.sendKeys(KNOWN_USER_PASSWORD);
		
		driver.findElement(By.tagName("button")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 2);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Enter Application")));
	
		driver.findElement(By.linkText("Enter Application")).click();
		
		//navigate to user admin
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("Users")).click();
		
		WebElement searchInput = driver.findElement(By.tagName("input"));
		
		searchInput.sendKeys("Test@invalid.com");
		
		driver.findElement(By.cssSelector("button.more_menu")).click();
		driver.findElement(By.cssSelector("button.more_menu_delete")).click(); 
		
		
		searchInput.sendKeys("");

		Assert.assertFalse(driver.findElement(By.id("user-row-Test@invalid.com")).isDisplayed());
		
	}
	
	
	
}
