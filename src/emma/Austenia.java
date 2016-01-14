package emma;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Austenia{
	private List<City> cl;
	
	// Constructor. Add another file later
	public Austenia(String cityFile, String estateFile, String personFile, String activityFile1, 
			String activityFile2, String activityFile3){
		List<Activity> al = createActivities(activityFile1, activityFile2, activityFile3);
		List<Person> pl = createPeople(al, personFile);
		List<Estate> el = createEstates(pl, estateFile);
		cl = createCities(el, cityFile);
		
	}
	
	public static List<Activity> createActivities(String tqFile, String ctqFile, String usFile){
		Path TQFile = new File(tqFile).toPath();
		Path CTQFile = new File(ctqFile).toPath();
		Path USFile = new File(usFile).toPath();
		List<Activity> listOfActivities = new ArrayList<Activity>();
		try {
			Charset charset = Charset.forName("US-ASCII");
			// Read TriviaQuestions
            BufferedReader bufferedReader = Files.newBufferedReader(TQFile, charset);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
            	while((line = bufferedReader.readLine()) != "\n"){
            		String title = line;
            		String question = bufferedReader.readLine();
            		String answer = bufferedReader.readLine();
            		String line2;
            		List<String> choices = new ArrayList<String>();
            		String choice;
            		while((line2 = bufferedReader.readLine()) != null){
                		choice = bufferedReader.readLine();
                		choices.add(choice);
            		}
            		List<Option> lo = createOptions(choices);
            		Activity a = new TriviaQuestion(title, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }   
            bufferedReader.close();   
            
            // Read CompleteTheQuotes
            BufferedReader bufferedReader2 = Files.newBufferedReader(CTQFile, charset);
            String line3 = null;
            while((line3 = bufferedReader2.readLine()) != null) {
            	while((line3 = bufferedReader2.readLine()) != "\n"){
            		String title = line3;
            		String question = bufferedReader2.readLine();
            		String answer = bufferedReader2.readLine();
            		String line4;
            		List<String> choices = new ArrayList<String>();
            		String choice;
            		while((line4 = bufferedReader2.readLine()) != null){
                		choice = bufferedReader2.readLine();
                		choices.add(choice);
            		}
            		List<Option> lo = createOptions(choices);
            		Activity a = new CompleteTheQuote(title, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }
            bufferedReader2.close(); 
            
            // Read Unscrambles
            BufferedReader bufferedReader3 = Files.newBufferedReader(USFile, charset);
            String line5 = null;
            while((line5 = bufferedReader3.readLine()) != null) {
            	while((line5 != "\n")){
            		String title = line5;
            		String phrase = bufferedReader3.readLine();
            		String scrambled = bufferedReader3.readLine();
            		Activity a = new Unscramble(title, phrase, scrambled);
            		listOfActivities.add(a);
            	}
            }   

            bufferedReader3.close(); 
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		return listOfActivities;
	}
	
	public static List<Person> createPeople(List<Activity> actList, String file){
		List<Person> listOfPeople = new ArrayList<Person>();
		Path File = new File(file).toPath();
		try {
			Charset charset = Charset.forName("US-ASCII");
            BufferedReader bufferedReader = Files.newBufferedReader(File, charset);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
            	Person p = new Person(line);
            	listOfPeople.add(p);
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                File + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + File + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int a = 0; a < actList.size(); a++){
			for (int p = 0; p < listOfPeople.size(); p++){
				if (actList.get(a).getTitle() == listOfPeople.get(p).getName()){
					listOfPeople.get(p).addActivity(actList.get(a));
				}
			}
		}
		return listOfPeople;
	}	
	
	public static List<Estate> createEstates(List<Person> plist, String file){
		List<Estate> listOfEstates = new ArrayList<Estate>();
		Path File = new File(file).toPath();
		try {
			Charset charset = Charset.forName("US-ASCII");
            BufferedReader bufferedReader = Files.newBufferedReader(File, charset);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
            	Estate e = new Estate(line);
            	listOfEstates.add(e);
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                File + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + File + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int p = 0; p < plist.size(); p++){
			for (int e = 0; e < listOfEstates.size(); e++){
				if (plist.get(p).getName() == listOfEstates.get(e).getName()){
					listOfEstates.get(e).addPerson(plist.get(p));
				}
			}
		}
		return listOfEstates;
	}
	
	public static List<City> createCities(List<Estate> elist, String file){
		List<City> listOfCities = new ArrayList<City>();
		Path File = new File(file).toPath();
		try {
			Charset charset = Charset.forName("US-ASCII");
            BufferedReader bufferedReader = Files.newBufferedReader(File, charset);
            String line = null;
            while((line = bufferedReader.readLine()) != null) {
            	City c = new City(line);
            	listOfCities.add(c);
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                File + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + File + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int e = 0; e < elist.size(); e++){
			for (int c = 0; c < listOfCities.size(); c++){
				if (elist.get(e).getName() == listOfCities.get(c).getName()){
					listOfCities.get(c).addEstate(elist.get(e));
				}
			}
		}
		return listOfCities;
	}
	
	public static List<Option> createOptions(List<String> list){
		List<Option> questionchoices = new ArrayList<Option>();
		for (int i = 0; i < list.size(); i++) {
			questionchoices.add( new Option((i+1), list.get(i)));
		}
		return questionchoices;
	}
	
	public static List<Activity> createTQs(){
		List<Activity> listOfQuestions = new ArrayList<Activity>();
		
		List<String> listOfOptions0 = new ArrayList<String>();
		listOfOptions0.add("Mr. Perry");
		listOfOptions0.add("Mr. Elton");
		listOfOptions0.add("Mr. Knightley");

		List<Option> listOfOptions1 = createOptions(listOfOptions0);
		Activity question1 = new TriviaQuestion("Mr. Woodhouse's Question", 
			 "What is the name of my doctor?", 
				"Mr. Perry", listOfOptions1);
		listOfQuestions.add(question1);

		List<String> listOfOptions = new ArrayList<String>();
		listOfOptions.add("Elizabeth");
		listOfOptions.add("Augusta");
		listOfOptions.add("Jane");
		listOfOptions.add("Georgiana");
		
		List<Option> listOfOptions2 = createOptions(listOfOptions);
		Activity question2 = new TriviaQuestion("Mrs. Elton Question", 
				"What is my first name?", 
				"Augusta", listOfOptions2);
		listOfQuestions.add(question2);		
		
		List<String> listOfOptions3 = new ArrayList<String>();
		listOfOptions3.add("Frank Churchill");
		listOfOptions3.add("Mr. Elton");
		listOfOptions3.add("Mr. Knightley");

		List<Option> listOfOptions4 = createOptions(listOfOptions3);
		Activity question3 = new TriviaQuestion("Emma Woodhouse's Question", 
			 "Which man did I mistakenly think Harriet was in love with?", 
				"Frank Churchill", listOfOptions4);
		listOfQuestions.add(question3);
		
		return listOfQuestions;
	}
	
	public static Estate setUp(){
		List<Activity> listOfQuestions = Austenia.createTQs();
		
		Person mrWoodhouse = new Person("Mr. Woodhouse");
		mrWoodhouse.addActivity(listOfQuestions.get(0));
		
		Person mrsElton = new Person("Mrs. Elton");
		mrsElton.addActivity(listOfQuestions.get(1));
		Person emmaW = new Person("Emma Woodhouse");
		emmaW.addActivity(listOfQuestions.get(2));
		Estate hartfield = new Estate("Hartfield");
		hartfield.addPerson(mrWoodhouse);
//		hartfield.addPerson(mrsElton);
		hartfield.addPerson(emmaW);
		return hartfield;
	}
	
	public static void runEstate(Estate l){
		for (int i=0; i < 3; i++){
			System.out.println("Hello, my name is " + l.getPeople().get(i).getName() 
					+ ".\n" + l.getPeople().get(i).getActivity(0).getPrintQuestion());
			Scanner readIn = new Scanner(System.in);
		    String userChoice = readIn.nextLine();
//		    int userInt = Integer.parseInt(userChoice);
		    System.out.println("You chose " + userChoice + ".");
			boolean b = l.getPeople().get(i).getActivity(0).checkAnswer(userChoice);
			interpretAnswer(b);
		}
	}
	
	public static void main(String[] a){
		Austenia austen = new Austenia("Cities.txt", "Estates.txt", "People.txt", "C:\\Users\\Lia Gelder\\Documents\\GitHub\\emma\\src\\emma\\TriviaQuestions.txt", "CompleteTheQuote.txt", "Unscramble.txt");
		String welcome = "You have been transported through time to 18th century England, specifically the town of Highbury. "
				+ "\nIf you wish to return to your original time-period, type exit at any point, otherwise, select an estate number to get started: \n1. Hartfield";
		String thanksForPlaying = "Thank you for visiting Austenia. We hope you come back soon.";
		System.out.println(welcome);
		Scanner read = new Scanner(System.in);
		String selection = read.nextLine();
//		while (true){
//			selection = read.nextLine();
//			System.out.println(selection);
//			if (selection.toLowerCase() == "exit"){
//				break;
//			}
//			if (selection == "1" || selection.toLowerCase() == "hartfield"){
//				Locale hartfield = setUp();
//				System.out.println("Thanks for choosing Hartfield.");
//				runEstate(hartfield);
//			}
//		}
//		
		Estate hartfield = setUp();
		runEstate(hartfield);
		read.close();
		System.out.println(thanksForPlaying);
		
	}
//	public static boolean checkAnswer(Activity a){
//		Scanner readIn = new Scanner(System.in);
//	    String userChoice = readIn.nextLine();
////	    int userInt = Integer.parseInt(userChoice);
//	    System.out.println("You chose " + userChoice + ".");
//	    
//	    return a.checkAnswer(userChoice);
//	    
//	}
	public static void interpretAnswer(boolean b){
		if (b == true){
			System.out.println("Congratulations! You are correct!\n");
		}else{
			System.out.println("Sorry, that's incorrect.\n");
		}
		
	}
}
