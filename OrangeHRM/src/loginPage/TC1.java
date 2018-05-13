package loginPage;



import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC1
{
    public static void main(String[] args) throws Exception
     {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP32\\Downloads\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
       WebDriverWait wait=new WebDriverWait(driver,60);
//	   get url
	   driver.get("http://apps.qaplanet.in/qahrm/login.php");
	   
//	   verify homepage
	   //String title=driver.getTitle("OrangeHRM - New Level of HR Management");
	   if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	   {
		   System.out.println("title displayed");
	   }
	   else
	   {
		   System.out.println("title displayed failed");
	   }
	   
//  create webElements for Username,Password,Login,Clear
	    WebElement UN=driver.findElement(By.name("txtUserName"));
	    WebElement PWD=driver.findElement(By.name("txtPassword"));
	    WebElement LI=driver.findElement(By.name("Submit"));
	    WebElement clr=driver.findElement(By.name("clear"));
	    
//	    verify username
	    if(UN.isDisplayed())
	    {
	    	System.out.println("username displayed");
	    }
	    else
	    {
	    	System.out.println("username displayed failed");
	    }
	    UN.clear();
	    UN.sendKeys("qaplanet1");
//	    verify password
	    if(PWD.isDisplayed())
	    {
	    	System.out.println("password displayed");
	    }
	    else
	    {
	    	System.out.println("password displayed failed");
	    }
	    PWD.clear();
	    PWD.sendKeys("lab1");
//	    verify login
	    if(LI.isDisplayed())
	    {
	    	System.out.println("Login page displayed");
	    }
	    else
	    {
	    	System.out.println("Login page displayed failed");
	    }
	    LI.click();
	    Thread.sleep(2000);
//	    verify HRM displayed
	    String title=driver.getTitle() ;
	    if(title.equals("OrangeHRM"))
	    {
	    	System.out.println("HRM pagedisplayed");
	    }
	    else
	    {
	    	System.out.println("HRM page displayed failed");
	    }
//	    verify welcome page
	    WebElement wpg=driver.findElement(By.xpath("//ul[@id='option-menu']"));
	    if(wpg.isDisplayed())
	    {
	    	System.out.println("welcomeUN displayed");
	    }
	    else
	    {
	    	System.out.println("welcomeUN displayed failed");
	    }
//	    verify change password
	    WebElement CPW=driver.findElement(By.linkText("Change Password"));
	    if(CPW.isDisplayed())
	    {
	    	System.out.println("changepassword displayed");
	    }
	    else
	    {
	    	System.out.println("changepassword displayed failed");
	    }
	    CPW.click();
//	    verify Logout page
	    WebElement LO=driver.findElement(By.linkText("Logout"));
	    if(LO.isDisplayed())
	    {
	    	System.out.println("Logout displayed");
	    }
	    else
	    {
	    	System.out.println("Logout displayed failed");
	    }
	    LO.click();
	    Thread.sleep(1000);
//	    verify homepage should display
	    if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")));
	    {
	    	System.out.println("homepage displayed");
	    }
	  
         driver.close();
         driver.quit();
     }
    
}
