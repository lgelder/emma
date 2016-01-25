package emma;

public class InEstateState implements State {
	private Country country;
	private Estate estate;
	private String instructions;

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
		this.instructions = text;
		
	}


	@Override
	public Object getPlace() {
		return this.instructions;

	}


	@Override
	public void setInstructions(String text) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String getInstructions() {
		// TODO Auto-generated method stub
		return null;
	}


}
