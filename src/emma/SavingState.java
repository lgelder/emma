package emma;

public class SavingState implements State {
	private Country country;
	private String instructions;
	
	public SavingState(Country me){
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public Object getPlace() {
		// TODO Auto-generated method stub
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
