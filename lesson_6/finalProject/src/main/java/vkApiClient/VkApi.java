package vkApiClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import vkApiData.ApiData;
import vkApiData.VkApiData;

public class VkApi implements ApiData {

	private URIBuilder builder;
	private HttpGet request;
	private HttpResponse response;
	private HttpClient client;

	public VkApi() {

	}

	public VkApiData getDataFromXml() throws Throwable {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			throw e1;
		}
		Document document;
		try {
			document = dBuilder.parse(VK_API_TEST_DATA_XML);
		} catch (SAXException | IOException e) {
			throw e;
		}
		List<VkApiData> vkApiDataList;
		try {
			vkApiDataList = new ApiDomParser().parse(document);
		} catch (FileNotFoundException | XMLStreamException ex) {
			throw ex;
		}
		return vkApiDataList.get(0);
	}

	public HttpResponse wallPost(VkApiData vkApiData) throws Throwable {
		try {
			client = HttpClientBuilder.create().build();
			builder = new URIBuilder(vkApiData.getUriBuilderPost());
			builder.setParameter("access_token", vkApiData.getAccessToken())
					.setParameter("owner_id", vkApiData.getOwnerId()).setParameter("message", vkApiData.getNewMessage())
					.setParameter("v", vkApiData.getVersion());
			request = new HttpGet(builder.build());
			response = client.execute(request);
		} catch (URISyntaxException | IOException ex) {
			throw ex;
		}
		return response;
	}

	public String getWallpostId(HttpResponse response) throws Throwable {
		String newIdResponse;
		try {
			newIdResponse = EntityUtils.toString(response.getEntity());
		} catch (ParseException | IOException e) {
			throw e;
		}
		if (newIdResponse == null) {
			return null;
		} else {
			StringBuffer id = new StringBuffer();
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(newIdResponse);
			while (m.find()) {
				id.append(m.group());
			}
			return id.toString();
		}
	}

	public HttpResponse wallEdit(VkApiData vkApiData, String idPost) throws URISyntaxException, IOException {
		client = HttpClientBuilder.create().build();
		try {
			builder = new URIBuilder(vkApiData.getUriBuilderEdit());
		} catch (URISyntaxException ex) {
			throw ex;
		}
		builder.setParameter("access_token", vkApiData.getAccessToken())
				.setParameter("owner_id", vkApiData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("message", vkApiData.getEditMessage()).setParameter("v", vkApiData.getVersion());
		request = new HttpGet(builder.build());
		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return response;
	}

	public HttpResponse wallDelete(VkApiData vkApiData, String idPost) throws IOException, URISyntaxException {
		client = HttpClientBuilder.create().build();
		try {
			builder = new URIBuilder(vkApiData.getUriBuilderDelete());
		} catch (URISyntaxException ex) {
			throw ex;
		}
		builder.setParameter("access_token", vkApiData.getAccessToken())
				.setParameter("owner_id", vkApiData.getOwnerId()).setParameter("post_id", idPost)
				.setParameter("v", vkApiData.getVersion());
		request = new HttpGet(builder.build());
		try {
			response = client.execute(request);
		} catch (IOException e) {
			throw e;
		}
		return response;
	}
}
