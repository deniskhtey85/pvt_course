package task20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailboxPageTest {

	private WebDriver driver;
	private MailboxPage mailboxPage;
	private LoginPage loginPage;
	private final String EMAIL = "d.k.h.t.e.y";
	private final String PASSWORD = "Dm-1930013";
	private final int TIMEOUT_FOR_IMPLICITLY = 10;
	private final int TIMEOUT_FOR_LOAD = 10;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT_FOR_IMPLICITLY, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT_FOR_LOAD, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://mail.ru");
		loginPage = new LoginPage(driver);
		mailboxPage = new MailboxPage(driver);
		loginPage.enterDataForLogin(EMAIL, PASSWORD);
		loginPage.clickEnterButton();
		mailboxPage.goToIncomingFolder();
	}

	@Test // 1 перемещение письма в Спам
	public void test1_moveLatterToSpamTest() {
		String titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		mailboxPage.moveLetterToSpam(0);
		mailboxPage.threadSleep();
		mailboxPage.goToSpamFolder();
		String titleLetterSpam = mailboxPage.getLettersList().get(mailboxPage.getLettersList().size() - 1)
				.getAttribute("data-subject");
		assertEquals(titleLetter, titleLetterSpam);
	}

	@Test // 2
	public void test2_extractFromSpamTest() {
		mailboxPage.moveLetterToSpam(0);
		mailboxPage.goToSpamFolder();
		String titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		mailboxPage.extractLetterFromSpam(0);
		mailboxPage.threadSleep();
		mailboxPage.goToIncomingFolder();
		assertEquals(mailboxPage.getLettersList().get(0).getAttribute("data-subject"), titleLetter);
	}

	@Test // 5
	public void test5_sendMessToGroupTest() {
		String recipients = "khtej.denis+1@gmail.com, khtej.denis+2@gmail.com";
		String topic = "TestTopic";
		String text = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor.";
		mailboxPage.sentLetter(recipients, topic, text);
		String expectedMess = "Ваше письмо отправлено. Перейти во Входящие";
		assertEquals(mailboxPage.getMessageSentTitle(), expectedMess);
	}

	@Test // 3
	public void test3_mark3LettersFlagTest() {
		int numberMarked = 3;
		mailboxPage.markFlagOfFirst(numberMarked);
		assertEquals(numberMarked, mailboxPage.flagsList.size());
	}

	@Test // 4
	public void test4_deselectAllFlagsTest() {
		mailboxPage.removeAllFlag();
		assertFalse(mailboxPage.getMarkTheFlag().size() > 0);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
