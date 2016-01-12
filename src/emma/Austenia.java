package emma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Austenia{
	
	public static List<TriviaQuestion> createTQs(){
		List<TriviaQuestion> list = new ArrayList<TriviaQuestion>();
		
		String[] question1choices = {"Mr. Perry", "Mr. Elton", "Mr. Knightley"};
		TriviaQuestion question1 = new TriviaQuestion("Mr. Woodhouse's Question", 
				"Answer the multiple choice question.", "What is the name of Mr. Woodhouse's doctor?", 
				"Mr. Perry", question1choices);
		
		list.add(question1);
		return list;
	}
	
	
	
	public static void main(String[] a){
		
		List<TriviaQuestion> listOfQuestions = Austenia.createTQs();
				
		Person mrWoodhouse = new Person("Mr. Woodhouse", listOfQuestions.get(0));
		
		Locale hartford = new Locale("Hartford");
//		hartford.addPerson(mrWoodhouse);
	
		System.out.println(mrWoodhouse.getTriviaQuestion().printQuestion());
		
		
	    Scanner readIn = new Scanner(System.in);
	    String userChoice = readIn.nextLine();
	    int userString = Integer.parseInt(userChoice);
	    readIn.close();            
	    System.out.println("You chose number " + userChoice + ", " + 
	    		mrWoodhouse.getTriviaQuestion().getChoices()[userString-1] + ".");
	    
	    if (mrWoodhouse.getTriviaQuestion().getAnswer() == mrWoodhouse.getTriviaQuestion().getChoices()[userString-1]){
	    	System.out.println("you are correct!");
	    }else{
	    	System.out.println("Oops, that's wrong.");
	    }
	    
//		System.out.println(mrWoodhouse.getTriviaQuestion().getTitle());
	}

//	public void paint(Graphics g) {
//	     Graphics2D g2 = (Graphics2D) g;
//	     g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//	     g2.setFont(new Font("Serif", Font.PLAIN, 32));
//	     paintHorizontallyCenteredText(g2, "Welcome to Austenia!", 600, 75);
//	     paintHorizontallyCenteredText(g2, "Please pick one of the following locations to select an activity:", 600, 175);
//	}
//	protected void paintHorizontallyCenteredText(Graphics2D g,
//		 String s, float centerX, float baselineY) {
//	     FontRenderContext frc = g.getFontRenderContext();
//	     Rectangle2D bounds = g.getFont().getStringBounds(s, frc);
//	     float width = (float) bounds.getWidth();
//	     g.drawString(s, centerX - width / 2, baselineY);
//	}
//
//	
//	public static void main(String[] a) {
//	    JFrame f = new JFrame("Austenia");
//	    f.setBackground(Color.pink);
//		JButton okButton = new JButton("OK");        
//		f.add(okButton);
//		
//	    f.addWindowListener(new WindowAdapter() {
//	    	public void windowClosing(WindowEvent e) {
//	    		System.exit(0);
//	    	}
//	    }
//	    );
//
//	    okButton.addActionListener(new ActionListener() {
//	       public void actionPerformed(ActionEvent e) {
//	       }          
//	    });
//	    
//	    f.setContentPane(new Austenia());
//	    f.setSize(1200,1000);
//	    f.setVisible(true);
}
