package CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Constant.PBConstant;
public class PBFunctions extends PBConstant{
/*Project Name:Primus Bank
 * Module Name:Admin Login
 * Author:Ranga
 * Creation Date:17/09/2019
 */
public static boolean verifyLogin(String username,String password)
{
driver.findElement(By.xpath(p.getProperty("objusername"))).sendKeys(username);
driver.findElement(By.xpath(p.getProperty("objpassword"))).sendKeys(password);
driver.findElement(By.xpath(p.getProperty("objloginbtn"))).click();
String Expval="adminflow";
String Acval=driver.getCurrentUrl();
if(Acval.toLowerCase().contains(Expval.toLowerCase()))
{
Reporter.log("Login Success",true);	
return true;
}
else{
	Reporter.log("Login Fail",true);
return false;
}
}
/*Project Name:Primus Bank
 * Module Name:New Branch Creation
 * Author:Ranga
 * Creation Date:17/09/2019
 */
public static boolean verifybranccreation(String bname,String address1,
	String zcode,int country,int state,int city)throws Throwable
{
driver.findElement(By.xpath(p.getProperty("objnewbranch"))).click();
Thread.sleep(3000);
driver.findElement(By.xpath(p.getProperty("objbname"))).sendKeys(bname);
driver.findElement(By.xpath(p.getProperty("objadd1"))).sendKeys(address1);
driver.findElement(By.xpath(p.getProperty("objzcode"))).sendKeys(zcode);
new Select(driver.findElement(By.xpath(p.getProperty("objcountry")))).selectByIndex(country);
Thread.sleep(3000);
new Select(driver.findElement(By.xpath(p.getProperty("objstate")))).selectByIndex(state);
Thread.sleep(3000);
new Select(driver.findElement(By.xpath(p.getProperty("objcity")))).selectByIndex(city);
Thread.sleep(3000);
driver.findElement(By.xpath(p.getProperty("objsubmit"))).click();
//get alert message
String alertmessage=driver.switchTo().alert().getText();
Thread.sleep(5000);
driver.switchTo().alert().accept();
String Expval="new Branch";
if(alertmessage.toLowerCase().contains(Expval.toLowerCase()))
{
Reporter.log("Branch Creation Success",true);
return true;
}
else{
Reporter.log("Branch Creation Fail",true);
return false;
}
}
/*Project Name:Primus Bank
 * Module Name:Branch Updation
 * Author:Ranga
 * Creation Date:17/09/2019
 */
public static boolean verifyBranchUpdation(String bname,String address1)
 throws Throwable{
driver.findElement(By.xpath(p.getProperty("Obj_Click_Edit"))).click();
Thread.sleep(3000);
WebElement branchn=driver.findElement(By.xpath(p.getProperty("Obj_Update_Bname")));
WebElement add1=driver.findElement(By.xpath(p.getProperty("Obj_Update_Add1")));
branchn.clear();
Thread.sleep(3000);
branchn.sendKeys(bname);
add1.clear();
Thread.sleep(3000);
add1.sendKeys(address1);
driver.findElement(By.xpath(p.getProperty("Obj_Click_Update"))).click();
//get alert message
String alertmessage1=driver.switchTo().alert().getText();
Thread.sleep(5000);
driver.switchTo().alert().accept();
String Expval="Branch up";
if(alertmessage1.toLowerCase().contains(Expval.toLowerCase()))
{
Reporter.log("Branch Updation Success",true);
return true;
}
else{
Reporter.log("Branch Updation Fail",true);
return false;
}
}
/*Project Name:Primus Bank
 * Module Name:Navigate to branches
 * Author:Ranga
 * Creation Date:17/09/2019
 */
public static void navigatebranch()throws Throwable
{
driver.findElement(By.xpath(p.getProperty("objBranches"))).click();
Thread.sleep(3000);
}
/*Project Name:Primus Bank
 * Module Name:Admin logout
 * Author:Ranga
 * Creation Date:17/09/2019
 */
public static boolean verifyLogout()
{
driver.findElement(By.xpath(p.getProperty("objlogout"))).click();
if(driver.findElement(By.xpath(p.getProperty("objloginbtn"))).isDisplayed())
{
Reporter.log("Logout Success",true);
return true;
}
else{
Reporter.log("Logout Fail",true);
return false;
}
}
}



















