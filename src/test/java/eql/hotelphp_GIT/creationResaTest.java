package eql.hotelphp_GIT;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;



public class creationResaTest extends AbstractTest {
	
	String newResa = "resa 1";
	String roomNumber = "1";
	
	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@Test
	public void test() {
	
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		booking_page.clickFirstCell(driver);
		
		booking_page.createNewResa(driver, newResa, roomNumber);

		String actualResa = booking_page.getCellFilled(0).getText();
		assertTrue("La reservation ne correspond pas à celle créée", actualResa.contains(newResa));
	}
}
