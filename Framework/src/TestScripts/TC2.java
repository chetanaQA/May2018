package TestScripts;

import org.testng.annotations.Test;

import LIB.BusinessFunctions;

public class TC2 {
	@Test
	public void Addemployee()
	{
		BusinessFunctions br=new BusinessFunctions();
		br.configDriver("FireFox");
		br.OpenApp("http://apps.qaplanet.in/qahrm/login.php");
		br.LoginToOrangeHRM("qaplanet1", "lab1");
		br.Addemployee();
		br.logoutFromApp();
		br.closebrowser();
		br.QuitObject();
	}

}
