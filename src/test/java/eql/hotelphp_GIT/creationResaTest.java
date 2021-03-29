package eql.hotelphp_GIT;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;



public class creationResaTest extends AbstractTest{

	
	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@Test
	public void test() {
	
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		booking_page.clickFirstCell(driver);
		
		
		
	}

}
