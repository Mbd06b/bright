//package com.boot.brightideas.api;
//
//
//import java.lang.reflect.Method;
//
//import org.junit.runner.RunWith;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ApiApplicationTests {
//	
//	WebDriver driver; 
//	
	//@Before Tests should initialize TEST-RELATED Objects and dependencies
	// AND  check TEST-Related resources. 
	// Not to be confused with sanity tests @Test(groups="sanity") that check for basic SYSTEM functionality
	
	//tests by default run by Alphabetical order in the class, unless specified @Test(priority = n) starting with "n = -1");
	
	
//	@BeforeSuite
//	public void setup() {
	
		// Driver setup depends on having the webdriver in your system path, or property explicitly set as below 
		// System.setProperty("webdriver.chrome.driver","C:/Users/Your.user.name/webdriver/chromedriver.exe");
//		
//		driver = new ChromeDriver();
//		driver.get("https://google.com");
//		
//	}
//	
//	
//	@AfterSuite
//	public void tearDown() {
//		
//	}
//	
//	
//	@Test(groups="sanity", description = "Setup and verify that environment is running")
//	public void setupDatabase() {
//		System.out.println("Sanity tests that should run first.");
//	}
//	
//	@Test(dependsOnGroups="sanity")
//	public void doOtherStuff() {
//		System.out.println("Doing stuff, after setting up necessary environment");
//	}
//	
//	@Test(priority= TestPriority.HIGH)
//	public void doImportantStuff() {
//		System.out.println("Do important stuff");
//	}
//	
/* ::::::::::::::(UI Tests)  BEFORE Parameterizing the fields of a login form:::::::::::::::::: 
	
	@Test
	public void emptyPasswordFailsLogin() {
		//login
		driver.findElement(By.id("login_field")).sendKeys("let_me_in"); // "valid" username
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click(); 
		
		//verify error appeared
		Assert.assertTrue(driver.findElement(By.className("flash-error"))
				.getText()
				.equalsIgnoreCase("Incorrect username or password.")
				);
	}
	
	
	@Test
	public void emptyLoginFailsLogin() {
		//login
		driver.findElement(By.id("login_field")).sendKeys(""); // "valid" username
		driver.findElement(By.id("password")).sendKeys("safest_password_in_the_world");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click(); 
		
		//verify error appeared
		Assert.assertTrue(driver.findElement(By.className("flash-error"))
				.getText()
				.equalsIgnoreCase("Incorrect username or password.")
				);
	}
	
*/	
	
	//importing a dataProvider from another class used to organize DataProviders
	/*
	@Test(dataProvider = "invalidCredentials", dataProviderClass=CommonDataProviders.class)
	public void credsAreInvalid(String login, String password) {
		
	driver.findElement(By.id("login_field")).sendKeys(login); // "valid" username
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.xpath("//input[@value='Sign in']")).click(); 
	
	//verify error appeared
	Assert.assertTrue(driver.findElement(By.className("flash-error"))
			.getText()
			.equalsIgnoreCase("Incorrect username or password.")
			);
	};
	*/
	
	
//	@BeforeMethod
//	public void globalBeforeMethod(Method testMethod) {
//		
//		String description = testMethod.getAnnotation(Test.class).description();
//		
//		System.out.println("Starting test: " + testMethod.getName() + " with description: " + description); 
//		
//	}
//	
	
	
	
	
	/**to prevent tests from interfering with each-other's results we use a @BeforeMethod to set a clean application state before each method running a test.
		
		The following would create a new UserManager object before all tests. 
		and would close an HttpClient connection and response after every test.
		This is usefult to avoid duplication. 
		 
		UserManager um;
		
		@BeforeMethod
		public void setup() {
			um = new UserManager; 
		}
		
		@AfterMethod
		public void cleanup() throws IOException {
			client.close();
			response.close(); 
		}
		
		
		//To reduce network execution time we might use @BeforeClass @AfterClass methods
	    //this means that setup only occurs ONCE inside the CLASS that the method is in. 	 
		 
		CloseableHttpClient client;
	    ClosableHttpResponse response;
	    
		
		@BeforeClass
		public void setup() throws IOException {
		 	System.out.println("Runs once per class");
		 	client = HttpClientBuilder.create().build();
		 	response = client.execute(new HttpGet(http://url.whatever); 
		 }
		
		
		// @BeforeSuite will run before all our other tests excute, it would make sense to put this type of annotated method inside a BaseClass before a suite of other tests runs. 
		 
		public class BaseTestClass {
			
			@BeforeSuite
			public void globalSetup(){
			
			}
			
			@BeforeMethod
			public void globalMethodSetup(){
			}
		}
		
		
		public class FirstTest extends BaseTestClass {
			
			// WARNING :: This declaration overrides the global @BeforeMethod
			@BeforeMethod
			public void localMethodSetup(){
			
			}
			
		}
		
		
	*/
