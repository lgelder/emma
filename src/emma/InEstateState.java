package emma;

public class InEstateState implements State {
	private Country country;
	private Estate estate;
	
	public InEstateState(Country me){
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


	public Estate getEstate() {
		return estate;
	}


	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	@Override
	public void setPlace(String text) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object getPlace() {
		// TODO Auto-generated method stub
		return null;
	}


}
