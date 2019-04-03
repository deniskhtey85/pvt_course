package pageSteps;


import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dbTestData.TestData;
import page.LoginPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import screenshot.Screenshot;
import webdriverSingleton.WebDriverSingleton;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;

public class LoginPageSteps {
	
	private static final String MAIN_URL = "http://mail.ru";
	private LoginPage loginPage;
	private TestData userDataTable;
	private WebDriver webDriver;
	private static final Logger log = Logger.getLogger(LoginPageSteps.class);


	public LoginPageSteps() {
		webDriver = WebDriverSingleton.getWebDriverInstance();
		loginPage = new LoginPage(webDriver);
		loginPage.setInitialProperty();
//		userDataTable = new TestData();
	}

	@Before
	public void beforeClass(){
		userDataTable = new TestData();
	}
	

	@Given("^Main application page is opened$")
	public void loadMainPage() {
		webDriver.get(MAIN_URL);
		log.info("Main application page is opened");
	}

	@When("^Enter correct user login and password$")
	public void loginAsCorrectUser() {
		loginPage.enterDataForLogin(userDataTable.getLogin(), userDataTable.getPassword());
		loginPage.clickLoginButton();
		log.info("User authorised successfully");
	}
	
	@When("^I click Forgot Password link$")
	public void clickForgotPasswordlink() {
		loginPage.clickForgotPasswordLink();
		log.info("Click forgot password link");
	}
	
	@Then("^I see Restore Password button$")
	public void seeRestorePasswordButton() {
		loginPage.goToNewTab();
		Assert.assertTrue(loginPage.isRestorePasswordbuttonDisplayed());
		log.info("Restore password button os shown");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}

	@Then("^Logout link is displayed$")
	public void seeLogoutLink() {
		Assert.assertTrue(loginPage.isLogoutLinkDisplayed());
		log.info("Log out link is displayed");
		try {
			Screenshot.makeScreenshot(webDriver);
		} catch (IOException e) {
			log.warn(e.getMessage());
		}
	}
	
	@Then("^saveAuth Checkbox is selected$")
	public void seeSaveAuthCheckboxSelected() {
		Assert.assertTrue(loginPage.isSaveAuthCheckboxChecked());
		log.info("Save auth checkbox is selected");
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
