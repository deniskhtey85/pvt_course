package dbTestData;

import dbSqlClient.DBRequest;

public class TestData {

	private String login;
	private String password;
	private String topic;
	private String mailCopy;
	private String recipient;
	private DBRequest request = new DBRequest();

	public TestData() {
		this.login = request.getValueParam("login");
		this.password = request.getValueParam("password");
		this.topic = request.getValueParam("topic");
		this.mailCopy = request.getValueParam("text");
		this.recipient = request.getValueParam("recipient");

	}

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
