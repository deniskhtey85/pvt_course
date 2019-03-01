package core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookingTests {

	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Test execution for Booking.com");
	}

	@Before
	public void before() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://booking.com");
	}

	void setDate(LocalDate inDate, LocalDate outDate) {
		WebElement calendar = driver.findElement(By.xpath(".//div[@class='xp__dates-inner xp__dates__checkin']"));
		calendar.click();
		driver.findElement(By.xpath("//table//td[@data-date='" + inDate.toString() + "']")).click();
		driver.findElement(By.xpath("//table//td[@data-date='" + outDate.toString() + "']")).click();
	}

	void searchBy—onditions(String cityName, int bookStartDate, int bookPeriod) {
		int bookEndDate = bookStartDate + bookPeriod;
		WebElement searchboxDestinationField = driver.findElement(By.xpath(".//input[@id='ss']"));
		searchboxDestinationField.sendKeys(cityName);
		setDate(LocalDate.now().plusDays(bookStartDate), LocalDate.now().plusDays(bookEndDate));
		WebElement searchboxSubmitBtn = driver.findElement(
				By.xpath("//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[@type='submit']"));
		searchboxSubmitBtn.click();
	}

	@After
	public void after() {
		driver.quit();
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Complete");
	}

	@Test
	public void findHotelsByConditionsTest() {
		searchBy—onditions("ÃÓÒÍ‚‡", 3, 7);
		List<WebElement> hotelUrlList = driver.findElements(By.xpath("//a[@class='hotel_name_link url']"));
		assertFalse(hotelUrlList.isEmpty());
	}

	@Test
	public void filterReviewListTest() {
		searchBy—onditions("ÃÓÒÍ‚‡", 2, 4);
		List<WebElement> filterReviewList = driver.findElements(By.xpath("//div[@id='filter_review']//a"));
		filterReviewList.get(0).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> hotelUrlList = driver.findElements(By.xpath(".//a[@class='hotel_name_link url']"));
		hotelUrlList.get(0).click();
		driver.switchTo().activeElement();
		Double rating = Double.valueOf(
				driver.findElement(By.xpath(".//div[@class='bui-review-score__badge']")).getText().replace(",", "."));
		assertTrue(rating >= 9.0);
	}

}
