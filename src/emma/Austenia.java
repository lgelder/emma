package emma;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Austenia{
	private List<City> cl;
	private Boolean completed;
	private int correct;
	
	// Constructor. Add another activity type and file later
	public Austenia(String cityFile, String estateFile, String personFile, String activityFile1, 
			String activityFile2, String activityFile3){
		System.out.println("Setting up the game.");
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
		this.completed = false;
		
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

//	public City userInputCity(Scanner read){
//		System.out.println("Please select a city:");
//		for (City c : cl){
//			if (!c.getCompleted()){
//				System.out.println(c.getName());
//			}
//		}
//		String selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase(); //found this function on StackOverflow: 
//		if (selection.equals("back")){		//http://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
//			return new City("empty");
//		}
//		int cindex = findCity(selection);
//		if (cindex == -1){
//			break;
//		}
//		
//		
//		return city;
//	}
	
	public void run(){
		Scanner read = new Scanner(System.in);
		String selection = "";
		while (!getCompleted() && !selection.equals("exit")){
//			userInputCity(read);
			System.out.println("Please select a city to which to travel from the following list:");
			for (City c : cl){
				if (!c.getCompleted()){
					System.out.println(c.getName());
				}
			}
			selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase(); //found this function on StackOverflow: 
			if (selection.equals("back")){		//http://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
				break;
			}
			City city = findCity(selection);
		    while (!city.getName().equals("null") && !city.getCompleted() && !selection.equals("exit")){
				System.out.println("Please select an estate to visit from the following list:");
				for (Estate e : city.getEstates()){
					if (!e.getCompleted()) {
						System.out.println(e.getName());
					}
				}
				selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
				if (selection.equals("back")){
					break;
				}
				Estate estate = findEstate(city, selection);
				while (!estate.getName().equals("null") && !estate.getCompleted() && !selection.equals("exit")){
					System.out.println("Please select a person with whom you would like to converse from the following list:");
					for (Person p : estate.getPeople()){
						if (!p.getCompleted()) {
							System.out.println(p.getName());
						}
					}
					selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
					if (selection.equals("back")){
						break;
					}
					Person person = findPerson(estate, selection);
					while (!person.getName().equals("null") && !person.getCompleted() && !selection.equals("exit")){
						for (Activity a: person.getActivities()){
							if (!a.getCompleted()){
								System.out.println(a.getPrintQuestion());

							}
							selection = read.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
							if (selection.equals("exit")){
								break;
							}
							Boolean answer = a.checkAnswer(selection);
							interpretAnswer(answer);
							if (answer){
								this.correct++;
							}
						}
						int counter = 0;
						for (Activity a : person.getActivities()){
							if (a.getCompleted() == true){
								counter++;
							}
						}
						if (counter == person.getActivities().size()){
							person.setCompleted(true);
							System.out.println("Congratulations! \nYou have completed all of the activities " 
							+ person.getName() + " asked of you!\n");
						}
					}
					int counter = 0;
					for (Person p : estate.getPeople()){
						if (p.getCompleted() == true){
							counter++;
						}
					}
					if (counter == estate.getPeople().size()){
						estate.setCompleted(true);
						System.out.println("Congratulations! \nYou have completed all of the activities at " 
								+ estate.getName() + "!\n");
					}
				}
				int counter = 0;
				for (Estate e : city.getEstates()){
					if (e.getCompleted()){
						counter++;
					}
				}
				if (counter == city.getEstates().size()){
					city.setCompleted(true);
					System.out.println("Congratulations! \nYou have completed all of the activities in " + city.getName() + "!\n");

				}
			}
		    int counter = 0;
		    for (City c: cl){
		    	if (c.getCompleted()){
		    		counter++;
		    	}
		    }
		    if (counter == cl.size()){
		    	setCompleted(true);
		    	System.out.println("Congratulations! \nYou have completed all of the activities in the entire game!");
		    	break;
		    }
		}		
		read.close();
	}
	
	public City findCity(String city){
		for (City c : cl)
			if ((c.getCompleted().equals(false)) && (c.getName()).replaceAll("[^a-zA-Z ]", "").toLowerCase().equals(city)){  
	        	return c;
	        }
	    	return new City("null");
		}

	public Estate findEstate(City city, String estate){
		for (Estate e : city.getEstates())
			if ((e.getCompleted().equals(false)) && (e.getName()).replaceAll("[^a-zA-Z ]", "").toLowerCase().equals(estate)){  
	        	return e;
	        }
	    	return new Estate("null", city.getName());
		}
		
	public Person findPerson(Estate estate, String person){
		for (Person p : estate.getPeople())
			if ((p.getCompleted().equals(false)) && (p.getName()).replaceAll("[^a-zA-Z ]", "").toLowerCase().equals(person)){  
	        	return p;
	        }
	    	return new Person("null", estate.getName());
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
		String score = "You completed " + austen.getCorrect() + " actitivies!\n";
		String thanksForPlaying = "Thank you for visiting Austenia. We hope you come back soon.";
		System.out.println(score + thanksForPlaying);
		
	}

	public static void interpretAnswer(boolean b){
		if (b == true){
			System.out.println("Congratulations! You are correct!\n");
		}else{
			System.out.println("Sorry, that's incorrect.\n");
		}
		
	}

	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}

}
