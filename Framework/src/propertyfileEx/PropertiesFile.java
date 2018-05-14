package propertyfileEx;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesFile 
{
	public static void main(String[] args) throws Exception
	
	{
	
		Properties obj=new Properties();
	
		obj.load(new FileInputStream("C:\\Users\\QAP32\\chetana_workspace\\Framework\\src\\propertyfileEx\\propertyfileEx.properties"));
		String strUrl=obj.getProperty("URL");
		String strUN=obj.getProperty("username");
		String strPWD=obj.getProperty("password");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\QAP32\\Downloads\\chromedriver.exe");
		ChromeDriver br=new ChromeDriver();
		br.navigate().to(strUrl);
		Thread.sleep(2000);
		br.findElement(By.name("txtUserName")).click();
		br.findElement(By.name("txtUserName")).sendKeys(strUN);
		br.findElement(By.name("txtPassword")).sendKeys(strPWD);
		br.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		br.findElement(By.linkText("Logout")).click();
		br.close();
		br.quit();
	}

}
