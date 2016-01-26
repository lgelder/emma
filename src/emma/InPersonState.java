package emma;

import java.util.ArrayList;
import java.util.List;

public class InPersonState implements State {
	private Country country;
	private Place person;
	private String instructions;
	private List<Activity> listOfAs;
	private int counter;
	
	public InPersonState(Country me, Place person){
		this.country = me;
		this.person = person;
		this.setCounter(0);

		this.setInstructions("Hello, " + country.getUserName() + "! Would you like to attempt an activity?");
		listOfAs = new ArrayList<Activity>();
		for (Place a : person.getInsidePlaces()){
			ActivityAdapter aa= (ActivityAdapter)a;
			Activity act = (Activity)aa;
			listOfAs.add(act);
		}
	}
	

	@Override
	public void entersBack() {
		country.setState(new InEstateState(country, this.person.getContainerPlace()));

	}

	@Override
	public void entersExit() {
		country.setState(country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		if (text.startsWith("y")){
			country.setState(new InActivityState(country, person, listOfAs.get(counter)));
		}else {
			System.out.println("Thank you for coming to visit me " + country.getUserName() + ". I hope you come again!");
			country.setState(new InEstateState(country, person.getContainerPlace()));
		}
		counter++;
	}

	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setPlace(Place place) {
		this.person = place;
	}


	@Override
	public Place getPlace() {
		return this.person;
	}


	@Override
	public void setInstructions(String text) {
		this.instructions = text;
		
	}


	@Override
	public String getInstructions() {
		return this.instructions;

	}
	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


}
