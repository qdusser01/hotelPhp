package eql.hotelphp_GIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage {
	
	@FindBy (xpath = "//div[@class='scheduler_default_cell scheduler_default_cell_business']")
	private WebElement firstCell;
	
	@FindBy (id = "_1617013078322n5.280887664609222iframe")
	private WebElement framePopup;
	
	public void clickFirstCell(WebDriver driver) {
		firstCell.click();
		driver.switchTo().frame(framePopup);
	}
	
	

}
