package emma;

import java.util.ArrayList;
import java.util.List;

public class InPersonState implements State {
	private Country country;
	private Place city;
	private Place estate;
	private Place person;
	private String instructions;
	private List<Activity> listOfAs;
	private int acounter;
	private int pcounter;
	private int ecounter;
	private int ccounter;
	
	public InPersonState(Country me, Place city, Place estate, Place person, int ccounter, int ecounter, int pcounter, int acounter){
		this.country = me;
		this.city = city;
		this.estate = estate;
		this.person = person;
		this.acounter = acounter;
		this.pcounter = pcounter;
		this.ecounter = ecounter;
		this.ccounter = ccounter;
		if (this.acounter == this.person.getInsidePlaces().size()){
			this.person.setCompleted(true);
			this.country.setState(new InEstateState(this.country, this.city, this.estate, this.ccounter, this.ecounter, this.pcounter));
		}
		this.setInstructions("Hello, " + this.country.getUserName() + "! Would you like to attempt an activity?");
		this.listOfAs = new ArrayList<Activity>();
		for (Place a : this.person.getInsidePlaces()){
			ActivityAdapter aa= (ActivityAdapter)a;
			Activity act = (Activity)aa;
			this.listOfAs.add(act);
		}
	}
	

	@Override
	public void entersBack() {
		this.country.setState(new InEstateState(this.country, this.city, this.estate, this.ccounter, this.ecounter, this.pcounter));

	}

	@Override
	public void entersExit() {
		this.country.setState(this.country.gameOver);

	}

	@Override
	public void entersOther(String text) {
		if (text.replaceAll("[^a-zA-Z ]", "").toLowerCase().startsWith("y")){
			this.country.setState(new InActivityState(this.country, this.city, this.estate, this.person, this.listOfAs.get(acounter),
					this.ccounter, this.ecounter, this.pcounter, this.acounter));
		}else {
			System.out.println("Thank you for talking with me " + this.country.getUserName() + ". I hope you come again!");
			this.country.setState(new InEstateState(this.country, this.city, this.estate, this.ccounter, this.ecounter, this.pcounter));
		}
		this.person.getInsidePlaces().get(this.acounter).setCompleted(true);
		this.pcounter++;
		
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
