package emma;

public class InCityState implements State{
	private Country country;
	private String city;
	
	public InCityState(Country me){
		this.country = me;
	}
	

	@Override
	public void entersBack() {
		// TODO Auto-generated method stub

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
	public void setPlace(String text) {
		this.city = text;
	}


	@Override
	public Object getPlace() {
		return this.city;
	}



}
