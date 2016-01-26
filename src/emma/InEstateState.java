package emma;

public class InEstateState implements State {
	private Country country;
	private Place estate;
	private String instructions;

	public InEstateState(Country me, Place estate){
		this.country = me;
		this.estate = estate;
		this.setInstructions("\nWelcome to " +estate.getName() + ", " + country.getUserName() + "! Please select a person to interact with from the \nfollowing list:" + estate.getUncompletedPrintPlaces());

	}
	
	@Override
	public void entersBack() {
		country.setState(new InCityState(country, this.estate.getContainerPlace()));
	}

	@Override
	public void entersExit() {
		country.setState(country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		Place person = country.findPerson(text);
		if (!person.getName().equals("null")){
			country.setState(new InPersonState(country, person));
		} else {
			System.out.println(text + " is not a person from the list. Please choose again.");
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
