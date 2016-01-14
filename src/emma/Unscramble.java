package emma;

public class Unscramble extends Activity implements ActivityInterface{
	private String phrase;
	private String scrambled;
	
	public Unscramble(String title, String phrase, String scrambled){
		this.title = title;
		this.instructions =  "Figure out to what phrase these letters can be rearranged:";
		this.phrase = phrase;
		this.scrambled = scrambled;
	}
	public String getAnswer(){
		return this.phrase;
	}
	public String getPrintQuestion(){
		return this.scrambled;
	}
	public Boolean checkAnswer(String answer){
		if (answer == this.phrase){
			return true;
		}
		return false;
	}

}