//	
//	@Test
//	public void contextLoads() {
//		System.out.println("This is Context Load test");
//	}
//	
//	@Test
//	private void successfulAddUserReturnsTrue() {
//		
	/*  AAA -method example (Arrange, Act, and Assert)
	 *
	 *
	 *
:::::::Example 1::::::::: 

		//Arrange
		UserManeger um = new UserManager(); 
		
		//Act 
		boolean result = um.addUser("john@email.com");
		
		//Assert
		
		Assert.assertEquals(result, true); // passes
		Assert.assertEquals(result, false); //fails
		
		Alternative Syntax:
		Assert.assertTrue(result); //passes;
		
		
::::::::Example 2 (a slightly more useful test)::::::::
		
		//Arrange
		UserManeger um = new UserManager(); 
		
		//Act 
		String user = um.getUser("john@email.com")
		
		//Assert
		
		Assert.assertEquals(user, john@email.com); // passes

:::::Reference::::

	Basic Assertions  Assert.   // these will run "Hard" by default, meaning subsequest asserts will fail on the first failed assert in the same test method. 
		assertTrue()   ||  assertFalse()
		
		assertEquals() ||  assertNotEquals()
		
		assertNull()   ||  assertNotNull()
			
	 	assertSame()
	 	
	 	assertEqualsDeep()
	 	
	 	assertEqualsNoOrder()
 	
 	
 	Soft Assert  - All the failures are collected  but continue to run. assertAll() then throws all the collected failures. 
 				
 				Best practice is to only ever have ONE assert per test, because each test should be testing for one thing, this principal limits the usage of asserts in practice. 
 				Use Cases: almost never in Unit testing, infrequently in Component and Integration tests, and sometimes in UI testing because the testing can be so slow. 
 	
	 	SoftAssert sa new SoftAssert();
	 	
	 	sa.assertNotNull(v1);
	 	sa.assertEquals(v2, v3); // will run
	 	
	 	sa.assertAll(); // Throw all exeptions;
		
	*/
   
//	}
//	
//	@Test (description="This does nothing, but theoretically could test that a non Existing User Service returns null")
//	public void getNonExistingUserReturnsNull() {
//		
//	}
//	
	
	//Positive Testing for exceptions without terminating excecution, add "expectedExceptions", use expectedExceptionsMessageRegExp to use RegExp to hone in on the expected message
	/*
	@Test(expectedExceptions = DuplicateUserException.class, 
		expectedExceptionMessageRegExp = ".*already exists" )
	public void addDuplicateThrowsException() throws DuplicateUserException{
		//Act
		um.addUser(john@email.com);
		um.addUser(john@email.com); 
	}
	
	
	
	//A @BeforeMethod on a Global Setup is often used if you have a large number of dependencies that need to load before the test runs  
	
	@BeforeMethod(timeOut = 800) // enough time - will pass,
	public void globalSetup(){
	
		//Arrange
		client = HttpClientBuilder.create().build; 
	}
	
	
	@Test(timeOut = 500) //not enough time - will fail
	public void testIsTooSlow() throws IOException {
	
		// Act
		 CloseableHttpResponse response = client.execute(new HttpGet(https://api.github.com/"));
		 
		 // Assert
		 Assert.asserctEquals(response.getStatusLine().getStatusCode(), 200); 
	}
	
	
	//disable a test that is just not working
	
		@Test(enabled = false) // NO Setup is run, NO test excecutes
		public void flakeyTest(){
		
		}
		
	    //@Ignore *ALTERNATIVE SYNTAX* Parent class Setup is run, but NO local setup or test executes
		@Ignore 
		public void flakeyTest(){
		
		}
		
	*/
	
	
	/** ::::::::::Create a Test that runs many times against a dataProvider (this allows testing a large number of combinations) :::::::::::::

		private CloseableHttpClient client; 
		private CloseableHttpResponse repsonse; 
		
		@DataProvider
		public static Object [][] endpointsRequiringAuthentication(){
			return new Object [][] {
				{"user"},
				{"user/followers"},
				{"notifications"}
				// etc 
			};
		}
		
		@Test(dataProvider = "endpointsRequiringAuthentication")
		public void userEndpointReturns401(String endpoint) throws IOException {
			//Act
			response = client.execute(new HttpGet("https://api.github.com/" + endpoint));
			int actualStatusCode = response.getStatusLine().getStatusCode(); 
		}
	
	*/
		
//	
//	@Test(description= "This is a worthless test built for learning")
//	private void aTest2() {
//		System.out.println("This is Test 3");
//	}
//
//}

