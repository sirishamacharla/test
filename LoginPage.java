package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//Maintain OR For Login page
@FindBy(name="txtUsername")
WebElement EnterUsername;
@FindBy(name="txtPassword")
WebElement EnterPassword;
@FindBy(name="Submit")
WebElement ClickLogin;
//method for Login
public String verifyLogin(WebDriver driver,String username,String password)
throws Throwable{
	String res="";
EnterUsername.sendKeys(username);	
EnterPassword.sendKeys(password);
ClickLogin.click();
Thread.sleep(3000);
if(driver.getCurrentUrl().contains("dash"))
{
res="Login Success";
}
else{
res="Login fail";
}
return res;
}
}













