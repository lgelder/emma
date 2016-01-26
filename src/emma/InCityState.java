package emma;

public class InCityState implements State{
	private Country country;
	private Place city;
	private String instructions;

	public InCityState(Country me, Place city){
		this.country = me;
		this.city = city;
		this.setInstructions("\nWelcome to " + this.city.getName() + ", " + this.country.getUserName() 
		+ "! Please select an estate to visit from the \nfollowing list:" + this.city.getUncompletedPrintPlaces());
	}
	
	@Override
	public void entersBack() {
		this.country.setState(this.country.inGame);
	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		Place estate = this.country.findEstate(text);
		if (!estate.getName().equals("null")){
			this.country.setState(new InEstateState(this.country, this.city, estate));
		} else {
			System.out.println(text + " is not an estate from the list. Please choose again.");
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
