package eql.hotelphp_GIT;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bdd.BddOutils;

public class DragandDropTest extends AbstractTest {
	
	@Before
	public void setup() throws Exception {
		selectBrowser(browser);
		BddOutils.insertData("src/test/resources/insertReservation.xml");
	}	
	
	@Test
	public void dragandDrop() {
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(booking_page.getFirstCell(), booking_page.getSecondCell()).build().perform();
		
		WebElement updateMessage = booking_page.getUpdateMessage();
		
		assertTrue(updateMessage.isDisplayed());
		wait.until(ExpectedConditions.invisibilityOf(updateMessage));
		assertFalse(updateMessage.isDisplayed());
	}
	
	@After
	public void endTest() throws Exception {
		BddOutils.deleteAllData("src/test/resources/deleteReservation.xml");
	}
	

}
