package core;

public class Button {
	
	String name;
	String action;
	
	public Button (String name) {
		this.name = name;
	}
	
	public Button (String name, String action) {
		this.name = name;
		this.action = action;
	}
	
	@Override
	public String toString() {
		return "Button name: " + name + " / action: " + action ;
	}


	public boolean equals (Button button) {
		return this.name.equals(button.name) && this.action.equals(button.action);
	}

}
