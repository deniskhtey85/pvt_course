package adapter;

public class XmlResponseAdapter {
	
	XmlObject xmlObject;

	public XmlResponseAdapter(XmlObject xmlObject) {
		super();
		this.xmlObject = xmlObject;
	}

	public JsonObject getJsonObject() {
		return new JsonObject("{\"response\":1}");
	}

}
