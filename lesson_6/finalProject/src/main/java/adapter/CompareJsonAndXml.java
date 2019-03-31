package adapter;

public class CompareJsonAndXml {
	
	public static boolean compareJsonAndXml(String response) {
		JsonObject jsonObject = new JsonObject(response);
		JsonResponse jsonResponse = new JsonResponse(jsonObject);

		XmlResponse xmlResponse = new XmlResponse();
		XmlResponseAdapter xmlResponseAdapter = new XmlResponseAdapter(xmlResponse.getXmlObject());

		return jsonResponse.isJsonEqual(xmlResponseAdapter.getJsonObject());
			
	}

}
