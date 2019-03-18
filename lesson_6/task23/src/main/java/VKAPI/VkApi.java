package VKAPI;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class VkApi {

	private static final String CLIENT_ID = "6901002";
//	private static final String SCOPE = "offline";
	private static final String VERSION = "5.92";

	public String getToken() {
		String token = "4a156a6be6bbaa2711b5d0fa24fcd838a50d346917f6edbd57d8b1c73f75b6c88cd0c282ead68db48d552";
		return token;
	}

	public String getToken(String scope) throws URISyntaxException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		URIBuilder builder = null;
		String token = null;
		builder = new URIBuilder("https://oauth.vk.com/authorize?");
		builder.setParameter("client_id", CLIENT_ID).setParameter("display", "page")
				.setParameter("redirect_uri", "https://oauth.vk.com/blank.html").setParameter("response_type", "token")
				.setParameter("callback", "wall").setParameter("state", "123456").setParameter("scope", scope)
				.setParameter("v", VERSION);
		HttpGet request = new HttpGet(builder.build());
		HttpResponse response = client.execute(request);
		String url = request.getURI().toString();
		System.out.println(url);
		token = EntityUtils.toString(response.getEntity());
		System.out.println(token);
		return token;
	}

	public String wallPost(String ownerId, String message) {
		HttpClient client = HttpClientBuilder.create().build();
		String postId = null;
		try {
			URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.post?");
			builder.setParameter("access_token", getToken()).setParameter("owner_id", ownerId)
					.setParameter("message", message).setParameter("v", VERSION);
			HttpGet request = new HttpGet(builder.build());
			HttpResponse response = client.execute(request);
			postId = getWallPostID(EntityUtils.toString(response.getEntity()));
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return postId;
	}

	public String wallEdit(String ownerId, String post_id, String message) {
		HttpClient client = HttpClientBuilder.create().build();
		String responseId = null;
		try {
			URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.edit?");
			builder.setParameter("access_token", getToken()).setParameter("owner_id", ownerId)
					.setParameter("post_id", post_id).setParameter("message", message).setParameter("v", VERSION);
			HttpGet request = new HttpGet(builder.build());
			HttpResponse response = client.execute(request);
			responseId = getResponseID(EntityUtils.toString(response.getEntity()));
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return responseId;
	}

	public String wallPostDelete(String ownerId, String post_id) {
		HttpClient client = HttpClientBuilder.create().build();
		String responseId = null;
		try {
			URIBuilder builder = new URIBuilder("https://api.vk.com/method/wall.delete?");
			builder.setParameter("access_token", getToken()).setParameter("owner_id", ownerId)
					.setParameter("post_id", post_id).setParameter("v", VERSION);
			HttpGet request = new HttpGet(builder.build());
			HttpResponse response = client.execute(request);
			responseId = getResponseID(EntityUtils.toString(response.getEntity()));
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return responseId;
	}

	public boolean getWallPostByID(String ownerId, String wallPost_id) {
		int successfulStatusCode = 200;
		HttpClient client = HttpClientBuilder.create().build();
		int result = 0;
		try {
			URIBuilder builder = new URIBuilder("https://api.vk.com/method//wall.getById?");
			builder.setParameter("access_token", getToken()).setParameter("posts", ownerId + "_" + wallPost_id)
					.setParameter("copy_history_depth", "2").setParameter("extended", "0").setParameter("v", VERSION);
			HttpGet request = new HttpGet(builder.build());
			HttpResponse response = client.execute(request);
			result = response.getStatusLine().getStatusCode();
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return result == successfulStatusCode;
	}

	private String getWallPostID(String id) {
		return id.replaceAll("[^0-9]", "");
	}

	private String getResponseID(String id) {
		return id.replaceAll("[^0-9]", "");
	}

}
