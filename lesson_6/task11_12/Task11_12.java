package core;

public class Task11_12 {

	public static void main(String[] args) {

		Page page = new Page();
		
		System.out.println("Operations with Buttons");
		Button button1 = new Button("Button 1", "action for button 1");
        Button button2 = new Button("Button 2","action for button 2");
        Button button3 = new Button("Button 3", "action for button 3");
        page.add(button1);
        page.add(button2);
        page.add(button3);
        page.printButtons();
        page.remove(button1);
        page.printButtons();
        page.replace(button2,button1);
        page.printButtons();
        
        System.out.println("Operations with Fields");
        Field field1 = new Field(1,"Field 1");
        Field field2 = new Field(2,"Field 2");
        Field field3 = new Field(3,"Field 3");
        page.add(field1);
        page.add(field2);
        page.add(field3);
        page.printFields();
        page.remove(field1);
        page.printFields();
        page.replace(field2,field1);
        page.printFields();
        
        System.out.println("Operations with Labels");
        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        Label label3 = new Label("lLabel 3");
        page.add(label1);
        page.add(label2);
        page.add(label3);
        page.printLabels();
        page.remove(label1);
        page.printLabels();
        page.replace(label2,label1);
        page.printLabels();
      
        System.out.println("Operations with Dropdowns");
        Dropdown dropdown1 = new Dropdown("Dropdown 1");
        Dropdown dropdown2 = new Dropdown("Dropdown 2");
        Dropdown dropdown3 = new Dropdown("Dropdown 3");
        page.add(1,dropdown1);
        page.add(2,dropdown2);
        page.add(3,dropdown3);
        page.printDropdowns();
        page.remove(dropdown1);
        page.printDropdowns();
        page.replace(dropdown2,dropdown1);
        page.printDropdowns();
	}

}
