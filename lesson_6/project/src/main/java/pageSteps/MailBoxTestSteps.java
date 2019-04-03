package pageSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dbTestData.TestData;
import page.LoginPage;
import page.MailBoxPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import screenshot.Screenshot;
import webdriverSingleton.WebDriverSingleton;

public class MailBoxTestSteps {

	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private MailBoxPage mailboxPage;
	private TestData userDataTable;
	private WebDriver webDriver;
	private String titleLetter = null;
	private int numberMarked;
	private static final Logger log = Logger.getLogger(LoginPageSteps.class);

	public MailBoxTestSteps() {
		webDriver = WebDriverSingleton.getWebDriverInstance();
		loginPage = new LoginPage(webDriver);
		mailboxPage = new MailBoxPage(webDriver);
		loginPage.setInitialProperty();
//		userDataTable = new TestData();

	}

	@Before
    public void beforeClass(){
        userDataTable = new TestData();
    }

	@Given("^I am an authorized user on the mail page$")
	public void openMailBoxPage() {
		webDriver.get(MAIN_URL);
		loginPage.enterDataForLogin(userDataTable.getLogin(), userDataTable.getPassword());
		loginPage.clickLoginButton();
		loginPage.isLogoutLinkDisplayed();
		log.info("User is login");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^I sent mail to the group of users$")
	public void sentMailToGroupOfUsers() {
		mailboxPage.sentLetter(userDataTable.getRecipient(), userDataTable.getTopic(), userDataTable.getMailCopy());
		log.info("Sent mail to the group of users");
	}

	@When("^I mark latters by flag$")
	public void markLettersByFlag() {
		numberMarked = 3;
		mailboxPage.markFlagOfFirst(numberMarked);
		log.info("Letters are marked");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^I remove all flags from letters$")
	public void unmarkFlagFromLetters() {
		mailboxPage.removeAllFlag();
		log.info("Flags removed from letters");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^I extract letter from spam$")
	public void extractLetterFromSpam() {
		titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		log.info("Letter exist in spam");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
		mailboxPage.extractLetterFromSpam(0);
	}

	@When("^I navigate to incoming folder$")
	public void navigateToIncomingFolder() {
		mailboxPage.goToIncomingFolder();
		log.info("Go to incoming folder");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^I move letter to a spam folder$")
	public void moveLetterToSpam() {
		titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		mailboxPage.moveLetterToSpam(0);
		log.info("Move letter to spam");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@When("^I navigate to the spam folder$")
	public void navigateToSpamFolder() {
		mailboxPage.goToSpamFolder();
		log.info("Go to spam folder");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^I see this letter in spam folder$")
	public void checkLetterInSpamFolder() {
		String titleLetterSpam = mailboxPage.getLettersList().get(mailboxPage.getLettersList().size() - 1)
				.getAttribute("data-subject");
		assertEquals(titleLetter, titleLetterSpam);
		log.info("Letter exist in spam folder");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^I see this letter in incoming folder$")
	public void checkLetterInIncomingFolder() {
		assertEquals(mailboxPage.getLettersList().get(0).getAttribute("data-subject"), titleLetter);
		log.info("See letter moved to incoming folder");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^I see Latters are marked$")
	public void checkMarkedLatters() {
		assertEquals(numberMarked, mailboxPage.flagsList.size());
		log.info("Marked latters are shown");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^I see latters are unmarked$")
	public void checkUnmarkedLatters() {
		assertFalse(mailboxPage.getMarkTheFlag().size() > 0);
		log.info("Letters unmarked");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^I see \"([^\"]*)\" notification$")
	public void messageSentNotification(String copy) {
		assertEquals(mailboxPage.getMessageSentTitle(), copy);
		log.info("notification shown");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@After
	public void afterClass() {
		WebDriverSingleton.driverQuit();
	}
	
	@Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }

}
