package eql.hotelphp_GIT;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DragandDropTest extends AbstractTest {
	
	@Before
	public void setup() {
		selectBrowser(browser);
	}	
	
	@Test
	public void dragandDrop() {
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(booking_page.getFirstCell(), booking_page.getSecondCell()).build().perform();
		
		
	}
	
	

}
