package tablemix;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SeatingFitnessTest {
	

	String[] people = {"Adrian", "Borja", "Carlota", "Daniel", "Elisabet", "Francisco", "Georgina"};
	SeatingHistory seatingHistory;

	
	@Before
	public void setUp() throws Exception {
		seatingHistory = new SeatingHistory(people);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenNoMealsHaveBeenMadeFitnessIsZero() {
		assertEquals(0, seatingHistory.getNumberOfLinks());
		
	}

	@Test
	public void whenOnePersonEatsAloneTheFitnessIsIncreasedByOne() {
		String[] peopleInTable = {"Adrian"};
		TableSetup tableSetup = new TableSetup();
		tableSetup.addTable(peopleInTable);
		seatingHistory.addMeal(tableSetup);
		assertEquals(1, seatingHistory.getNumberOfLinks());
		
	}

	
	@Test
	public void whenOnePersonEatsWithANewOneTheFitnessIsIncreasedByFour() {
		String[] peopleInTable = {"Adrian","Borja"};
		TableSetup tableSetup = new TableSetup();
		tableSetup.addTable(peopleInTable);
		seatingHistory.addMeal(tableSetup);
		assertEquals(4, seatingHistory.getNumberOfLinks());
		
	}
	
	@Test
	public void whenPeopleEatWithSamePeopleFitnessDoesntIncrease() {
		String[] peopleInTable = {"Adrian","Borja"};
		TableSetup tableSetup = new TableSetup();
		tableSetup.addTable(peopleInTable);
		seatingHistory.addMeal(tableSetup);
		assertEquals(4, seatingHistory.getNumberOfLinks());
		seatingHistory.addMeal(tableSetup);
		assertEquals(4, seatingHistory.getNumberOfLinks());
	}

	@Test
	public void linksAreCalculatedWhenTwoTablesExist(){
		String[] peopleInTable1 = {"Adrian","Borja"};
		String[] peopleInTable2 = {"Carlota","Daniel"};
		TableSetup tableSetup = new TableSetup();
		tableSetup.addTable(peopleInTable1);
		tableSetup.addTable(peopleInTable2);
		seatingHistory.addMeal(tableSetup);
		assertEquals(8, seatingHistory.getNumberOfLinks());
	}
}
