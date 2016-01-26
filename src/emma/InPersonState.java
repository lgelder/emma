package emma;

public class InPersonState implements State {
	private Country country;
	private Place person;
	private String instructions;

	public InPersonState(Country me, Place person){
		this.country = me;
		this.person = person;
		this.setInstructions("Hello, " + country.getUserName() + "! Would you like to attempt an activity?");
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
			country.setState(new InActivityState(country, person));
		}else {
			System.out.println("Thank you for coming to visit me " + country.getUserName() + ". I hope you come again!");
		}
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
