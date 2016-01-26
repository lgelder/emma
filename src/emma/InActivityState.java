package emma;


public class InActivityState implements State{
	private Country country;
	private Place city;
	private Place estate;
	private Place person;
	private Activity activity;
	private String instructions;
	private int counter;
	
	public InActivityState(Country me, Place city, Place estate, Place person, Activity activity, int counter){
		this.country = me;
		this.city = city;
		this.estate = estate;
		this.person = person;
		this.activity = activity;
		this.counter = counter;
		this.setInstructions(this.activity.getPrintQuestion());

	}
	
	@Override
	public void entersBack() {
		this.country.setState(new InPersonState(this.country, this.city, this.estate, this.person, this.counter));
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
		this.counter++;
		this.country.setState(new InPersonState(this.country, this.city, this.estate, this.person, this.counter));
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
