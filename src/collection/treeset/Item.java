package collection.treeset;

import java.util.Objects;

public class Item implements Comparable<Item>{

	private String description;
	private int partNumber;
	
	public Item(String aDescription,int aPartNumber) {
		description = aDescription;
		partNumber = aPartNumber;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Item [description=" + description + ", partNumber=" + partNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		var other = (Item) obj;
		return Objects.equals(description, other.description) && partNumber == other.partNumber;
	}

	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(description,partNumber);
		
	}

	@Override
	public int compareTo(Item other) {
		int diff = Integer.compare(partNumber, other.partNumber);
		return diff != 0 ? diff : description.compareTo(other.description);
	}
	
	
}
