package emma;


public class InActivityState implements State{
	private Country country;
	private Place city;
	private Place estate;
	private Place person;
	private Activity activity;
	private String instructions;
	private int acounter;
	private int pcounter;
	private int ecounter;
	private int ccounter;
	
	public InActivityState(Country me, Place city, Place estate, Place person, Activity activity, 
			int ccounter, int ecounter, int pcounter, int acounter){
		this.country = me;
		this.city = city;
		this.estate = estate;
		this.person = person;
		this.activity = activity;
		this.acounter = acounter;
		this.pcounter = pcounter;
		this.ecounter = ecounter;
		this.ccounter = ccounter;
		this.setInstructions(this.activity.getPrintQuestion());

	}
	
	@Override
	public void entersBack() {
		this.country.setState(new InPersonState(this.country, this.city, this.estate, this.person, 
				this.ccounter, this.ecounter, this.pcounter, this.acounter));
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
		this.acounter++;
//		this.country.setState(new InPersonState(this.country, this.city, this.estate, this.person, 
//				this.ccounter, this.ecounter, this.pcounter, this.acounter));
		if (this.acounter == this.person.getInsidePlaces().size()){
			this.person.setCompleted(true);
			this.country.setState(new InEstateState(this.country, this.city, this.estate, this.ccounter, this.ecounter, this.pcounter));
//			if (this.pcounter == this.estate.getInsidePlaces().size()){
//				this.estate.setCompleted(true);
//				this.country.setState(new InCityState(this.country, this.city, this.ccounter, this.ecounter));
//				if (this.ecounter == this.city.getInsidePlaces().size()){
//					this.city.setCompleted(true);
//					this.country.setState(new InCountryState(this.country, this.ccounter));
//					if (this.ccounter == this.country.getCl().size()){
//						this.country.setCompleted(true);
//						this.country.setState(this.country.gameOver);
//					}
//				}
//			}
//			this.country.setState(new InEstateState(this.country, this.city, this.estate, this.ccounter, this.ecounter, this.pcounter));
		}else{
			this.country.setState(new InPersonState(this.country, this.city, this.estate, this.person, 
					this.ccounter, this.ecounter, this.pcounter, this.acounter));

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

	public int getCcounter() {
		return ccounter;
	}

	public void setCcounter(int ccounter) {
		this.ccounter = ccounter;
	}

	public int getEcounter() {
		return ecounter;
	}

	public void setEcounter(int ecounter) {
		this.ecounter = ecounter;
	}

	public int getPcounter() {
		return pcounter;
	}

	public void setPcounter(int pcounter) {
		this.pcounter = pcounter;
	}
	
	public void setAcounter(int acounter){
		this.acounter = acounter;
	}




	
}
