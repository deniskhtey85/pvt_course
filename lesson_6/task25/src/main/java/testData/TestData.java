package testData;

import dbSQL.SQLRequests;

public class TestData {

	String login;
	String password;
	String topic;
	String mailCopy;
	String recipient;

	public TestData(String id) {
		this.login = request.getValueParam("login", id);
		this.password = request.getValueParam("password", id);
		this.topic = request.getValueParam("topic", id);
		this.mailCopy = request.getValueParam("text", id);
		this.recipient = request.getValueParam("recipient", id);

	}

	SQLRequests request = new SQLRequests();

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getMailCopy() {
		return mailCopy;
	}

	public void setMailCopy(String mailCopy) {
		this.mailCopy = mailCopy;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

}
