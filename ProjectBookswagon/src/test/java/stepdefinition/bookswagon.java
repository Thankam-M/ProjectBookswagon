package stepdefinition;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Components.homepage;
import Components.searchresultspage;
import Components.switchingtochildframe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;

public class bookswagon {
	WebDriver driver;
	homepage login;
	homepage Homepage;
	homepage searchproduct;
	searchresultspage searchpage;
	searchresultspage sortingprice;
	searchresultspage lowtohigh;
	searchresultspage navigatetomusic;
	searchresultspage selectfirstbook;
	homepage logout;
	switchingtochildframe switchframes;
	switchingtochildframe elementsinchildframe;
	switchingtochildframe returntoparentframe;

	/**
	 * This method is used to start the chrome
	 * @author THANKAM
	 */
	@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe"); 
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	}
	
	/**
	 * This method is used to navigate to homepage and login
	 * @author THANKAM
	 */
	
	@Given("User navigates to homepage")
	public void user_navigates_to_homepage() {
	   driver.get("https://www.bookswagon.com/");
	   login=new homepage(driver);
	   login.login();
	   }
	
	/**
	 * This method is used to verify whether logo displayed or not
	 * @author THANKAM
	 */
	@Then("Verify Bookswagon Logo displayed")
	public void verify_Bookswagon_Logo_displayed() {
		Homepage=new homepage(driver);
		boolean out=Homepage.verifybookswagonlogo();
		Assert.assertTrue(out);}
	
/**
 * This method is used to verify whether cart is zero or not
 * @author THANKAM
 */
	@Then("verify cart has no items")
	public void verify_cart_has_no_items() {
	    
		boolean out=Homepage.verifycartcount("0");
		Assert.assertTrue(out);}

	/**
	 * This method is used to search the particular type of book
	 * @author THANKAM
	 * @param string
	 * @throws InterruptedException 
	 */
	
	@When("user search for {string}")
	public void user_search_for(String string) {
	    
		Homepage.searchproduct(string);
	 }

	/**
	 * This method is used to verify searched product and displayed product are same or not
	 * @author THANKAM
	 * @param string
	 */
	
	@Then("verify search results displayed for {string}")
	public void verify_search_results_displayed_for(String string) {
	   
	searchpage=new searchresultspage(driver);
		boolean out=searchpage.verifysearchresults(string);

		Assert.assertTrue(out);
		
	}
	
	/**
	 * This method is used to navigate to other categories
	 * @author THANKAM
	 * @param string
	 */
	@Then("Navigate to {string} category")
	public void navigate_to_category(String string)  {
	   
		 navigatetomusic=new searchresultspage(driver);
			navigatetomusic.navigatingtomusic(string);
	}	
	

	/**
	 * This method is used to verify sort option
	 * @author THANKAM
	 */
	
	
	@Then("Verify sort option on that page")
	public void verify_sort_option_on_that_page()  {
	sortingprice=new searchresultspage(driver);
	boolean out=sortingprice.sortingprices();
	Assert.assertTrue(out);
	}
	
	/**
	 * This method is used to choose particular sort option
	 * @author THANKAM
	 * @param string
	 */
	@Then("user changes sort from discount {string}")
	public void user_changes_sort_from_discount(String string)   {
	    
		lowtohigh=new searchresultspage(driver);
		lowtohigh.lowtohigh(string);
		}
	
	/**
	 * This method is used to select the first book
	 * @author THANKAM 
	 */
   
	
	@Then("user clicks on buy now button for first book")
	public void user_clicks_on_buy_now_button_for_first_book()  {
	  
	   selectfirstbook = new searchresultspage(driver);
	   selectfirstbook.selectingfirstbook();
	   }
/**
 * This method is used to switch to another frame
 * @author THANKAM 
 */
	
	@Then("user clicls on shop more items")
	public void user_clicls_on_shop_more_items()  {
	   switchframes=new switchingtochildframe(driver);
		switchframes.switchframes();
		elementsinchildframe=new switchingtochildframe(driver);
		elementsinchildframe.working_on_elements_in_childframe();
		returntoparentframe=new switchingtochildframe(driver);
		returntoparentframe.switchtoparentframe();
		try {
		    Thread.sleep(1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		}
	
	/**
	 * This method is used to verify whether cart has 1 item
	 * @author THANKAM
	 * @param int1
	 */

	@Then("verify cart has {int} item")
	public void verify_cart_has_item(Integer int1) {
		
	    boolean out=Homepage.verifycartcount("1");
		Assert.assertTrue(out);
}

/**
 * This method is used to sign out
 * @author THANKAM	
 */
	@Then("user sign out from website")
public void user_sign_out_from_website() {
   logout = new homepage(driver);
	logout.signout();}

	/**
	 * This method is used to close the tab
	 * @author THANKAM
	 */
   
@After
public void sessionend()
{
	driver.close();
}






}
