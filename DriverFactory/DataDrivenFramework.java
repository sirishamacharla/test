package DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApplicationLayer.AddEmp;
import ApplicationLayer.LoginPage;
import ApplicationLayer.LogoutPage;
import Utilities.ReadExcel;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class DataDrivenFramework {
WebDriver driver;
ExtentReports report;
ExtentTest test;
//to read data from excel
String inputpath="E:\\NewEvengbatch\\Banking\\Input\\Empdata.xlsx";
//to write results
String outputpath="E:\\NewEvengbatch\\Banking\\Output\\empResults.xlsx";
@BeforeTest
public void Adminlogin()throws Throwable
{
//generate extent reports
report=new ExtentReports("./Reports/Emp.html");
System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
driver=new ChromeDriver();
driver.get("http://orangehrm.qedgetech.com/");
driver.manage().window().maximize();
//calling login page class 
LoginPage login=PageFactory.initElements(driver, LoginPage.class);
String loginres=login.verifyLogin(driver, "Admin", "Qedge123!@#");
Reporter.log(loginres,true);
}
@Test
public void empcreation()throws Throwable
{
//to access readexcel methods
ReadExcel xl=new ReadExcel(inputpath);
//call emp class objects
AddEmp emp=PageFactory.initElements(driver, AddEmp.class);
//count no of rows in sheet
int rc=xl.rowCount("Emp");
//count no of columns in rows
int cc=xl.colCount("Emp");
Reporter.log("no of rows are::"+rc+"  "+"no of columns in first row::"+cc,true);
for(int i=1;i<=rc;i++)
{
//report logs to html
test=report.startTest("Emp Creation");
test.assignAuthor("Ranga Sr Manager");
test.assignCategory("Mutiple Test Data");
//read columns for reading
String fname=xl.getCellData("Emp", i, 0);
String lname=xl.getCellData("Emp", i, 1);
String eid=xl.getCellData("Emp", i, 2);
emp.verifyEmp(driver, fname, lname, eid);
if(driver.getCurrentUrl().contains("empNumber"))
{
test.log(LogStatus.PASS, "Add Emp Pass");
Reporter.log("Add Emp Pass",true);
//write into result column
xl.SetData("Emp", i, 3, "Pass", outputpath);
xl.greencolour("Emp", i, 3, outputpath);
}
else{
test.log(LogStatus.FAIL, "Add Emp Fail");
xl.SetData("Emp", i, 3, "Fail", outputpath);
xl.redcolour("Emp", i, 3, outputpath);
}
report.endTest(test);
report.flush();
}
xl.closeFiles();
}
@AfterTest
public void logoutapp()throws Throwable
{
	LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
	logout.verifyLogout(driver);
	driver.close();
}
}

















