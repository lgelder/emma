package emma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Austenia{
	private List<City> cl;
	
	// Constructor. Add another activity type and file later
	public Austenia(String cityFile, String estateFile, String personFile, String activityFile1, 
			String activityFile2, String activityFile3){
		System.out.print("Creating Activities...");
		List<Activity> al = createActivities(activityFile1, activityFile2, activityFile3);
		System.out.println("Created Activities");
		System.out.print("Creating People...");
		List<Person> pl = createPeople(al, personFile);
		System.out.println("Created People");
		System.out.print("Creating Estates...");
		List<Estate> el = createEstates(pl, estateFile);
		System.out.println("Created Estates");
		System.out.print("Creating Cities...");
		cl = createCities(el, cityFile);
		System.out.println("Created Cities");
		System.out.println("Setup complete. \n\n");
		
	}
	public static boolean isWhitespace(String str) {
	    if (str == null) {
	        return false;
	    }
	    int sz = str.length();
	    for (int i = 0; i < sz; i++) {
	        if ((Character.isWhitespace(str.charAt(i)) == false)) {
	            return false;
	        }
	    }
	    return true;
	}
	public static List<Activity> createActivities(String tqFile, String ctqFile, String usFile){
		List<Activity> listOfActivities = new ArrayList<Activity>();
		try {
			FileReader fileReader = new FileReader(tqFile);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
			// Read TriviaQuestions
            String line = bufferedReader.readLine();
            while(line != null) {
            	line = bufferedReader.readLine();
            	while(!isWhitespace(line) && line != null){
            		String title = line;
            		String question = bufferedReader.readLine();
            		String answer = bufferedReader.readLine();
            		List<String> choices = new ArrayList<String>();
            		String choice = bufferedReader.readLine();
            		while(!isWhitespace(choice) && choice != null){
                		choices.add(choice);
                		choice = bufferedReader.readLine();
            		}
            		line = choice;
            		List<Option> lo = createOptions(choices);
            		Activity a = new TriviaQuestion(title, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }   
    		System.out.print("added trivia questions...");
            bufferedReader.close();   
            
            // Read CompleteTheQuotes
//            BufferedReader bufferedReader2 = Files.newBufferedReader(CTQFile, charset);
			FileReader fileReader2 = new FileReader(ctqFile);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String line3 = bufferedReader2.readLine();
            while(line3 != null) {
                line3 = bufferedReader2.readLine();
            	while(!isWhitespace(line3) && line3 != null){
            		String title = line3;
            		String question = bufferedReader2.readLine();
            		String answer = bufferedReader2.readLine();
            		List<String> choices = new ArrayList<String>();
            		String choice = bufferedReader2.readLine();
            		while(!isWhitespace(choice) && choice != null){
                		choices.add(choice);
                		choice = bufferedReader2.readLine();
            		}
            		line3 = choice;
            		List<Option> lo = createOptions(choices);
            		Activity a = new CompleteTheQuote(title, question, answer, lo);
            		listOfActivities.add(a);
            	}
            }
    		System.out.print("added complete the quotes...");
            bufferedReader2.close(); 

            // Read Unscrambles
//            BufferedReader bufferedReader3 = Files.newBufferedReader(USFile, charset);
			FileReader fileReader3 = new FileReader(usFile);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
            String line5 = null;
            line5 = bufferedReader3.readLine();
            while(line5 != null) {
            	line5 = bufferedReader3.readLine();
            	while(!isWhitespace(line5) && line5 != null){
            		String title = line5;
            		String phrase = bufferedReader3.readLine();
            		String scrambled = bufferedReader3.readLine();
            		Activity a = new Unscramble(title, phrase, scrambled);
            		listOfActivities.add(a);
            		line5 = bufferedReader3.readLine();
            	}
            }   
    		System.out.print("added unscrambles...");
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
		// Test that activities were created correctly
//		for (int i = 0; i < listOfActivities.size(); i++){
//			System.out.println(listOfActivities.get(i).getPrintQuestion());
//		}
		return listOfActivities;
	}
	
	public static List<Person> createPeople(List<Activity> actList, String file){
		List<Person> listOfPeople = new ArrayList<Person>();
		try {
			FileReader fileReader = new FileReader(file);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String line5 = null;
	        line5 = bufferedReader.readLine();
	        while(line5 != null) {
	        	line5 = bufferedReader.readLine();
	        	while(!isWhitespace(line5) && line5 != null){
	        		String name = line5;
	        		String estate = bufferedReader.readLine();
	        		Person p = new Person(name, estate);
	        		listOfPeople.add(p);
	        		line5 = bufferedReader.readLine();
	        	}
	        }   
	        System.out.print("created people...");
	        bufferedReader.close(); }

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int a = 0; a < actList.size(); a++){
			for (int p = 0; p < listOfPeople.size(); p++){
				if (actList.get(a).getPerson().equals(listOfPeople.get(p).getName())){
					listOfPeople.get(p).addActivity(actList.get(a));
//					System.out.println("added " + actList.get(a).getAnswer() + " to " + listOfPeople.get(p).getName());
				}
			}
		}
		System.out.print("added activities to people...");
		return listOfPeople;
	}	

	public static List<Estate> createEstates(List<Person> plist, String file){
		List<Estate> listOfEstates = new ArrayList<Estate>();
		try {
			FileReader fileReader = new FileReader(file);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String line5 = null;
	        line5 = bufferedReader.readLine();
	        while(line5 != null) {
	        	line5 = bufferedReader.readLine();
	        	while(!isWhitespace(line5) && line5 != null){
	        		String name = line5;
	        		String city = bufferedReader.readLine();
	        		Estate e = new Estate(name, city);
	        		listOfEstates.add(e);
	        		line5 = bufferedReader.readLine();
	        	}
	        }   
	        System.out.print("created estates...");
	        bufferedReader.close(); }

        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int p = 0; p < plist.size(); p++){
			for (int e = 0; e < listOfEstates.size(); e++){
				if (plist.get(p).getEstate().equals(listOfEstates.get(e).getName())){
					listOfEstates.get(e).addPerson(plist.get(p));
//					System.out.println("added " + plist.get(p).getName() + " to " + listOfEstates.get(e).getName());

				}
			}
		}
		System.out.print("added people to estates...");
		return listOfEstates;
	}
	
	public static List<City> createCities(List<Estate> elist, String file){
		List<City> listOfCities = new ArrayList<City>();
		try {
			FileReader fileReader = new FileReader(file);
	        // wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String line5 = null;
	        line5 = bufferedReader.readLine();
	        while(line5 != null) {
	        	line5 = bufferedReader.readLine();
	        	while(!isWhitespace(line5) && line5 != null){
	        		String name = line5;
	        		City c = new City(name);
	        		listOfCities.add(c);
	        		line5 = bufferedReader.readLine();
	        	}
	        }   
	        System.out.print("created cities...");

	        bufferedReader.close(); }
		
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
            // Or we could just do this: 
//             ex.printStackTrace();
        }
		for (int e = 0; e < elist.size(); e++){
			for (int c = 0; c < listOfCities.size(); c++){
				if (elist.get(e).getCity().equals(listOfCities.get(c).getName())){
					listOfCities.get(c).addEstate(elist.get(e));
//					System.out.println("added " + elist.get(e).getName() + " to " + listOfCities.get(c).getName());

				}
			}
		}
		System.out.print("added estates to cities...");
		return listOfCities;
	}
	
	public static List<Option> createOptions(List<String> list){
		List<Option> questionchoices = new ArrayList<Option>();
		for (int i = 0; i < list.size(); i++) {
			questionchoices.add( new Option((i+1), list.get(i)));
		}
		return questionchoices;
	}

	public void run(){
		Scanner read = new Scanner(System.in);
		String selection = "";
		while (!selection.equals("exit")){
			System.out.println("Please select a city:");
			for (int i = 0; i < cl.size(); i++){
				if (!cl.get(i).getCompleted()){
					System.out.println(cl.get(i).getName());
				}
			}
			selection = read.nextLine();
			if (selection.equals("exit")){
				break;
			}
			String city = selection.toLowerCase();
			int cindex = findCity(city);
		    while (!cl.get(cindex).getCompleted() && !selection.equals("exit")){
				System.out.println("Please select an estate:");
				for (int i = 0; i < cl.get(cindex).getEstates().size(); i++){
					System.out.println(cl.get(cindex).getEstates().get(i).getName());
				}
				selection = read.nextLine();
				if (selection.equals("exit")){
					break;
				}
				String estate = selection.toLowerCase();
				int eindex = findEstate(cindex, estate);
				while (!cl.get(cindex).getEstates().get(eindex).getCompleted() && !selection.equals("exit")){
					System.out.println("Please select a person:");
					for (int i = 0; i < cl.get(cindex).getEstates().get(eindex).getPeople().size(); i++){
						System.out.println(cl.get(cindex).getEstates().get(eindex).getPeople().get(i).getName());
					}
					selection = read.nextLine();
					if (selection.equals("exit")){
						break;
					}
					String person = selection.toLowerCase();
					int pindex = findPerson(cindex, eindex, person);
					while (!cl.get(cindex).getEstates().get(eindex).getPeople().get(pindex).getCompleted() && !selection.equals("exit")){
						for (int i = 0; i < cl.get(cindex).getEstates().get(eindex).getPeople().get(pindex).getActivities().size(); i++){
							System.out.println(cl.get(cindex).getEstates().get(eindex).getPeople().get(pindex).getActivity(i).getPrintQuestion());
							selection = read.nextLine().toLowerCase();
							Boolean answer = cl.get(cindex).getEstates().get(eindex).getPeople().get(pindex).getActivity(i).checkAnswer(selection);
							interpretAnswer(answer);
						}
						cl.get(cindex).getEstates().get(eindex).getPeople().get(pindex).setCompleted(true);
						System.out.println("Congratulations! You have completed all of the activities this person asked of you!");
					}
					int counter = 0;
					for (Person p : cl.get(cindex).getEstates().get(eindex).getPeople()){
						if (p.getCompleted() == true){
							counter++;
						}
					}
					if (counter == cl.get(cindex).getEstates().get(eindex).getPeople().size()){
						cl.get(cindex).getEstates().get(eindex).setCompleted(true);
						System.out.println("Congratulations! You have completed all of the activities at this estate!");
					}
				}
				int counter = 0;
				for (Estate e : cl.get(cindex).getEstates()){
					if (e.getCompleted() == true){
						counter++;
					}
				}
				if (counter == cl.get(cindex).getEstates().size()){
					cl.get(cindex).setCompleted(true);
					System.out.println("Congratulations! You have completed all of the activities in this city!");

				}
			}
		}		
		read.close();
	}
	
	public int findCity(String city){
		for (int i = 0; i < cl.size(); i++){
	        if((cl.get(i).getCompleted().equals(false)) && (cl.get(i).getName()).toLowerCase().equals(city)){  
	        	return i;
	        }
		}
		return -1;
	}
	public int findEstate(int cityindex, String estate){
		for (int i = 0; i < cl.get(cityindex).getEstates().size(); i++){
	        if((cl.get(cityindex).getEstates().get(i).getCompleted().equals(false)) && (cl.get(cityindex).getEstates().get(i).getName()).toLowerCase().equals(estate)){  
	        	return i;
	        }
		}
		return -1;
	}
	public int findPerson(int cityindex, int estateindex, String person){
		for (int i = 0; i < cl.get(cityindex).getEstates().get(estateindex).getPeople().size(); i++){
	        if((cl.get(cityindex).getEstates().get(estateindex).getPeople().get(i).getCompleted().equals(false)) 
	        		&& (cl.get(cityindex).getEstates().get(estateindex).getPeople().get(i).getName()).toLowerCase().equals(person)){  
	        	return i;
	        }
		}
		return -1;
	}
	
	public static void main(String[] a){
		Austenia austen = new Austenia(
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Cities.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Estates.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\People.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\TriviaQuestions.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\CompleteTheQuote.txt", 
				"C:\\Users\\Lia Gelder\\Documents\\GitHub\\Emma\\src\\emma\\Unscramble.txt");
		
		String welcome = "You have been transported through time to 18th century England." 
		+ "\nIf you wish to return to your original time-period, type exit at any point.";
		System.out.println(welcome);
		
		austen.run();
		
		String thanksForPlaying = "Thank you for visiting Austenia. We hope you come back soon.";
		System.out.println(thanksForPlaying);
		
	}

	public static void interpretAnswer(boolean b){
		if (b == true){
			System.out.println("Congratulations! You are correct!\n");
		}else{
			System.out.println("Sorry, that's incorrect.\n");
		}
		
	}
//	public static boolean checkAnswer(Activity a){
//	Scanner readIn = new Scanner(System.in);
//    String userChoice = readIn.nextLine();
////    int userInt = Integer.parseInt(userChoice);
//    System.out.println("You chose " + userChoice + ".");
//    
//    return a.checkAnswer(userChoice);
//    
//}
//	
//	public static Estate setUp(){
//		List<Activity> listOfQuestions = Austenia.createTQs();
//		
//		Person mrWoodhouse = new Person("Mr. Woodhouse");
//		mrWoodhouse.addActivity(listOfQuestions.get(0));
//		
//		Person mrsElton = new Person("Mrs. Elton");
//		mrsElton.addActivity(listOfQuestions.get(1));
//		Person emmaW = new Person("Emma Woodhouse");
//		emmaW.addActivity(listOfQuestions.get(2));
//		Estate hartfield = new Estate("Hartfield");
//		hartfield.addPerson(mrWoodhouse);
////		hartfield.addPerson(mrsElton);
//		hartfield.addPerson(emmaW);
//		return hartfield;
//	}
//	
//	public static void runEstate(Estate l){
//		for (int i=0; i < 3; i++){
//			System.out.println("Hello, my name is " + l.getPeople().get(i).getName() 
//					+ ".\n" + l.getPeople().get(i).getActivity(0).getPrintQuestion());
//			Scanner readIn = new Scanner(System.in);
//		    String userChoice = readIn.nextLine();
////		    int userInt = Integer.parseInt(userChoice);
//		    System.out.println("You chose " + userChoice + ".");
//			boolean b = l.getPeople().get(i).getActivity(0).checkAnswer(userChoice);
//			interpretAnswer(b);
//			readIn.close();
//		}
//	}
//	
//	
//	while (true){
//	selection = read.nextLine();
//	System.out.println(selection);
//	if (selection.toLowerCase() == "exit"){
//		break;
//	}
//	if (selection == "1" || selection.toLowerCase() == "hartfield"){
//		Locale hartfield = setUp();
//		System.out.println("Thanks for choosing Hartfield.");
//		runEstate(hartfield);
//	}
//}
//
//	public static List<Activity> createTQs(){
//		List<Activity> listOfQuestions = new ArrayList<Activity>();
//		
//		List<String> listOfOptions0 = new ArrayList<String>();
//		listOfOptions0.add("Mr. Perry");
//		listOfOptions0.add("Mr. Elton");
//		listOfOptions0.add("Mr. Knightley");
//
//		List<Option> listOfOptions1 = createOptions(listOfOptions0);
//		Activity question1 = new TriviaQuestion("Mr. Woodhouse's Question", 
//			 "What is the name of my doctor?", 
//				"Mr. Perry", listOfOptions1);
//		listOfQuestions.add(question1);
//
//		List<String> listOfOptions = new ArrayList<String>();
//		listOfOptions.add("Elizabeth");
//		listOfOptions.add("Augusta");
//		listOfOptions.add("Jane");
//		listOfOptions.add("Georgiana");
//		
//		List<Option> listOfOptions2 = createOptions(listOfOptions);
//		Activity question2 = new TriviaQuestion("Mrs. Elton Question", 
//				"What is my first name?", 
//				"Augusta", listOfOptions2);
//		listOfQuestions.add(question2);		
//		
//		List<String> listOfOptions3 = new ArrayList<String>();
//		listOfOptions3.add("Frank Churchill");
//		listOfOptions3.add("Mr. Elton");
//		listOfOptions3.add("Mr. Knightley");
//
//		List<Option> listOfOptions4 = createOptions(listOfOptions3);
//		Activity question3 = new TriviaQuestion("Emma Woodhouse's Question", 
//			 "Which man did I mistakenly think Harriet was in love with?", 
//				"Frank Churchill", listOfOptions4);
//		listOfQuestions.add(question3);
//		
//		return listOfQuestions;
//	}

}
