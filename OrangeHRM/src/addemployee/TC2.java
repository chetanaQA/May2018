package addemployee;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TC2 {
	public static void main(String[] args) throws Exception 
	{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP32\\Downloads\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 WebDriverWait w=new WebDriverWait(driver,60);
		 
//		   get url
		   driver.get("http://apps.qaplanet.in/qahrm/login.php");
		   
//		   verify homepage
		   //String title=driver.getTitle("OrangeHRM - New Level of HR Management");
		 
		if(w.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
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
		    
//		    verify username
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
//		    verify password
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
//		    verify login
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
//		    verify HRM displayed
		    String title=driver.getTitle() ;
		    if(title.equals("OrangeHRM"))
		    {
		    	System.out.println("HRM pagedisplayed");
		    }
		    else
		    {
		    	System.out.println("HRM page displayed failed");
		    }
//		    verify welcome page
		    WebElement wpg=driver.findElement(By.xpath("//ul[@id='option-menu']"));
		    if(wpg.isDisplayed())
		    {
		    	System.out.println("welcomeUN displayed");
		    }
		    else
		    {
		    	System.out.println("welcomeUN displayed failed");
		    }
//		    verify change password
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
//		    verify PIM and click
		    //w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='pim']")))
		    WebElement PIM=driver.findElement(By.xpath("//li[@id='pim']"));
		    if(PIM.isDisplayed())
		    		{
		    	System.out.println("pim displayed");
		    		}
		    else
		    {
		    	System.out.println("pim displayed failed");
		    }
//		    create object for action class
		    Actions a=new Actions(driver);
//		    move to PIM or mouse over PIM
		    a.moveToElement(PIM).perform();
    	    Thread.sleep(4000);
//		    display add employee
		    WebElement EM=driver.findElement(By.linkText("Add Employee"));
		    if(EM.isDisplayed())
		    {
		    	System.out.println("Add Employee displayed");
		    }
		    else
		    {
		    	System.out.println("add employee displayed failed");
		    }
		    EM.click();
		    Thread.sleep(4000);
//	   	    wait for frame and switch to it
		    w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
//		    verify add employee text
		    if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"));
		    {
		    	System.out.println("add employee page is displayed");
		    }
//		    get employee code
		    String EC=driver.findElement(By.name("txtEmployeeId")).getAttribute("value");
//		    create web element to save
		    WebElement objSV=driver.findElement(By.id("btnEdit"));
//		    click on save
		    objSV.click();
		    Thread.sleep(2000);
		    String FN="nit";
//		    wait for alert
		    Alert ar=w.until(ExpectedConditions.alertIsPresent());
		    if(ar.getText().equals("Last Name Empty!"))
		    {
		    System.out.println("Last Name Empty! displayed");	
		    ar.accept();
		    }
		    Thread.sleep(1000);
		    String LN="tin";
//		    enter last name
		    driver.findElement(By.id("txtEmpLastName")).sendKeys(LN);
//		    click on save
		    objSV.click();
		    Thread.sleep(2000);
//		    wait for alert
		    Alert ar1=w.until(ExpectedConditions.alertIsPresent());
		    if(ar1.getText().equals("First Name Empty!"))
		    {
		    	System.out.println("First Name Empty! displayed");
		    	ar1.accept();
		    }
		    Thread.sleep(2000);
//		    enter FirstName
		    driver.findElement(By.name("txtEmpFirstName")).sendKeys(FN);
		  
//		    create object for robot class
		    Robot rt=new Robot();
//		    click on photo file
             WebElement brw=driver.findElement(By.xpath("//input[@name='photofile']"));
             brw.click();
		    Thread.sleep(5000);
		   //driver.findElement(By.name("photofile")).click();
		  //driver.findElement(By.xpath("//*[@id='photofile']")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
//		    code image path/any file
		    StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
//		    set image path to default window
		    
		  
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		   
		    rt.delay(1000);		
		   
		    rt.keyPress(KeyEvent.VK_CONTROL);
		    rt.keyPress(KeyEvent.VK_V);
		    rt.keyRelease(KeyEvent.VK_V);
		    rt.keyRelease(KeyEvent.VK_CONTROL);
		    rt.delay(2000);
		    rt.keyPress(KeyEvent.VK_ENTER);
		    rt.delay(1000);
		    rt.keyPress(KeyEvent.VK_ENTER);
		    rt.delay(2000);
		    
//		    click on save
		    objSV.click();
//		    verify personal details page
		    if(w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"),"Personal Details")))
		    {
		    	System.out.println("personal details displayed");
		    }
//		    switch to frame
		    driver.switchTo().parentFrame();
//		    mouse over on pim
		    a.moveToElement(PIM).perform();
//		    click on Employee list
		    WebElement empList=driver.findElement(By.linkText("Employee List"));
		    empList.click();
		    Thread.sleep(5000);
//		    wait to frame and switch it
//		    w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		    driver.switchTo().frame("rightMenu");
//		    verify employee information text
		    if(driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		    {
		    	System.out.println("Employee Information is displayed");
		    }
		    else
		    {
		    System.out.println("Employee Information display failed");	
		    }
//		    to get row count
		    int rc=driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		    System.out.println("the count of employedd list is:" +rc);
//		    to get column count
		    for(int i=1;i<=rc;i++)
		    { 
 		      String empID=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
		      System.out.println(empID);
//		      for select column count
		     String empNM=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
		     System.out.println(empNM);
		     if(EC.equals(empID)&& empNM.equals(FN+" "+LN))
		      {
		        System.out.println(EC+","+empNM+", displayed at: "+i);
		    	break;
		      }
		    }
//		    switch to frame
		    driver.switchTo().parentFrame();
//		    logout display
		    WebElement LO=driver.findElement(By.xpath("//ul[@id='option-menu']/li[3]/a"));
		    LO.click();
//		    verify homepage displayed
		    if(w.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		    {
		    	System.out.println("homepage displayed");
		    }
		    else
		    {
		    	System.out.println("homepagenot displayed");
		    }
		    driver.close();
		    driver.quit();
		}

}
