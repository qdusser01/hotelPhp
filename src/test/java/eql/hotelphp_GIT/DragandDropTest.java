package eql.hotelphp_GIT;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		
		WebElement updateMessage = booking_page.getUpdateMessage();
		
		assertTrue(updateMessage.isDisplayed());
		wait.until(ExpectedConditions.invisibilityOf(updateMessage));
		assertFalse(updateMessage.isDisplayed());
		
	}
	
	

}
