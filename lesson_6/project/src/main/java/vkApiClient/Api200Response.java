package vkApiClient;

import adapter.JsonObject;
import adapter.JsonResponse;
import adapter.XmlResponse;
import adapter.XmlResponseAdapter;

public class Api200Response {
	
	public boolean isApiResponseSuccessfully(String responseString) {
		JsonObject JSONObject = new JsonObject(responseString);
		JsonResponse jSONResponse = new JsonResponse(JSONObject);
		XmlResponse xMLResponse = new XmlResponse();
		XmlResponseAdapter XMLResponseAdapter = new XmlResponseAdapter(xMLResponse.getXmlObject());
		return jSONResponse.isJsonEqual(XMLResponseAdapter.getJsonObject());
	}

}
