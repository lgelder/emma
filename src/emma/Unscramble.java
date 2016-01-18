package emma;

public class Unscramble extends Activity implements ActivityInterface{
	private String phrase;
	private String scrambled;
	
	public Unscramble(String person, String phrase, String scrambled){
		this.person = person;
		this.instructions =  "Figure out to what phrase these letters can be rearranged:";
		this.completed = false;
		this.phrase = phrase;
		this.scrambled = scrambled;
	}
	public String getAnswer(){
		return this.phrase;
	}
	public String getPrintQuestion(){
		return this.scrambled;
	}
	public Boolean checkAnswer(String a){
		a = a.toLowerCase();
		if (a == this.phrase){
			this.completed = true;
			return true;
		}
		return false;
	}

}
