package emma;

public class InCityState implements State{
	private Country country;
	private Place city;
	private String instructions;

	public InCityState(Country me, Place city){
		this.country = me;
		this.city = city;
		this.setInstructions("\nWelcome to " +city.getName() + ", " + country.getUserName() + "! Please select an estate to visit from the \nfollowing list:" + city.getUncompletedPrintPlaces());
	}
	
	@Override
	public void entersBack() {
		country.setState(country.inGame);
	}

	@Override
	public void entersExit() {
		country.setState(country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		Place estate = country.findEstate(text);
		if (!estate.getName().equals("null")){
			country.setState(new InEstateState(country, estate));
		} else {
			System.out.println(text + " is not an estate from the list. Please choose again.");
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
		this.city = place;
	}


	@Override
	public Place getPlace() {
		return this.city;
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
