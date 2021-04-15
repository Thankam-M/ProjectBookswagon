package Components;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class searchresultspage {

String selectsorting="Product_discount asc";
By search_results_text =By.xpath("//*[@id=\"site-wrapper\"]/div[2]/div[3]/div[1]/div[1]/h1/span");
By sort_option_on_the_page=By.xpath("//*[@id=\"site-wrapper\"]/div[2]/div[3]/div[2]/div[2]/div/div[2]");
By sort_price=By.xpath("//*[@id=\"ddlSort\"]");
By select_Low_to_high=By.xpath("//*[@value='Product_discount asc']");
By select_category=By.xpath("//*[@id=\"ctl00_licategory\"]/a[1]");
By select_firstbook=By.xpath("//*[@id=\"listSearchResult\"]/div[1]/div[1]");
By click_buynow=By.xpath("//*[@value='Buy Now']");

WebDriver driver;
/**
 * This constructor is used to initialize webelements and contains the same driver as that of invoked method
 * @author THANKAM
 * @param driver
 */

public  searchresultspage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

/**
 * This method is used to verify whether the displayed results and text entered are same or not
 * @author THANKAM
 * @param searchtext
 * @return whether the displayed results and text entered are same or not
 */

public boolean verifysearchresults(String searchtext)
{
	System.out.println(driver.findElement(search_results_text).getText().trim());
	boolean match=driver.findElement(search_results_text).getText().trim().replace("\"","" ).equals(searchtext);
	return match;
}
/**
 * This method is used to click the sort option
 * @author THANKAM
 */
public boolean sortingprices() {
	boolean sort=driver.findElement(sort_option_on_the_page).isDisplayed();
	return sort;
	
}

/**
 * This method is used to select the type of sorting
 * @author THANKAM
 * @param string
 */

public void lowtohigh(String string) 

{ driver.findElement(sort_price).click();
	Select s=new Select(driver.findElement(sort_price));
s.selectByVisibleText(string);
try {
    Thread.sleep(1000);
} catch (InterruptedException ie) {
    Thread.currentThread().interrupt();
}
}

/**
 * This method is used to navigate from existing page to another category and display that category of books
 * @return THANKAM
 * @param category
 */
public void navigatingtomusic(String category) 
{
	driver.findElement((select_category)).click();
	Actions action = new Actions(driver);
	WebElement Element = driver.findElement(By.linkText(category));
	action.moveToElement(Element).click().build().perform();
	
}

/**
 * This method is used to select the first book from the list
 * @author THANKAM
 */
public void selectingfirstbook() {
	// TODO Auto-generated method stub
	driver.findElement(select_firstbook).click();
	driver.findElement(click_buynow).click();
	try {
	    Thread.sleep(1000);
	} catch (InterruptedException ie) {
	    Thread.currentThread().interrupt();
	}
	
}
}
