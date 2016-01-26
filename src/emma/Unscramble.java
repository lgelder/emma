package emma;

public class Unscramble extends Activity implements ActivityInterface{
	private String phrase;
	private String scrambled;
	
	public Unscramble(Place person, String phrase, String scrambled){
		this.person = person;
		this.instructions =  "Figure out to what phrase these letters can be rearranged: \n";
		this.completed = false;
		this.phrase = phrase;
		this.scrambled = scrambled;
	}
	public String getAnswer(){
		return this.phrase;
	}
	public String getPrintQuestion(){
		return this.instructions + this.scrambled;
	}
	public Boolean checkAnswer(String a){
		if (a.equals(getAnswer().replaceAll("[^a-zA-Z ]", "").toLowerCase())){
			this.completed = true;
			return true;
		}
		return false;
	}

}
