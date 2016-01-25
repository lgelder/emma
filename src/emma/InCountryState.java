package emma;

public class InCountryState implements State {
	private Country country;
	
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
		country.inCity.setPlace(text);
		country.setState(country.inCity);
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



}
