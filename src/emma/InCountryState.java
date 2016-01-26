package emma;

public class InCountryState implements State {
	private Country country;
	private String instructions;
	private int ccounter;


	public InCountryState(Country me, int ccounter){
		this.country = me;
		this.ccounter = ccounter;
		this.setInstructions(("\nPlease select a city to which to travel from the following list:" + this.country.getUncompletedPrintCities()));
	}

	@Override
	public void entersBack() {
		this.country.setState(this.country.gameOver);
	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);
	}

	@Override
	public void entersOther(String text) {
		Place city = this.country.findCity(text);
		if (!city.getName().equals("null")){
			this.country.setState(new InCityState(this.country, city, this.ccounter, 0));
		} else {
			System.out.println(text + " is not a city from the list. Please choose again.");
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
		System.out.println("can't assign a place to a country");
	}


	@Override
	public Place getPlace() {
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

	public int getCcounter() {
		return ccounter;
	}

	public void setCcounter(int ccounter) {
		this.ccounter = ccounter;
	}


}
