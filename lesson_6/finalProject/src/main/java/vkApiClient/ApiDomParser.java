package vkApiClient;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import vkApiData.VkApiData;

public class ApiDomParser {
	
	public List<VkApiData> parse(Document document) throws FileNotFoundException, XMLStreamException {
		NodeList nodeList = document.getElementsByTagName("apiVKData");
		List<VkApiData> apiVkDataList = new ArrayList<VkApiData>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			apiVkDataList.add(getApiVkData(nodeList.item(i)));
		}
		return apiVkDataList;
	}

	private static VkApiData getApiVkData(Node node) {
		VkApiData vkApiData = new VkApiData();
		Element element = (Element) node;
		vkApiData.setAccessToken(getTagValue("accessToken", element));
		vkApiData.setOwnerId(getTagValue("ownerId", element));
		vkApiData.setVersion(getTagValue("version", element));
		vkApiData.setNewMessage(getTagValue("newMessage", element));
		vkApiData.setEditMessage(getTagValue("editMessage", element));
		vkApiData.setUriBuilderPost(getTagValue("uriBuilderPost", element));
		vkApiData.setUriBuilderEdit(getTagValue("uriBuilderEdit", element));
		vkApiData.setUriBuilderDelete(getTagValue("uriBuilderDelete", element));
		return vkApiData;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = nodeList.item(0);
		return node.getNodeValue();
	}

}
