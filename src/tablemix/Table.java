package tablemix;

import java.util.HashSet;
import java.util.Set;

public class Table {

	String[] guests;
	
	public Table(String[] tableGuests) {
		guests = tableGuests;
	}

	public Set<String> getGuests() {
		HashSet<String> guestSet = new HashSet<String>();
		for(int i=0; i<guests.length; i++){
			guestSet.add(guests[i]);
		}
		return guestSet;
	}

}
