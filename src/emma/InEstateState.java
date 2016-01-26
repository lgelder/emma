package emma;

public class InEstateState implements State {
	private Country country;
	private Place city;
	private Place estate;
	private String instructions;

	public InEstateState(Country me, Place city, Place estate){
		this.country = me;
		this.city = city;
		this.estate = estate;
		this.setInstructions("\nWelcome to " + this.estate.getName() + ", " + this.country.getUserName() 
		+ "! Please select a person to interact with from the \nfollowing list:" + this.estate.getUncompletedPrintPlaces());

	}
	
	@Override
	public void entersBack() {
		this.country.setState(new InCityState(this.country, this.city));
	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		Place person = this.country.findPerson(text);
		if (!person.getName().equals("null")){
			this.country.setState(new InPersonState(this.country, this.city, this.estate, person, 0));
		} else {
			System.out.println(text + " is not a person from the list. Please choose again.");
		}			
	}

	public Country getCountry() {
		return this.country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setPlace(Place place) {
		this.estate = place;
		
	}

	@Override
	public Place getPlace() {
		return this.estate;

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
