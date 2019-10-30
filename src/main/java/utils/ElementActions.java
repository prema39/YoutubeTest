package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
	public WebDriver driver;
	public WebDriverWait wait;
	public Actions action;
	public JavascriptExecutor js;

	public ElementActions(WebDriver driver) {
		this.driver = driver;

		wait = new WebDriverWait(driver, 20);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;

	}

	public enum DropDownType {
		by_visible_text, by_value, by_index;

	}

	public void selectDropDown(By locator, DropDownType type, Object value) {
		Select select = new Select(driver.findElement(locator));
		switch (type) {
		case by_index:
			int index = (Integer) value;
			select.selectByIndex(index);
			break;
		case by_value:
			String typeValue = (String) value;
			select.selectByValue(typeValue);
			break;
		case by_visible_text:
			String typeText = (String) value;
			select.selectByVisibleText(typeText);
			break;

		}
	}

	public void clickOn(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();

	}

	public void enterText(By locator, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));

	}

	public void scrollTillElement(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement element=driver.findElement(locator);
		js.executeScript("argument[0].scrollIntoView", element);
		
	}
	public void mouseHover(By locator) {
		WebElement target = driver.findElement(locator);
		action.moveToElement(target).build().perform();
		
	}
	}