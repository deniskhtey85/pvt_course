package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailboxPage {

	WebDriver driver;

	@FindBy(xpath = "(//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])])")
	private List<WebElement> lettersList;

	@FindBy(xpath = "(//div[contains(@class,'checkbox__box') and ancestor::div[@id='b-letters']and not(ancestor::div[contains(@style, 'display: none;')])])")
	public List<WebElement> checkboxList;

	@FindBy(xpath = "(//div[contains(@class, 'b-checkbox__box')])[1]")
	public WebElement checkAll;

	@FindBy(xpath = "(//div[@data-name='spam'])[1]")
	public WebElement spamButton;

	@FindBy(xpath = "(//div[@data-name='noSpam'])[1]")
	public WebElement noSpamButton;

	@FindBy(xpath = "//span[contains(text(),'Входящие')]")
	public WebElement incomingMailFolder;

	@FindBy(xpath = "//div[@id='b-nav_folders']//span[text()='Спам']")
	public WebElement spamFolder;

	@FindBy(xpath = "(//a[@data-name='compose'])[1]")
	private WebElement writeLetterButton;

	@FindBy(xpath = "(.//*[@data-original-name='To'])[1]")
	private WebElement letterRecipient;

	@FindBy(xpath = ".//*[@name='Subject']")
	private WebElement topicLetter;

	@FindBy(xpath = "//iframe")
	public WebElement iframeTextMessage;

	@FindBy(xpath = "(//div[@data-name='send'])[1]")
	public WebElement sendButton;

	@FindBy(xpath = ".//div[@class='message-sent__title']")
	private WebElement messageSentTitle;

	@FindBy(xpath = "//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]//div[contains(@class, 'b-flag_yes')]//b")
	public List<WebElement> flagsList;

	@FindBy(xpath = "(//div[contains(@class, 'b-dropdown_more')])[1]")
	public WebElement moreButtons;

	@FindBy(xpath = "(//a[@data-name='flag_no'])[1]")
	public WebElement removeFlags;

	public MailboxPage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, this);
		driver = webDriver;
	}

	public void clickCheckbox(int index) {
		try {
			checkboxList.get(index).click();
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void clickSpamButton() {
		spamButton.click();
	}

	public void clickNoSpamButton() {
		noSpamButton.click();
	}

	public void goToSpamFolder() {
		spamFolder.click();
		driver.navigate().refresh();
		threadSleep();
	}

	public void moveLetterToSpam(int index) {
		clickCheckbox(index);
		clickSpamButton();
		threadSleep();
	}

	public void extractLetterFromSpam(int index) {
		goToSpamFolder();
		clickCheckbox(index);
		clickNoSpamButton();
		driver.navigate().refresh(); 
	}

	public void goToIncomingFolder() {
		incomingMailFolder.click();
		driver.navigate().refresh();
	}

	public void sentLetter(String receivers, String topic, String text) {
		writeLetterButton.click();
		letterRecipient.sendKeys(receivers);
		topicLetter.sendKeys(topic);
		enterMessage(text);
		sendButton.click();
	}

	public void enterMessage(String message) {
		driver.switchTo().frame(iframeTextMessage).findElement(By.xpath("//body")).sendKeys(message);
		driver.switchTo().defaultContent();
	}

	public String getMessageSentTitle() {
		return messageSentTitle.getText();
	}

	public List<WebElement> getLettersList() {
		return lettersList;
	}

	public void markFlagOfFirst(int count) {
		List<WebElement> messages = lettersList;
		for (int row = 0; row < count; row++) {
			(messages.get(row)).findElement(By.xpath(".//div[@data-act='flag']")).click();
		}
	}

	public void removeAllFlag() {
		checkAll.click();
		moreButtons.click();
		removeFlags.click();
	}

	public List<WebElement> getMarkTheFlag() {
		return flagsList;
	}

	public void threadSleep() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
