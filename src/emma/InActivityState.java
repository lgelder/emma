package emma;

import java.util.ArrayList;
import java.util.List;

public class InActivityState implements State{
	private Country country;
	private Place person;
	private Activity activity;
	private String instructions;
	
	public InActivityState(Country me, Place person, Activity activity){
		this.country = me;
		this.person = person;
		this.activity = activity;
		this.setInstructions(activity.getPrintQuestion());

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
//		Activity a = listOfAs.get(counter);
//		if (!a.getCompleted()){
//			System.out.println(a.getPrintQuestion());
//		}
		String selection = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		Boolean answer = this.activity.checkAnswer(selection);
		Country.interpretAnswer(answer);
		if (answer){
			country.setCorrect(country.getCorrect() + 1);
		}
		country.setState(new InPersonState(country, person));
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
