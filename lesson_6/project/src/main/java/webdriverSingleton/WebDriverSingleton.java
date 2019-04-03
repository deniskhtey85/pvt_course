package webdriverSingleton;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

	private static WebDriver driver;
	private static ChromeOptions options;

	private WebDriverSingleton() {
	}

	public static WebDriver getWebDriverInstance() {
		if (null == driver) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			driver = new ChromeDriver(options);
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
