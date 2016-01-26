package emma;

public class InActivityState implements State{
	private Country country;
	private Place activity;
	private String instructions;

	public InActivityState(Country me, Place activity){
		this.country = me;
		this.activity = activity;
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
//		if (text.equals(activity.getAnswer())){
			
//		}
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setPlace(Place place) {
		this.activity = place;
	}


	@Override
	public Place getPlace() {
		return this.activity;
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
