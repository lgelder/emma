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

		this.setInstructions("Hello, " + this.country.getUserName() + "! Would you like to attempt an activity?");
		this.listOfAs = new ArrayList<Activity>();
		for (Place a : this.person.getInsidePlaces()){
			ActivityAdapter aa= (ActivityAdapter)a;
			Activity act = (Activity)aa;
			this.listOfAs.add(act);
		}
	}
	

	@Override
	public void entersBack() {
		this.country.setState(new InEstateState(this.country, this.person.getContainerPlace()));

	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		if (text.startsWith("y")){
			this.country.setState(new InActivityState(this.country, this.person, this.listOfAs.get(counter)));
		}else {
			System.out.println("Thank you for talking with me " + this.country.getUserName() + ". I hope you come again!");
			this.country.setState(new InEstateState(this.country, this.person.getContainerPlace()));
		}
		this.listOfAs.get(this.counter).setCompleted(true);
		this.counter++;
	}

	public Country getCountry() {
		return this.country;
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
