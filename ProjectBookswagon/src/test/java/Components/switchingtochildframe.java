package Components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class switchingtochildframe {
	WebDriver driver;
	By child_frame=By.xpath("//*[@id=\"cboxLoadedContent\"]/iframe");
	By shop_more_items=By.cssSelector("#BookCart_uplnShopping > div.shopping-action > table > tbody > tr > td:nth-child(1) > a > span");
	
	/**
	 * This constructor is used to initialize webelements and contains the same driver as that of invoked method
	 * @author THANKAM
	 * @param driver
	 */

	public  switchingtochildframe(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * This method is used to switch to child frame 
	 * @author THANKAM
	 */

	public  void switchframes()  {
		
		driver.switchTo().frame(driver.findElement(child_frame));}
	
	public void working_on_elements_in_childframe() {
		
		System.out.println("Shoppingcart Popup is displayed");
	    driver.findElement(shop_more_items).click();
	    System.out.println("Shoppingcart Popup is closed");
	   
		}
	
	/**
	 * This method is used to switch to parent frame
	 * @author THANKAM
	 */
	    public void switchtoparentframe() {
		driver.switchTo().defaultContent();
		}

	

}
