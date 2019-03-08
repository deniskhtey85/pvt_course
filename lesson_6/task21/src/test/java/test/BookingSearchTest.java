package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.BookingSearchPage;

public class BookingSearchTest {

	private WebDriver driver;
	private BookingSearchPage bookingSearchPage;
	private static final String city = "Москва";

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		bookingSearchPage = new BookingSearchPage(driver);
		driver.get(bookingSearchPage.getBookingUrl());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void findHotelsByConditionsTest() {
		bookingSearchPage.setSearchConditions(city, 3, 7, 1, 2);
		bookingSearchPage.clickSearchboxSubmitBtn();
		assertFalse(bookingSearchPage.gethotelUrlList().isEmpty());
	}

	@Test
	public void filterReviewListTest() {
		bookingSearchPage.setSearchConditions(city, 3, 7, 1, 2);
		bookingSearchPage.clickSearchboxSubmitBtn();
		bookingSearchPage.filterByReview(0);
		bookingSearchPage.navigateToHotelDetailPageFromListByIndex(0);
		double ratingMinBoundaryValue = 9.0;
		assertTrue(bookingSearchPage.getHotelRating() >= ratingMinBoundaryValue);
	}

}
