package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {
//maintain OR for Add user page
@FindBy(id="menu_admin_viewAdminModule")
WebElement ClickAdmin;
@FindBy(id="btnAdd")
WebElement ClickAdd;
@FindBy(id="systemUser_employeeName_empName")
WebElement EnterEname;
@FindBy(id="systemUser_userName")
WebElement EnterUsername;
@FindBy(id="systemUser_password")
WebElement EnterPassword;
@FindBy(id="systemUser_confirmPassword")
WebElement EnterCPassword;
@FindBy(id="btnSave")
WebElement ClickSave;
public String verifyUser(WebDriver driver,String ename,String username,String password,String cpassword)
throws Throwable{
	String res="";
ClickAdmin.click();
Thread.sleep(3000);
ClickAdd.click();
Thread.sleep(3000);
EnterEname.sendKeys(ename);
EnterUsername.sendKeys(username);
EnterPassword.sendKeys(password);
EnterCPassword.sendKeys(cpassword);
ClickSave.click();
Thread.sleep(5000);
if(driver.getCurrentUrl().contains("viewSystemUsers"))
{
res="Add User is Success";	
}
else{
	res="Add User is Fail";
}
return res;
}


}











