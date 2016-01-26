package emma;

public class InEstateState implements State {
	private Country country;
	private Place estate;
	private String instructions;

	public InEstateState(Country me){
		this.country = me;
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
		// TODO Auto-generated method stub
		
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
