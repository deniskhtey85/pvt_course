package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Page {
	
	ArrayList<Button> buttons = new ArrayList<>();
	LinkedList<Field> fields = new LinkedList<>();
	HashSet<Label> labels = new HashSet<>();
	HashMap<Integer, Dropdown> dropdowns = new HashMap<>();
	float id;
	String title;

	
	////
	public boolean add (Button newButton) {
		return buttons.add(newButton);
	}
	
	public boolean add (Field newField) {
		return fields.add(newField);
	}
	
	public boolean add (Label newLabel) {
		return labels.add(newLabel);
	}
	
	public boolean add (Integer index, Dropdown newDropdown) {
		dropdowns.put(index, newDropdown);
		return dropdowns.get(index).equals(newDropdown);
	}
	
	////
	public boolean remove (Button delButton) {
		ArrayList<Button> newButtons = new ArrayList<>();
		for (Object button : buttons) {
			if (!button.equals(delButton)) {
				newButtons.add((Button) button);
			}
		}
		buttons = newButtons;
		return !buttons.contains(delButton);
	}
	
	public boolean remove (Field delField) {
		LinkedList<Field> newFields = new LinkedList<>();
		for (Object field : fields) {
			if (!field.equals(delField)) {
				newFields.add((Field) field);
			}
		}
		fields = newFields;
		return !fields.contains(delField);
	}
	
	public boolean remove (Label delLabel) {
		return labels.remove(delLabel);
	}
	
	
	public void remove (Dropdown delDropdown) {
		Iterator it = dropdowns.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry temp = (Map.Entry) it.next();
			if (temp.getValue().equals(delDropdown)) {
				it.remove();
			}
		}
	}
	
	
	////
	public boolean replace (Button targetButton, Button newButton) {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).equals(targetButton))
				buttons.set(i, newButton);
		}
		return buttons.contains(newButton);
	}
	
	public boolean replace (Field targetField, Field newField) {
		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).equals(targetField))
				fields.set(i, newField);
		}
		return fields.contains(newField);
	}
	
	public boolean replace (Label targetLabel, Label newLabel) {
		labels.remove(targetLabel);
		labels.add(newLabel);
		return labels.contains(newLabel);
	}
	
	public boolean replace(Dropdown targetDropdown, Dropdown newDropdown) {
		int key = 0;
        Iterator iterator = dropdowns.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry temp = (Map.Entry) iterator.next();
            if (temp.getValue().equals(targetDropdown)) {
                key = (int) temp.getKey();
                break;
            }
        }
        dropdowns.put(key, newDropdown);
        return dropdowns.containsValue(newDropdown);
	}
	
	////
	public void printButtons() {
		buttons.forEach(System.out::println);
		System.out.println();
	}
	
	public void printFields() {
		fields.forEach(System.out::println);
		System.out.println();
	}
	
	public void printLabels() {
		labels.forEach(System.out::println);
		System.out.println();
	}
	
	public void printDropdowns() {
        for (Object dropdown : dropdowns.entrySet()) {
            System.out.println(dropdown);
        }
        System.out.println(); 
    }
	
}
