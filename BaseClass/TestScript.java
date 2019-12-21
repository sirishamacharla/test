package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ApplicationLayer.AddEmp;
import ApplicationLayer.AddUser;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;

public class TestScript {
WebDriver driver;
@BeforeMethod
public void launch()throws Throwable
{
System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
driver=new ChromeDriver();
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
//calling login page class
LoginPage login=PageFactory.initElements(driver, LoginPage.class);
String loginResult=login.verifyLogin(driver, "Admin", "Qedge123!@#");
System.out.println(loginResult);
}
@Test(priority=0)
public void Empcre()throws Throwable
{
	AddEmp emp=PageFactory.initElements(driver, AddEmp.class);
	String empresults=emp.verifyEmp(driver, "Akhilesh", "Siva", "87654");
	System.out.println(empresults);
}
@Test(priority=1)
public void Usercre()throws Throwable
{
AddUser user=PageFactory.initElements(driver, AddUser.class);
String userResults=user.verifyUser(driver, "QedgeTech1", "Akhi1234", "Siva@090909", "Siva@090909");
System.out.println(userResults);
}
@AfterMethod
public void logoutapp()throws Throwable
{
LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
String logoutresults=logout.verifyLogout(driver);
System.out.println(logoutresults);
driver.close();
}

}

















