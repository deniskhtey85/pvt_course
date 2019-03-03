package core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
import org.openqa.selenium.support.ui.Select;

public class BookingTest19 {

	static WebDriver driver;

	void setDate(LocalDate inDate, LocalDate outDate) {
		WebElement calendar = driver.findElement(By.xpath(".//div[@class='xp__dates-inner xp__dates__checkin']"));
		calendar.click();
		driver.findElement(By.xpath("//table//td[@data-date='" + inDate.toString() + "']")).click();
		driver.findElement(By.xpath("//table//td[@data-date='" + outDate.toString() + "']")).click();
	}

	void searchByСonditions(String cityName, int bookStartDate, int bookPeriod) {
		int bookEndDate = bookStartDate + bookPeriod;
		WebElement searchboxDestinationField = driver.findElement(By.xpath(".//input[@id='ss']"));
		searchboxDestinationField.sendKeys(cityName);
		setDate(LocalDate.now().plusDays(bookStartDate), LocalDate.now().plusDays(bookEndDate));
		WebElement searchboxSubmitBtn = driver.findElement(
				By.xpath("//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[@type='submit']"));
		searchboxSubmitBtn.click();
	}

	void setGroupAdults(int index) {
		WebElement groupAdults = driver.findElement(By.id("group_adults"));
		Select groupAdultsSelect = new Select(groupAdults);
		groupAdultsSelect.selectByIndex(index);
	}

	void setGroupChildren(int index) {
		WebElement groupChildren = driver.findElement(By.id("group_children"));
		Select groupChildrenSelect = new Select(groupChildren);
		groupChildrenSelect.selectByIndex(index);
	}

	void setRooms(int index) {
		WebElement rooms = driver.findElement(By.id("no_rooms"));
		Select roomsSelect = new Select(rooms);
		roomsSelect.selectByIndex(index);
	}

	void searchByGroups(int adults, int children, int rooms) {
		setGroupAdults(adults);
		setGroupChildren(children);
		setRooms(rooms);
		WebElement searchFormSubmitBtn = driver.findElement(By.xpath("//form[@id='frm']//button[@type='submit']"));
		searchFormSubmitBtn.click();
	}

	void filterByPrice(int index) {
		List<WebElement> filterPriceList = driver.findElements(By.xpath("//div[@id='filter_price']//a"));
		filterPriceList.get(index).click();
	}

	void filterByReview(int index) {
		List<WebElement> filterReviewList = driver.findElements(By.xpath("//div[@id='filter_review']//a"));
		filterReviewList.get(index).click();
	}

	void threadSleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	void sortByPriceAsc() {
		WebElement sortByPriceAscBtn = driver
				.findElement(By.xpath("//div[@data-block-id='sort_bar']//a[@data-category='price']"));
		sortByPriceAscBtn.click();
	}

	void comparePricesHotelAndFilter(String[] priceFilterCopyList, double targetHotelFullPrice, int totalNights) {
		List<Double> priceFilterNumbersFromCopy = new ArrayList<>();
		for (String i : priceFilterCopyList) {
			try {
				priceFilterNumbersFromCopy.add(Double.parseDouble(i));
			} catch (NumberFormatException e) {
				continue;
			}
		}

		if (priceFilterNumbersFromCopy.size() == 1) {
			double minPrice = priceFilterNumbersFromCopy.get(0);
			assertTrue(minPrice < targetHotelFullPrice / totalNights);
			System.out.println(minPrice + " < " + targetHotelFullPrice / totalNights);
		} else {
			double minPrice = priceFilterNumbersFromCopy.get(0);
			double maxPrice = priceFilterNumbersFromCopy.get(1);
			assertTrue(minPrice < targetHotelFullPrice / totalNights);
			assertTrue(maxPrice > targetHotelFullPrice / totalNights);
			System.out.println(minPrice + " < " + targetHotelFullPrice / totalNights + " < " + maxPrice);

		}
	}

	void navigateToHotelDetailPageFromSearchResultList(int index) {
		List<WebElement> hotelUrlList = driver.findElements(By.xpath("//a[@class='hotel_name_link url']"));
		assertFalse(hotelUrlList.isEmpty());
		hotelUrlList.get(index).click();
	}

	void bookRoom(int rooms) {
		new Select(driver.findElements(By.xpath("(.//select[@class='hprt-nos-select'])[1]")).get(0))
				.selectByIndex((rooms));
	}

	void clickBookBtn() {
		WebElement bookBtn = driver
				.findElement(By.xpath("//div[@class='hprt-reservation-cta']//button[@type='submit']"));
		bookBtn.click();
	}

	void setUserFirstLastNamesEmail(String firstName, String lastName, String email) {

		new Select(driver.findElements(By.xpath("//*[@id='booker_title']")).get(0)).selectByIndex(1);
		WebElement firstNameBooker = driver.findElement(By.xpath("//*[@id='firstname']"));
		firstNameBooker.sendKeys(firstName);
		WebElement lastNameBooker = driver.findElement(By.xpath("//*[@id='lastname']"));
		lastNameBooker.sendKeys(lastName);
		WebElement emailBooker = driver.findElement(By.xpath("//*[@id='email']"));
		emailBooker.sendKeys(email);
		WebElement emailConfirmBooker = driver.findElement(By.xpath("//*[@id='email_confirm']"));
		emailConfirmBooker.sendKeys(email);
	}

