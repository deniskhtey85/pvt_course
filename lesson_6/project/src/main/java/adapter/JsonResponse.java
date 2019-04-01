package adapter;

public class JsonResponse {
	
	JsonObject jsonObject;

	public JsonResponse() {
	}

	public JsonResponse(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public boolean isJsonEqual(JsonObject jsonObject) {
		String actual = this.jsonObject.getJsonAsString();
		String expected = jsonObject.getJsonAsString();
		return actual.equals(expected);
	}

}
