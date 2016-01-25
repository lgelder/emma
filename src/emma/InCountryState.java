package emma;

public class InCountryState implements State {
	private Country country;
	private String instructions = ("\nPlease select a city to which to travel from the following list:" + country.getUncompletedPrintCities());


	public InCountryState(Country me){
		this.country = me;
	}

	@Override
	public void entersBack() {
		country.setState(country.gameOver);
	}

	@Override
	public void entersExit() {
		country.setState(country.gameOver);
	}

	@Override
	public void entersOther(String text) {
		country.setState(new InCityState(country));
		country.state.setPlace(text);
	}
	
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	@Override
	public void setPlace(String text) {
		System.out.println("can't assign a place to a country");
	}


	@Override
	public Object getPlace() {
		System.out.println("a country doesn't have a place");
		return null;
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
