package emma;

public class InCityState implements State{
	private Country country;
	
	public InCityState(Country me){
		this.country = me;
	}
	

	@Override
	public void entersBack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void entersExit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void entersAnswer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entersPlace() {
		// TODO Auto-generated method stub
		
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

}
