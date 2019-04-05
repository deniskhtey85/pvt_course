package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import webdriverSingleton.WebDriverSettings;

public class LoginPage extends WebDriverSettings {

	@FindBy(xpath = "//input[@id='mailbox:login']")
	private WebElement loginField;

	@FindBy(xpath = "//input[@id='mailbox:password']")
	private WebElement passwordField;

	@FindBy(xpath = "//label[@id='mailbox:submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	private WebElement logoutLink;

	@FindBy(xpath = "//a[@id='PH_regLink']")
	private WebElement loginErrorHint;

	@FindBy(xpath = "//input[@id='mailbox:saveauth']")
	private WebElement saveAuthCheckbox;

	@FindBy(xpath = "//a[@id='restore']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//form[@class='js-form-account']//button[@type='submit']")
	private WebElement restorePasswordbutton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isRestorePasswordbuttonDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(restorePasswordbutton)).isDisplayed();
	}

	public void enterDataForLogin(String login, String password) {
		enterText(loginField, login);
		enterText(passwordField, password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public boolean isLogoutLinkDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(logoutLink)).isDisplayed();
	}

	private void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public boolean isLoginErrorHintDisplayed() {
		return wait.until(ExpectedConditions.visibilityOf(loginErrorHint)).isDisplayed();
	}

	public boolean isSaveAuthCheckboxChecked() {
		return saveAuthCheckbox.isSelected();
	}

	public void clickForgotPasswordLink() {
		forgotPasswordLink.click();
	}

}
