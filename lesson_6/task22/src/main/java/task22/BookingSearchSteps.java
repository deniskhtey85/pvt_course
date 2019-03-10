package task22;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingSearchSteps {

	private static final String Booking_URL = "https://booking.com";
	private WebDriver webDriver;
	private BookingSearchPage bookingSearchPage;

	public BookingSearchSteps() {
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		bookingSearchPage = new BookingSearchPage(webDriver);
	}

	@Given("^I am on main booking page$")
	public void goToBookingMainPage() {
		webDriver.get(Booking_URL);
	}

	@When("^I execute searching for hotels in \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void executeSearchByCityRoomsAdults(String city, int countRooms, int countAdults) {
		bookingSearchPage.setSearchConditions(city, 3, 7, countRooms, countAdults);
		bookingSearchPage.clickSearchboxSubmitBtn();
	}

	@Then("^I see a list of hotels that match the conditions$")
	public void hotelListIsPresented() {
		assertFalse(bookingSearchPage.gethotelUrlList().isEmpty());
	}

	@When("^I execute filtering by rating$")
	public void filterHotelsListByBestRating() {
		bookingSearchPage.filterByReview(0);
	}

	@When("^I go to the first hotel from the result list$")
	public void goToFirstHotelFromHotelsList() {
		bookingSearchPage.navigateToHotelDetailPageFromListByIndex(0);
	}

	@Then("^I see the hotel with \"([^\"]*)\"$")
	public void checkHotelRating(double rating) {
		assertTrue(bookingSearchPage.getHotelRating() >= rating);
	}

	@After
	public void afterClass() {
		webDriver.quit();
	}

}
