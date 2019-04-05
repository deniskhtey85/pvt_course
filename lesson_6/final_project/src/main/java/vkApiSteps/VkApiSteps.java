package vkApiSteps;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.allure.annotations.Attachment;
import vkApiClient.Api200Response;
import vkApiClient.VkApi;
import vkApiData.VkApiData;

public class VkApiSteps {
	private static String idPost = null;
	private static VkApiData vkApiData;
	private HttpResponse response;
	private static Api200Response api200response;
	private VkApi vkApi;
	private static final Logger log = Logger.getLogger(VkApiSteps.class);
	private static int statusActual;
	private static final int STATUS_EXPECTED = 200;

	public VkApiSteps() {
		vkApi = new VkApi();
		api200response = new Api200Response();
	}

	@Before
	public void starter() {
		try {
			vkApiData = vkApi.getDataFromXml();
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		log.trace("XML data parsed successfully");
	}

	@When("^I sent post request to the wall$")
	public void postMessage() {
		try {
			response = vkApi.wallPost(vkApiData);
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is posted to the wall$")
	public void isMessagePosted() {
		try {
			idPost = vkApi.getWallpostId(response);
		} catch (Throwable e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		statusActual = response.getStatusLine().getStatusCode();
		if (statusActual == STATUS_EXPECTED) {
			log.info("Message is posted on the wall");
		} else {
			log.error("Message is posted on the wall with error");
		}
		Assert.assertEquals(statusActual, STATUS_EXPECTED);
	}

	@When("^I edit message on the wall by post id$")
	public void editMessage() {
		try {
			response = vkApi.wallEdit(vkApiData, idPost);
		} catch (URISyntaxException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is edited successfully$")
	public void isMessageEdited() {
		boolean isEditSuccessfull = false;
		try {
			isEditSuccessfull = api200response.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
		if (isEditSuccessfull) {
			log.info("Message is edited on the wall");
		} else {
			log.error("Message isn't e on the wall with error");
		}
		Assert.assertTrue(isEditSuccessfull);
	}

	@When("^I delete message from the wall by post id$")
	public void deleteMessage() {
		try {
			response = vkApi.wallDelete(vkApiData, idPost);
		} catch (URISyntaxException | IOException e) {
			log.error(e.getMessage());
			log.trace(e.getStackTrace());
		}
	}

	@Then("^Message is deleted successfully$")
	public void isMessageDeleted() {
		boolean isDeleteSuccessfull = false;
		try {
			isDeleteSuccessfull = api200response.isApiResponseSuccessfully(EntityUtils.toString(response.getEntity()));
		} catch (ParseException | IOException e) {
			log.error(e.getMessage());
		}
		if (isDeleteSuccessfull) {
			log.info("Message is deleted on the wall");
		} else {
			log.error("Message is deleted from the wall with error");
		}
		Assert.assertTrue(isDeleteSuccessfull);
	}
	
	@Attachment()
    private byte[] createAttachment(String att) {
        String content = att;
        return content.getBytes();
    }

}