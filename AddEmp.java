package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmp {
@FindBy(id="menu_pim_viewPimModule")
WebElement ClickPim;
@FindBy(id="btnAdd")
WebElement ClickAdd;
@FindBy(name="firstName")
WebElement EnterFname;
@FindBy(name="lastName")
WebElement EnterLname;
@FindBy(name="employeeId")
WebElement EnterEID;
@FindBy(id="btnSave")
WebElement ClickSave;
public String verifyEmp(WebDriver driver,String fname,String lname,String eid)
throws Throwable{
	String res=null;
ClickPim.click();
Thread.sleep(3000);
ClickAdd.click();
Thread.sleep(3000);
EnterFname.sendKeys(fname);
EnterLname.sendKeys(lname);
EnterEID.clear();
EnterEID.sendKeys(eid);
ClickSave.click();
Thread.sleep(5000);
if(driver.getCurrentUrl().contains("empNumber"))
{
res="Add Employee Success";
}
else{
res="Add Employee FAil";
}
return res;
}
}















