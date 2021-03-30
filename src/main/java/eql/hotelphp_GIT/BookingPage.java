package eql.hotelphp_GIT;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {
	
	@FindBy (xpath = "//div[@style='left: 0px; top: 0px; width: 40px; height: 50px; position: absolute;']")
	private WebElement firstCell;
	
	@FindBy (xpath = "//div[@style='left: 40px; top: 0px; width: 40px; height: 50px; position: absolute;']")
	private WebElement secondCell;
	
	@FindBy (xpath = "//div[.='Update successful']")
	private WebElement updateMessage;
	
	@FindBy (xpath = "//div[.='Deleted.']")
	private WebElement deleteMessage;
	
	@FindBy (tagName = "iframe")
	private WebElement framePopup;
	
	@FindBy(id = "name")
	private WebElement nameField;
	
	@FindBy(xpath = "//input[@value='Save']")
	private WebElement saveButton;
	
	@FindBy(id = "room")
	private WebElement roomNumberSelect;
	
	@FindBy (xpath = "//div[@class='scheduler_default_event_inner']")
	private List<WebElement> listCellsFilled;
	
	@FindBy (xpath ="//div[@class='scheduler_default_event_delete']")
	private WebElement deleteResaButton;
	
	public void clickDeleteResaButton() {
		deleteResaButton.click();
	}
	
	public void clickFirstCell(WebDriver driver) {
		firstCell.click();
		driver.switchTo().frame(framePopup.getAttribute("id"));
	}	
	
	
	public WebElement getFirstCell() {
		return firstCell;
	}

	public WebElement getSecondCell() {
		return secondCell;
	}


	public void createNewResa(WebDriver driver, String str, String roomValue) {
		ToolBox.fillInput(nameField, str);
		
		Select select = new Select(roomNumberSelect);
		select.selectByValue(roomValue);
		
		saveButton.submit();
		
		driver.switchTo().defaultContent();
	}
	
	public WebElement getCellFilled(int indexCell) {
		return listCellsFilled.get(indexCell);
	}
	
	public WebElement getUpdateMessage() {
		return updateMessage;
	}
	
	public WebElement getDeleteMessage() {
		return deleteMessage;
	}

}
