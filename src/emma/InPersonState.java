package emma;

import java.util.ArrayList;
import java.util.List;

public class InPersonState implements State {
	private Country country;
	private Place city;
	private Place estate;
	private Place person;
	private String instructions;
	private List<Activity> listOfAs;
	private int counter;
	
	public InPersonState(Country me, Place city, Place estate, Place person, int count){
		this.country = me;
		this.city = city;
		this.estate = estate;
		this.person = person;
		this.setCounter(count);

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
		this.country.setState(new InEstateState(this.country, this.city, this.estate));

	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		if (text.replaceAll("[^a-zA-Z ]", "").toLowerCase().startsWith("y")){
			this.country.setState(new InActivityState(this.country, this.city, this.estate, this.person, this.listOfAs.get(counter), this.counter));
		}else {
			System.out.println("Thank you for talking with me " + this.country.getUserName() + ". I hope you come again!");
			this.country.setState(new InEstateState(this.country, this.city, this.estate));
		}
		this.person.getInsidePlaces().get(this.counter).setCompleted(true);
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
