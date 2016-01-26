package emma;

public class InCityState implements State{
	private Country country;
	private Place city;
	private String instructions;
	private int pcounter;
	private int ecounter;
	private int ccounter;

	public InCityState(Country me, Place city, int ccounter, int ecounter){
		this.country = me;
		this.city = city;
		this.ecounter = ecounter;
		this.ccounter = ccounter;
		this.setInstructions("\nWelcome to " + this.city.getName() + ", " + this.country.getUserName() 
		+ "! Please select an estate to visit from the \nfollowing list:" + this.city.getUncompletedPrintPlaces());
	}
	
	@Override
	public void entersBack() {
		this.country.setState(this.country.inGame);
	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		Place estate = this.country.findEstate(text);
		if (!estate.getName().equals("null")){
			this.country.setState(new InEstateState(this.country, this.city, estate, this.ccounter, this.ecounter, 0));
		} else {
			System.out.println(text + " is not an estate from the list. Please choose again.");
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
		this.city = place;
	}


	@Override
	public Place getPlace() {
		return this.city;
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
	

}
