package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YoutubeChannelSearchPage {

	WebDriver driver;
	public YoutubeChannelSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//By serch_box = By.id("search");
	
	@FindBy(how=How.ID,using="search")
	public WebElement SearchTextBox;
	
	
//	By search_btn = By.id("search-icon-legacy");
	@FindBy(how=How.ID,using= "search-icon-legacy")
	public WebElement search_btn;
	
	public void NavigateToReultPage() throws InterruptedException {
		SearchTextBox.sendKeys("selenium by bakkappa n");
		search_btn.click();
		Thread.sleep(3000);
	}
	
}
