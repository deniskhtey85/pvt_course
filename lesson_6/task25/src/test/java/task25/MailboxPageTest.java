package task25;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.MailboxPage;
import testData.TestData;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MailboxPageTest {

	private WebDriver driver;
	private MailboxPage mailboxPage;
	private LoginPage loginPage;
	private final int TIMEOUT_FOR_IMPLICITLY = 10;
	private final int TIMEOUT_FOR_LOAD = 10;
	private static TestData testData;

	@BeforeClass
	public static void setUpTestData() throws Exception {
		testData = new TestData("1");
	}

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TIMEOUT_FOR_IMPLICITLY, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TIMEOUT_FOR_LOAD, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://mail.ru");
		loginPage = new LoginPage(driver);
		mailboxPage = new MailboxPage(driver);
		loginPage.enterDataForLogin(testData.getLogin(), testData.getPassword());
		loginPage.clickEnterButton();
		mailboxPage.goToIncomingFolder();
	}

	@Test
	public void test1_moveLatterToSpamTest() {
		String titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		mailboxPage.moveLetterToSpam(0);
		mailboxPage.goToSpamFolder();
		String titleLetterSpam = mailboxPage.getLettersList().get(mailboxPage.getLettersList().size() - 1)
				.getAttribute("data-subject");
		assertEquals(titleLetter, titleLetterSpam);
	}

	@Test
	public void test2_extractFromSpamTest() {
		mailboxPage.goToSpamFolder();
		String titleLetter = mailboxPage.getLettersList().get(0).getAttribute("data-subject");
		mailboxPage.extractLetterFromSpam(0);
		mailboxPage.goToIncomingFolder();
		assertEquals(mailboxPage.getLettersList().get(0).getAttribute("data-subject"), titleLetter);
	}

	@Test
	public void test5_sendMessToGroupTest() {
		mailboxPage.sentLetter(testData.getRecipient(), testData.getTopic(), testData.getMailCopy());
		String expectedMess = "Ваше письмо отправлено. Перейти во Входящие";
		assertEquals(mailboxPage.getMessageSentTitle(), expectedMess);
	}

	@Test
	public void test3_mark3LettersFlagTest() {
		int numberMarked = 3;
		mailboxPage.markFlagOfFirst(numberMarked);
		assertEquals(numberMarked, mailboxPage.flagsList.size());
	}

	@Test
	public void test4_deselectAllFlagsTest() {
		mailboxPage.removeAllFlag();
		assertFalse(mailboxPage.getMarkTheFlag().size() > 0);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
