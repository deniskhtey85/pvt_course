package core;

import java.util.List;

public class Dropdown implements Comparable<Dropdown> {
	
	List<String> options;
    boolean isSelected;
    String name;
    
    public Dropdown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "";
    }
    
    @Override
    public int compareTo(Dropdown obj) {
    Dropdown objectToCompare = obj;
    int result = name.compareTo(objectToCompare.name);
    return result;
}

}
