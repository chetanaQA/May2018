package LIB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BusinessFunctions {
	
	WebDriver brow;
	WebDriverWait wait;
	WebElement objUN;
	WebElement objPWD;

//	driver configuration
	public void configDriver(String Browser)
	{
		if(Browser.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\QAP32\\Downloads\\geckodriver.exe");
			brow=new FirefoxDriver();
			
		}
		else if(Browser.equals("IE"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\QAP32\\Downloads\\geckodriver.exe");
		     brow=new InternetExplorerDriver();
		}
		else if(Browser.equals("Chrome"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\QAP32\\Downloads\\chromedriver.exe");
			brow=new ChromeDriver();
		}
		else
		{
			System.out.println("Invalid Driver");
		}
			wait=new WebDriverWait(brow,30);
			brow.manage().window().maximize();
	}
//	close browser
	public void closebrowser()
	{
		brow.close();
	}
//  Quit browser
	public void QuitObject()
	{
		brow.quit();
	}
//	open application
	public void OpenApp(String URL)
	{
		brow.get(URL);
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
//		verify Homepage
		
		String k = brow.getTitle();
		System.out.println(k);
		
		Assert.assertEquals("OrangeHRM - New Level of HR Management", k);
		Reporter.log("your page is displayed");
//		create object for UN,PWD
		objUN=brow.findElement(By.name("txtUserName"));
		objPWD=brow.findElement(By.name("txtPassword"));
//	    verify UN,PWD
		Assert.assertTrue(objUN.isDisplayed()&&objPWD.isDisplayed());
		Reporter.log("UN and PWD exist");
	}
	public void LoginToOrangeHRM(String username,String password)
	{
		objUN.sendKeys(username);
		objPWD.sendKeys(password);
//		click on Login
		brow.findElement(By.name("Submit")).click();
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
//		verify OrangeHRM
		Assert.assertEquals(brow.getTitle(),"OrangeHRM");
		Reporter.log("OrangeHRM page displayed");
//		get welcome text
		String weltext=brow.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
//		verify welcome text
		Assert.assertEquals(weltext, "Welcome "+username);
		Reporter.log("Welcome qaplanet1"+username+"displayed");
	}
//	Logout App
	public void logoutFromApp()
	{
//		click on logout
		brow.findElement(By.linkText("Logout")).click();
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
//		verify homepage
		Assert.assertEquals(brow.getTitle(), "OrangeHRM - New Level of HR Management");
		Reporter.log("logout successfully and homepage displayed");
	}
	public void Addemployee() 
	{
		Reporter.log("addemployee");
	}

		
	
}

	


	





