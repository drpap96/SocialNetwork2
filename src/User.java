import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class User {
	private String name;
	private String email;
	private ArrayList<User> friends= new ArrayList<User>();
	private ArrayList<General_Groups> gp = new ArrayList<>();
	
	//κατασκευαστής.
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	 public String getEmail() {
		 return email;
	 }
	public String getName() {
		return name;
	}
	//ΜΕΘΟΔΟΣ ΕΛΕΓΧΟΥ EMAIL.
	public boolean checkingEmail(String email) {
		
		int i,position;
		String firstChars, lastChars;
		
		i=email.length();  //το μήκος του αλφαριθμητικού.το μαχ ειναι 19.το ι=18 
		firstChars=email.substring(0, 3); //επιστρέφει τους τρείς πρώτους χαρακτήρες.
		position=email.indexOf("@"); //επιστρέφει την θέση του @.
		lastChars=email.substring(position);
		return( (i<=19)&&  ( email.matches("dai(.*)")  || email.matches("ics(.*)")) || email.matches("iis(.*)") && lastChars.matches("@uom.edu.gr") );
		//return( (i<=19) && (  firstChars.contains("iis")|| firstChars.contains("dai")|| firstChars.contains("ics"))   && (lastChars.contains("@uom.edu.gr")));
		
	}
	
	//έλεγχος υπαρξης φιλίας.
	public boolean checkingFriendShip(User user_) {
		return(friends.contains(user_));
	}
	//προσθηκη φιλων
	public void friendList(User user_) {
		
		if(!checkingFriendShip(user_)) {
			friends.add(user_);
			user_.friends.add(this);
			System.out.println(name +" and " + user_.getName() + " are now friends!");
		}
		
		//Sorting the ArrayList friends (alphabetical order)
		Collections.sort(friends, new Comparator<User>() {
            @Override
            public int compare(User item, User t1) {
                String s1 = item.getName();
                String s2 = t1.getName();
                return s1.compareToIgnoreCase(s2);
            }

        });
		
		
	}
	//έλεγχος κοινων φιλων
	public ArrayList<User> matualFriends(User u)    {
	    ArrayList<User> matual_Friends = new ArrayList<>(); //δημιουργια λίστας για έλεγχο κοινών φίλων.
	    ArrayList<User> clone_friendList= (ArrayList<User>)friends.clone(); //δημιουργει τον κλόνο 
	    clone_friendList.retainAll(u.friends);
	    return clone_friendList;
	    	
	    }
	
		
	
	public void printFriend() {
		System.out.println("*******************");
		System.out.println( "Friends of " + name );
		System.out.println("*******************");

		for(int i=0; i<friends.size(); i++) {
			//XRIAZETE TAJINOMISI I LISTA FILON.
			System.out.println(i+1 +  " : "+ friends.get(i).getName());
		}
		System.out.println("-------------------");
	}
	

}