	void clickNextFinalDataBtn() {
		WebElement nextFinalDataBtn = driver.findElement(By.xpath("//button[@name='book']"));
		nextFinalDataBtn.click();
	}

	void setPhone(String phoneNumber) {
		WebElement phoneField = driver.findElement(By.xpath("//input[@id='phone']"));
		phoneField.sendKeys(phoneNumber);
	}

	void setDateOfBirth(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
		List<WebElement> bDay = driver.findElements(By.xpath("//select[@id='bday']"));
		new Select(bDay.get(0)).selectByValue(dayOfBirth);
		List<WebElement> bMonth = driver.findElements(By.xpath("//select[@id='bmonth']"));
		new Select(bMonth.get(0)).selectByValue(monthOfBirth);
		List<WebElement> bYear = driver.findElements(By.xpath("//select[@id='byear']"));
		new Select(bYear.get(0)).selectByValue(yearOfBirth);
	}

	void setCardData(String typeCC, String numberCC, String validMonthNumber, String validYearNumber, String cvcCC) {
		List<WebElement> ccType = driver.findElements(By.xpath("//*[@id='cc_type']"));
		new Select(ccType.get(0)).selectByValue(typeCC);
		WebElement ccNumber = driver.findElement(By.xpath("//*[@id='cc_number']"));
		ccNumber.sendKeys(numberCC);
		List<WebElement> validCardMonth = driver.findElements(By.xpath("//*[@id='cc_month']"));
		new Select(validCardMonth.get(0)).selectByValue(validMonthNumber);
		List<WebElement> validCardYear = driver.findElements(By.xpath("//*[@id='ccYear']"));
		new Select(validCardYear.get(0)).selectByValue(validYearNumber);
		WebElement cvcCode = driver.findElement(By.xpath("//*[@id='cc_cvc']"));
		cvcCode.sendKeys(cvcCC);
	}

	void clickFinishBookingBtn() {
		WebElement finishBookingBtn = driver
				.findElement(By.xpath("//div[@class='bp-overview-buttons-wrapper']//button[@name='book']"));
		finishBookingBtn.click();
	}

	String cardDataError() {
		WebElement errorCardMessage = driver.findElement(By.xpath("//*[@id='bp_form_cc_number_msg']"));
		return errorCardMessage.getText().trim();
	}

	void switchToNewTab() {
		Set<String> windows = driver.getWindowHandles();
		for (String windowHandle : windows) {
			driver.switchTo().window(windowHandle);
		}
	}

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

	@After
	public void after() {
		
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Complete");
		driver.quit();
	}

	@Test
	public void checkPriceAfterFilterByPriceAndByReview() {
		searchByСonditions("Париж", 3, 7);
		searchByGroups(1, 0, 0);
		filterByPrice(0);
		threadSleep();
		List<WebElement> hotelUrlList = driver.findElements(By.xpath("//a[@class='hotel_name_link url']"));
		assertFalse(hotelUrlList.isEmpty());
		filterByReview(0);
		threadSleep();
		WebElement priceFilterCopyByIndex = driver.findElement(By.xpath("(//div[@id='filter_price']//span)[1]"));
		String[] priceFilterCopyList = priceFilterCopyByIndex.getText().split(" ");
		WebElement hotelFullPrice = driver.findElement(By.xpath("(//div[@id='hotellist_inner']//td//b)[1]"));
		double targetHotelFullPrice = Double.parseDouble(hotelFullPrice.getText().replaceAll("\\D+", ""));
		System.out.println("hotel full price = " + targetHotelFullPrice);
		comparePricesHotelAndFilter(priceFilterCopyList, targetHotelFullPrice, 7);

	}

	@Test
	public void checkPriceAfterFilterByPriceAndSortByPrice() {
		searchByСonditions("Париж", 3, 7);
		searchByGroups(3, 0, 1);
		filterByPrice(4);
		threadSleep();
		sortByPriceAsc();
		threadSleep();
		String[] priceFilterCopyList = driver.findElement(By.xpath("(//div[@id='filter_price']//span)[9]")).getText()
				.split(" ");
		double targetHotelFullPrice = Double.parseDouble(
				driver.findElement(By.xpath("(//div[@id='hotellist_inner']//b[@class='sr_gs_price_total'])[1]"))
						.getText().replaceAll("\\D+", ""));
		System.out.println("hotel full price = " + targetHotelFullPrice);
		comparePricesHotelAndFilter(priceFilterCopyList, targetHotelFullPrice, 7);
	}

	@Test
	public void bookHotelWithInvalidCardData() {
		checkPriceAfterFilterByPriceAndSortByPrice();
		navigateToHotelDetailPageFromSearchResultList(0);
		switchToNewTab();
		bookRoom(1);
		clickBookBtn();
		setUserFirstLastNamesEmail("Ivan", "Ivanov", "ivanov@gmail.com");
		clickNextFinalDataBtn();
		setPhone("291234567");
		setDateOfBirth("11", "11", "1985");
		setCardData("Visa", "4242424242424241", "09", "2020", "222");
		clickFinishBookingBtn();
		String expectedErrorMessage = "Введите номер действительной кредитной карты";
		assertEquals(cardDataError(), expectedErrorMessage);
	}

}
