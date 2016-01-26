package emma;


public class InActivityState implements State{
	private Country country;
	private Place person;
	private Activity activity;
	private String instructions;
	
	public InActivityState(Country me, Place person, Activity activity){
		this.country = me;
		this.person = person;
		this.activity = activity;
		this.setInstructions(this.activity.getPrintQuestion());

	}
	
	@Override
	public void entersBack() {
		this.country.setState(new InPersonState(this.country, this.person));
	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}
	@Override
	public void entersOther(String text){
		String selection = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		Boolean answer = this.activity.checkAnswer(selection);
		Country.interpretAnswer(answer);
		if (answer){
			this.country.setCorrect(this.country.getCorrect() + 1);
			this.activity.setCompleted(true);
		}
		this.country.setState(new InPersonState(this.country, this.person));
	}


	public Country getCountry() {
		return this.country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setPlace(Place place) {
		this.person = place;
	}


	@Override
	public Place getPlace() {
		return this.person;
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
