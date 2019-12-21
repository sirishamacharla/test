package DriverFactory;

import org.testng.annotations.Test;

import Utilities.ReadExcel;
import Utilities.TakeScreenShot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonFunctions.PBFunctions;
import Constant.PBConstant;

public class DriverScript extends PBConstant {
//Read excel path
String inputpath="E:\\NewEvengbatch\\Banking\\Input\\Controller.xlsx";
//writing results
String outputpath="E:\\NewEvengbatch\\Banking\\Output\\keyword.xlsx";
ExtentReports report;
ExtentTest test;
String TCsheet="TestCases";
String TSSheet="TestSteps";
@Test
public void primusbank()throws Throwable
{
boolean res=false;
String tcres="";
//access excel util methods
ReadExcel xl=new ReadExcel(inputpath);
report=new ExtentReports("./Reports/keyword.html");
//count no of rows in TCsheet
int TCcount=xl.rowCount(TCsheet);
//count no of rows in Tssheet
int TScount=xl.rowCount(TSSheet);
//iterate test case sheet
for(int i=1;i<=TCcount;i++)
{
	//read execute column
String execute=xl.getCellData(TCsheet, i, 2);
if(execute.equalsIgnoreCase("Y"))
{
//read TestCase Id from TC Sheet
String Tcids=xl.getCellData(TCsheet, i, 0);
//iterate all rows in TSSheet
for(int j=1;j<=TScount;j++)
{
//start test case
test=report.startTest("PrimusBank");
test.assignAuthor("Ranga Sr manger");
//read description column
String description=xl.getCellData(TSSheet, j, 2);
//read TestCase Id from TSSheet
	String TSids=xl.getCellData(TSSheet, j, 0);
	if(Tcids.equalsIgnoreCase(TSids))
	{
//read keyword column
String keyword=xl.getCellData(TSSheet, j, 3);
if(keyword.equalsIgnoreCase("AdminLogin"))
{
//call login method
res=PBFunctions.verifyLogin("Admin", "Admin");
test.log(LogStatus.INFO, description);
TakeScreenShot.ScreenShot(driver, "Loginpage");
}
else if(keyword.equalsIgnoreCase("NewBranchCreation"))
{
PBFunctions.navigatebranch();
res=PBFunctions.verifybranccreation("Srnager456", "Hyderabad", "12345", 1, 1, 1);
test.log(LogStatus.INFO, description);
TakeScreenShot.ScreenShot(driver, "Branchcreation");
}
else if(keyword.equalsIgnoreCase("UpdateBranch"))
{
PBFunctions.navigatebranch();
res=PBFunctions.verifyBranchUpdation("Kukatpalli234", "Hyderabad2");
test.log(LogStatus.INFO, description);
TakeScreenShot.ScreenShot(driver, "Branch updation");
}
else if(keyword.equalsIgnoreCase("AdminLogout"))
	{
res=PBFunctions.verifyLogout();
test.log(LogStatus.INFO, description);
TakeScreenShot.ScreenShot(driver, "Logout");
}
String tsres=null;
if(res)
{
 tsres="PASS";
//write into result column in TSSheeet
 xl.SetData(TSSheet, j, 4, tsres, outputpath);
 xl.greencolour(TSSheet, j, 4, outputpath);
 test.log(LogStatus.PASS, description);
}
else{
tsres="Fail";
xl.SetData(TSSheet, j, 4, tsres, outputpath);
xl.redcolour(TSSheet, j, 4, outputpath);
test.log(LogStatus.FAIL, description);
}
//if not tcres equal to null then write as pass or fail into tcsheet
if(!tsres.equalsIgnoreCase("FAIL"))
{
//assign teststep results to testcase results	
	tcres=tsres;
}
}
report.endTest(test);
report.flush();
}
xl.SetData(TCsheet, i, 3, tcres,  outputpath);
if(tcres.equalsIgnoreCase("PASS"))
{
xl.greencolour(TCsheet, i, 3, outputpath);
}else
{
xl.redcolour(TCsheet, i, 3, outputpath);
}
}
else
{
//write as not executed
xl.SetData(TCsheet, i, 3, "Not Executed", outputpath);
}
}
}
}



















