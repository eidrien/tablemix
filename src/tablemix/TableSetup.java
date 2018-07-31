package tablemix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TableSetup {

	Set<Table> tables;
	
	
	public TableSetup(){
		tables = new HashSet<Table>();
	}
	
	public void addTable(String[] tableGuests){
		tables.add(new Table(tableGuests));
	}

	public ArrayList<Table> getTables() {
		return new ArrayList<Table>(tables);
	}
}
