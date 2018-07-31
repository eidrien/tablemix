package tablemix;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatingHistory {

	private String[] people;
	private Map<String, Set<String>> links;
	
	public SeatingHistory(String[] people) {
		this.people = people;
		links = new HashMap<String, Set<String>>();
		for(String person: people){
			links.put(person, new HashSet<String>());
		}
	}

	public int getNumberOfLinks() {
		int numberOfLinks = 0;
		for(int i=0 ; i<people.length; i++){
			numberOfLinks += links.get(people[i]).size();
		}
		return numberOfLinks;
	}

	public void addMeal(TableSetup tableSetup) {
		for(Table table : tableSetup.getTables()){
			addNewEatingLinks(table);
		}
	}

	private void addNewEatingLinks(Table table) {
		for(String person : table.getGuests()){
			addPersonalLinks(person, table.getGuests());
		}
	}

	private void addPersonalLinks(String person, Set<String> guests) {
		Set<String> currentLinks = links.get(person);
		currentLinks.addAll(guests);
	}

}
