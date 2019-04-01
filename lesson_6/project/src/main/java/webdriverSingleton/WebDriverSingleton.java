package webdriverSingleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

	private static WebDriver driver;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance() {
		if (null == driver) {
			driver = new ChromeDriver();
		}
		return driver;
	}

	public static void driverQuit() {
		if (null != driver) {
			driver.quit();
		}
		driver = null;
	}

}
