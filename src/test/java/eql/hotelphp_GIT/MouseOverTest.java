package eql.hotelphp_GIT;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import bdd.BddOutils;

public class MouseOverTest extends AbstractTest {
	
	private int startDay = 01;
	
	@Before
	public void setup() throws Exception {
		selectBrowser(browser);
		BddOutils.insertData("src/test/resources/insertReservation.xml",startDay);
	}	
	
//	@After
	public void endTest() throws Exception {
		BddOutils.deleteAllData("src/test/resources/deleteReservation.xml");
	}
	
	@Test
	public void test() throws Throwable{
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		BookingPage booking_page = PageFactory.initElements(driver, BookingPage.class);
		
		WebElement resa=booking_page.getCellFilled(0);
		
		Actions a = new Actions(driver);
		a.moveToElement(resa).build().perform();
		
		booking_page.clickDeleteResaButton();
		
		WebElement deleteMessage = wait.until(ExpectedConditions.visibilityOf(booking_page.getDeleteMessage()));
		
		assertTrue("le message de suppression n'est pas affiché" ,deleteMessage.isDisplayed());
		
		Thread.sleep(7000);
		
		assertFalse("le message de suppression n'a pas disparu" ,deleteMessage.isDisplayed());
		
		
	}

}
