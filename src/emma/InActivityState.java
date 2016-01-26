package emma;

import java.util.List;

public class InActivityState implements State{
	private Country country;
	private Place person;
	private String instructions;
	private List<Activity> listOfAs;

	public InActivityState(Country me, Place person){
		this.country = me;
		this.person = person;
		for (Place a : person.getInsidePlaces()){
			Activity act = (Activity)a;
			listOfAs.add(act);
		}
		
	}
	

	@Override
	public void entersBack() {
		country.setState(new InPersonState(country, person));
	}

	@Override
	public void entersExit() {
		country.setState(country.gameOver);

	}
	@Override
	public void entersOther(String text) {
//		if (text.equals(activity.getAnswer())){
			
//		}
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


	
}
