package VKAPI;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VkApiTest {

	private VkApi vkApi;
	private String ownerId = "536083852";

	@Before
	public void setUp() throws Exception {
		vkApi = new VkApi();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void wallPostHealthCheckTest() {
		String message = "Test post API message";
		String postId = vkApi.wallPost(ownerId, message);
		assertTrue(vkApi.getWallPostByID(ownerId, postId));
	}

	@Test
	public void wallEditHealthCheckTest() {
		String message = "Test post API message";
		String postId = vkApi.wallPost(ownerId, message);
		String message2 = "Test post API Edit message";
		int i = 1; // code for successful response
		assertTrue(Integer.parseInt(vkApi.wallEdit(ownerId, postId, message2)) == i);
	}

	@Test
	public void deleteHealthCheckTest() {
		String message = "Test post API message for delete";
		String postId = vkApi.wallPost(ownerId, message);
		int i = 1; // code for successful response
		assertTrue(Integer.parseInt(vkApi.wallPostDelete(ownerId, postId)) == i);

	}

}
