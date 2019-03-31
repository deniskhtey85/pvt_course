package webdriverSingleton;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebDriverSettings {

	protected WebDriver driver;
	protected WebDriverWait wait;
	private static final int LINK_PRESENSE_TIMEOUT = 30;

	public WebDriverSettings(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT);
	}

	public WebDriver setInitialProperty() {
		driver.manage().window().maximize();
		return driver;
	}
	
	public void goToNewTab() {
		String currentHandle = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
		    if (!handle.equals(currentHandle)) driver.switchTo().window(handle);
		}
	}

}
