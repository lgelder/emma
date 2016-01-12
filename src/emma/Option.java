package emma;

public class Option {
	private int number;
	private String text;
	
	public Option(int number, String description){
		this.number = number;
		this.text = description;
	}
	
	public String printOption(){
		String phrase = "";
		phrase = (String.valueOf(number) + text);
		return phrase;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
