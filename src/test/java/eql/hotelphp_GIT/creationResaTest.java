package eql.hotelphp_GIT;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import bdd.BddOutils;



public class creationResaTest extends AbstractTest {
	
	String newResa = "resa 1";
	String roomNumber = "1";
	private int startDay =01;
	
	@Before
	public void setup() throws Exception {
		selectBrowser(browser);
		BddOutils.deleteAllData("src/test/resources/deleteReservation.xml");
	}
	
	@After
	public void endTest() throws Exception {
		BddOutils.deleteAllData("src/test/resources/deleteReservation.xml");
	}
	@Test
	public void test() throws SQLException, Exception {
	
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		booking_page.clickFirstCell(driver);
		
		booking_page.createNewResa(driver, newResa, roomNumber);
		
		BddOutils.compareData("reservations","src/test/resources/insertReservation.xml",startDay, "id");

		String actualResa = booking_page.getCellFilled(0).getText();
		assertTrue("La reservation ne correspond pas à celle créée", actualResa.contains(newResa));
	}
}
