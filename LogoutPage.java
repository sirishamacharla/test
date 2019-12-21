package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
@FindBy(id="welcome")
WebElement ClickWelcome;
@FindBy(linkText="Logout")
WebElement ClickLogout;
@FindBy(name="Submit")
WebElement ClickLogoin;
public String verifyLogout(WebDriver driver)
throws Throwable{
String res=null;
ClickWelcome.click();
Thread.sleep(3000);
ClickLogout.click();
Thread.sleep(3000);
if(ClickLogoin.isDisplayed())
{
res="Logout Success";
}
else{
	res="Logout Fail";
}
return res;
}


}
