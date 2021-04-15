
package Components;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class homepage {
	
WebDriver driver;

By Login=By.xpath("//*[@id=\"ctl00_divLogin\"]/ul/li[1]/a");
By username = By.xpath("//*[@id=\"ctl00_phBody_SignIn_txtEmail\"]");
By password = By.xpath("//*[@id=\"ctl00_phBody_SignIn_txtPassword\"]");
By signin=By.xpath("//*[@id=\"ctl00_phBody_SignIn_btnLogin\"]");
By bookswagon_logo = By.xpath("//*[@id=\"header\"]/div[2]/a");
By cart_number_icon=By.xpath("//*[@id=\"topright-menu\"]/div[2]/div[1]/a/span");
By search_box=By.xpath("//*[@id=\"ctl00_TopSearch1_txtSearch\"]");
By click_profile=By.xpath("//*[@id=\"ctl00_divLogged\"]/ul/li/a/span");
By log_out=By.xpath("//*[@id=\"ctl00_lnkbtnLogout\"]");

/**
 * This constructor is used to initialize webelements and contains the same driver as that of invoked method
 * @author THANKAM
 * @param driver
 */

public homepage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

/**
 * This method is used to login into the bookswagon account
 * @author THANKAM
 */

public void login()
{
	driver.findElement(Login).click();
	driver.findElement(username).sendKeys("bookswagonproject@gmail.com");
	driver.findElement(password).sendKeys("Proj@123");
	driver.findElement(signin).click();
	System.out.println("User logged in successfully");
}

/**
 * This method is used to verify logo
 * @author THANKAM
 * @return checks whether logo is displayed or not
 */

public boolean verifybookswagonlogo()
{ 
	boolean isDisplayed=driver.findElement(bookswagon_logo).isDisplayed();
	return isDisplayed;
}

/**
 * This method is used to verify cart count
 * @author THANKAM
 * @param expected_count
 * @return checks whether the cart count is equal to expected count
 */
public boolean verifycartcount(String expected_count)
{
	boolean match=driver.findElement(cart_number_icon).getText().equals(expected_count);
	return match;
}

/**
 * This method is used to search the required book
 * @author THANKAM
 * @param prodName
 */
public  void searchproduct(String prodName)  {
	driver.findElement(search_box).sendKeys(prodName);
	driver.findElement(search_box).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

/**
 * This method is used to sign out 
 * @author THANKAM
 */
public void signout() {
	// TODO Auto-generated method stub
	driver.findElement(click_profile).click();
	driver.findElement(log_out).click();
}



	
}



