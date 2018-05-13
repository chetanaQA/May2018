package addemployee;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javax.swing.text.html.CSS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.BatchAllocator.Slicing;

public class TC3 
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\QAP32\\Downloads\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		WebDriverWait w=new WebDriverWait(d, 60);
//		get url
		d.get("http://apps.qaplanet.in/qahrm/login.php");
//		verify homepage display
		if(w.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("homepage displayed");
		}
		else
		{
			System.out.println("homepage not displayed");
		}
//		username and password verify
		WebElement sUN=d.findElement(By.cssSelector("input[name='txtUserName'].loginText"));
		WebElement sPWD=d.findElement(By.cssSelector("input[name='txtPassword'].loginText"));
		if(sUN.isDisplayed()&& sPWD.isDisplayed())
		{
			System.out.println("Username and Password displayed");
		}
		sUN.clear();
        sUN.sendKeys("qaplanet1");
        sPWD.clear();
        sPWD.sendKeys("lab1");
//      verify login
         WebElement LI=d.findElement(By.cssSelector("input.button[name='Submit']")); 
        
         
//       create object for clear button
         WebElement clr=d.findElement(By.cssSelector("input.button[type='reset'][name='clear']"));
         if(LI.isDisplayed() && clr.isDisplayed())
         {
        	 System.out.println("Login and clear botton displayed");
         }
         else
         {
        	 System.out.println("Login and clear botton displayed failed");
         }
         LI.click();
         Thread.sleep(4000);
//      verify next page display
        if(w.until(ExpectedConditions.titleIs("OrangeHRM")))
        {
        	System.out.println("nevigated to next page successfully");
        }
        else
        {
        	System.out.println("nevigated to next page failed");
        }
        
//		move to pim
        WebElement pim=d.findElement(By.xpath("//li[@id='pim']/a"));
        if(pim.isDisplayed())
        {
        	System.out.println("pim displayed");
        }
        else
        {
        	System.out.println("pim not displayed");
        }
        Actions a=new Actions(d);
        a.moveToElement(pim).perform();
        Thread.sleep(4000);
//        display add employee
        WebElement Addemp=d.findElement(By.linkText("Add Employee"));
        if(Addemp.isDisplayed())
        {
        	System.out.println("add employee displayed");
        }
        else
        {
        	System.out.println("add employee not displayed");
        }
        Addemp.click();
        Thread.sleep(4000);
//        wait and switch to add employee 
        w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
        if(d.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
        {
        	System.out.println("add employee page displayed");
        }
//        verify employee code
        String EC=d.findElement(By.id("txtEmployeeId")).getAttribute("value");
//        create object to save
        WebElement Objsave=d.findElement(By.id("btnEdit"));
        Objsave.click();
        Thread.sleep(4000);
//        wait for alert command
        Alert alt=w.until(ExpectedConditions.alertIsPresent());
        if(alt.getText().equals("Last Name Empty!"))
        {
        	System.out.println("Last Name Empty! displayed");
        }
       alt.accept();
       Thread.sleep(2000);
       String sLN="qa";
       d.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
        Objsave.click();
//        wait to get alert
        Alert alt1=w.until(ExpectedConditions.alertIsPresent());
        if(alt1.getText().equals("First Name Empty!"))
        {
        	System.out.println("First Name Empty! displayed");
        }
        alt1.accept();
        Thread.sleep(3000);
        String sFN="hybd";
        d.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
//        create obj to select photo from system
        WebElement img=d.findElement(By.name("photofile"));
        img.click();
        Thread.sleep(3000);
        Robot rt=new Robot();
        StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
        rt.delay(2000);
        rt.keyPress(KeyEvent.VK_CONTROL);
        rt.keyPress(KeyEvent.VK_V);
        rt.keyRelease(KeyEvent.VK_V);
        rt.keyRelease(KeyEvent.VK_CONTROL);
        rt.delay(2000);
        rt.keyPress(KeyEvent.VK_ENTER);
        rt.delay(2000);
        		Objsave.click();
        		Thread.sleep(3000);
//           verify nevigate to next page   
        		if(w.until(ExpectedConditions.titleIs("OrangeHRM")))
        		{
        			System.out.println("nevigated to next page");
        		}
//        		switch to frame
        		if(w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details")))
          		{
        			System.out.println("personal details displayed");
        		}
        		//d.switchTo().frame("rightMenu");
//        		create obj for Edit button
        		WebElement Ebutton=d.findElement(By.name("EditMain"));
        		Ebutton.click();
//        		create obj for date of birth calender
        		WebElement dob=d.findElement(By.name("btnDOB"));
        		dob.click();
        		Thread.sleep(3000);
        		
        		
	}
	

}
