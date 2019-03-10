package task22;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingSearchPage {
	private WebDriver driver;

	@FindBy(xpath = (".//input[@id='ss']"))
	private WebElement searchboxDestinationField;

	@FindBy(xpath = ".//div[@class='xp__dates-inner xp__dates__checkin']")
	private WebElement calendar;

	@FindBy(xpath = ".//span[@class= 'xp__guests__count']")
	private WebElement guestAndRoomsfield;

	@FindBy(xpath = "(.//span[@data-bui-ref= 'input-stepper-value'])[1]")
	private WebElement roomsCount;

	@FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-add-button'])[1]")
	private WebElement roomsPlusbtn;

	@FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-subtract-button'])[1]")
	private WebElement roomsMinusBtn;

	@FindBy(xpath = ".//select[@id='no_rooms']")
	private List<WebElement> selectForRooms;

	@FindBy(xpath = "(.//span[@data-bui-ref= 'input-stepper-value'])[2]")
	private WebElement adultsCount;

	@FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-add-button'])[2]")
	private WebElement adultsPlusBtn;

	@FindBy(xpath = "(.//*[@data-bui-ref= 'input-stepper-subtract-button'])[2]")
	private WebElement adultsMinusBtn;

	@FindBy(xpath = ".//select[@name='group_adults']")
	private List<WebElement> selectForAdults;

	@FindBy(xpath = "//div[contains(@class,'sb-searchbox-submit-col -submit-button')]//button[@type='submit']")
	private WebElement searchboxSubmitBtn;

	@FindBy(xpath = "//div[@id='filter_review']//a")
	private List<WebElement> filterReviewList;

	@FindBy(xpath = "//a[@class='hotel_name_link url']")
	private List<WebElement> hotelUrlList;

	@FindBy(xpath = ".//div[@class='bui-review-score__badge']")
	private WebElement hotelRating;

	public BookingSearchPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		this.driver = webDriver;
	}

	public List<WebElement> gethotelUrlList() {
		return hotelUrlList;
	}

	private void setDate(LocalDate inDate, LocalDate outDate) {
		calendar.click();
		driver.findElement(By.xpath("//table//td[@data-date='" + inDate.toString() + "']")).click();
		driver.findElement(By.xpath("//table//td[@data-date='" + outDate.toString() + "']")).click();
	}

	public void setSearchConditions(String city, int bookStartDate, int bookPeriod, int countRooms, int countAdults) {
		searchboxDestinationField.clear();
		searchboxDestinationField.sendKeys(city);
		int bookEndDate = bookStartDate + bookPeriod;
		setDate(LocalDate.now().plusDays(bookStartDate), LocalDate.now().plusDays(bookEndDate));
		guestAndRoomsfield.click();
		setCountRooms(countRooms);
		setCountAdults(countAdults);
	}

	private void setCountRooms(int countRooms) {
		if (selectForRooms.size() > 0) {
			new Select(selectForRooms.get(0)).selectByIndex(countRooms - 1);
		} else {
			if (countRooms > Integer.parseInt(roomsCount.getText())) {
				while (countRooms != Integer.parseInt(roomsCount.getText()))
					roomsPlusbtn.click();
			}
			if (countRooms < Integer.parseInt(roomsCount.getText())) {
				while (countRooms != Integer.parseInt(roomsCount.getText()))
					roomsMinusBtn.click();
			}
		}
	}

	private void setCountAdults(int countAdults) {
		if (selectForAdults.size() > 0) {
			new Select(selectForAdults.get(0)).selectByIndex(countAdults - 1);
		} else {
			if (countAdults > Integer.parseInt(adultsCount.getText())) {
				while (countAdults != Integer.parseInt(adultsCount.getText()))
					adultsPlusBtn.click();
			}
			if (countAdults < Integer.parseInt(adultsCount.getText())) {
				while (countAdults != Integer.parseInt(adultsCount.getText()))
					adultsMinusBtn.click();
			}
		}
	}

	public void navigateToHotelDetailPageFromListByIndex(int index) {
		gethotelUrlList().get(index).click();
		driver.switchTo().activeElement();
	}

	public void clickSearchboxSubmitBtn() {
		searchboxSubmitBtn.click();
	}

	private void waitSleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void filterByReview(int index) {
		filterReviewList.get(index).click();
		waitSleep();
	}

	public Double getHotelRating() {
		return Double.valueOf(hotelRating.getText().replace(",", "."));

	}
}
