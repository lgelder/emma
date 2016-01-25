package emma;

public class GameOverState implements State {
	private Country country;
	private String instructions;
	
	public GameOverState(Country me){
		this.country = me;
	}

	@Override
	public void entersBack() {
		System.out.println("Can't go back from gameOver");
	}

	@Override
	public void entersExit() {
		System.out.println("Can't exit from gameOver");
	}
	@Override
	public void entersOther(String text) {
		System.out.println("Can't enter text from gameOver state");
	}
	
	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public void setPlace(String text) {
		System.out.println("gameOver can't have a place");
	}


	@Override
	public Object getPlace() {
		System.out.println("gameOver doesn't have a place");
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
