import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Store {
	
	//You must run your project and report the output in report.txt. You should add more API or methods
	//that you think is good to have in Shopping carts to get full credit.
	//i.e. remove an item from the card.
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//create store
		BDC store = new BDC();

		System.out.println("Welcome to BDC; we sell books, movies, CDs, and other miscellaneous items!\nThanks for shopping with us today!");
		
		//get user information
		System.out.print("Please enter your first name: ");
		String fName = input.nextLine();
		
		System.out.print("Please enter your last name: ");
		String lName = input.nextLine();
		
		String iD;
		do {
			System.out.print("Please enter your 5-digit store ID: ");
			iD = input.nextLine();			
		} while (iD.length() != 5);
		
		//create customer with inputted information
		Customer cust = new Customer(fName, lName, iD);

		//new line for formatting
		System.out.println();

		System.out.println("Welcome " + cust.getName() + "!");
		//initialize variable for staying in loop
		boolean stillShopping = true;
		while (stillShopping) {
			//print main menu
			System.out.println("1) List items available in store\n"
					+ "2) Purchase item\n"
					+ "3) Print items in cart\n"
					+ "4) Show Balance\n"
					+ "5) Checkout\n"
					+ "6) Remove item from cart\n"					
					+ "7) Quit");
			String user_in = input.nextLine();
			int selection;
			//check to make sure input is integer and in bounds
			if (user_in.length() == 1 && Character.isDigit(user_in.charAt(0)))
				selection = Character.getNumericValue(user_in.charAt(0));
			else {
				selection = -1;
			}
			if (selection < 1 || selection > 7) {
				System.out.println("That is not a valid option...");
				continue;
			}
			
			//print menu of items in store
			switch(selection) {
			case 1:
				System.out.println("What items are you interested in today?\n"
						+ "For books, enter [1]\n"
						+ "For CDs, enter [2]\n"
						+ "For Movies, enter [3]\n"
						+ "For other items, enter [4]\n"
						+ "To see all of our items, enter [5]");
				user_in = input.nextLine();
				//check to make sure input is integer and in bounds
				if (user_in.length() == 1 && Character.isDigit(user_in.charAt(0)))
					selection = Character.getNumericValue(user_in.charAt(0));
				else {
					selection = -1;
				}
				if (selection < 1 || selection > 5) {
					System.out.println("That is not a valid option...");
					continue;
				}
				
				//newline for formatting
				System.out.println("");
				
				//print appropriate list of items
				switch(selection) {
				case 1:
					store.printBooks();
					break;
				case 2:
					store.printCDs();
					break;
				case 3:
					store.printMovies();
					break;
				case 4:
					store.printMisc();
					break;
				case 5:
					store.printAllItems();
					break;
				case -1:
				default:
					continue;
				}
				break;
			//purchase an item
			case 2:
				System.out.println("Input the item ID: ");
				user_in = input.nextLine();
				Item i = store.findItem(user_in);
				if (i != null) {
					cust.getCart().addItem(i);
					System.out.println(i.getTitle() + " was added to the cart successfully!");
				}
				else
					System.out.println("That item was not found...");
				break;
			//print items in cart
			case 3:
				cust.getCart().printCart();
				break;
			//print current subtotal
			case 4:
				DecimalFormat df = new DecimalFormat("#.00");
				System.out.println("The subtotal of the cart is $" + df.format(cust.getCart().getBalance()));
				break;
			//checkout!
			case 5:
				store.checkOut(cust.getCart());
				stillShopping = false;
				continue;
			//remove an item
			case 6:
				System.out.println("Enter the ID of the item you'd like to remove: ");
				user_in = input.nextLine();
				i = cust.getCart().findItemByID(user_in);
				if (i != null) {
					cust.getCart().removeItem(i);
					System.out.println(i.getTitle() + " was removed from your cart succesfully!");
				}
				else {
					System.out.println("That item is not in your cart...");
				}
				break;
			//quit
			case 7:
				stillShopping = false;
				continue;
			}
		}
		
		System.out.println("Goodbye!");
	}
}

//generic item class, all other items derive from this
class Item{
	private String title, description, ID;
	private double price;
	//constructor
	public Item(String title, String description, double price) {
		this.title = title;
		this.description = description;
		this.price = price;
		ID = UUID.randomUUID().toString().substring(0, 5);
	}
	//getters and setters for member variables
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	//no setter for ID because we don't want it to be changed
	public String getID() {
		return ID;
	}
	public void setDescription(String description) {
		this.description = description;
}
	public String getDescription() {
		return description;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Title: " + title + "\nDescription: " + description + "\nPrice: $" + df.format(price) + "\nID: " + getID();
	}
}

class Book extends Item{
	//unique item identifier
	private int pageCount;
	public Book(String title, String description, double price, int pageCount) {
		super(title, description, price);
		this.pageCount = pageCount;
	}
	//getters and setters for member variables
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Title: " + getTitle() + "\nDescription: " + getDescription() + "\nPage Count: " + pageCount + "\nPrice: $" + df.format(getPrice()) + "\nID: " + getID();
	}
}
class Movie extends Item{
	//unique item identifier
	private int length;
	public Movie(String title, String description, double price, int length) {
		super(title, description, price);
		this.length = length;
	}
	//getters and setters for member variables
	public void setLength(int length) {
		this.length = length;
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Title: " + getTitle() + "\nDescription: " + getDescription() + "\nLength: " + length + "\nPrice: $" + df.format(getPrice()) + "\nID: " + getID();
	}
}
class CD extends Item{
	//unique item identifier
	private int trackCount;
	public CD(String title, String description, double price, int trackCount) {
		super(title, description, price);
		this.trackCount = trackCount;
	}
	//getters and setters for member variables
	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}
	public int getTrackCount() {
		return trackCount;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Title: " + getTitle() + "\nDescription: " + getDescription() + "\nTrack Count: " + trackCount + "\nPrice: $" + df.format(getPrice()) + "\nID: " + this.getID();
	}
}

//every customer "has" a shopping cart to store their items
class ShoppingCart{
	private ArrayList<Item> items;
	private int numItems;
	private Customer me;
	public ShoppingCart(Customer me) {
		numItems = 0;
		items = new ArrayList<Item>();
		this.me = me;
	}
	//member functions
	public void addItem(Item i) {
		items.add(i);
		numItems++;
	}
	public Item findItemByID(String iD) {
		for (Item e: items) {
			if (e.getID().equals(iD))
				return e;
		}
		return null;
	}
	public boolean removeItem(Item i) {
		numItems--;
		return items.remove(i);
	}
	public void printCart() {
		System.out.println("There are " + numItems + " items in " + me.getName() + "'s (" + me.getID() + ") cart");
		for (int i = 0; i < numItems; i++) {
			System.out.println("Item " + (i+1));
			Item item = items.get(i);

			//Item Type
			System.out.print("Type: ");
			if (item instanceof Movie) {
				System.out.println("Movie");
			}
			else if (item instanceof CD) {
				System.out.println("CD");
			}
			else if (item instanceof Book) {
				System.out.println("Book");
			}
			else {
				System.out.println("Misc");
			}
			//Print details of item (calls overloaded toString for derived classes)
			System.out.println(item.toString());
		}
	}
	public double getBalance() {
		double subtotal = 0;
		for (int i = 0; i < numItems; i++) {
			subtotal += items.get(i).getPrice();
		}
		return subtotal;
	}
}

//shopper
class Customer{
	private ShoppingCart myCart;
	private String fName, lName, iD;
	public Customer(String fName, String lName, String iD) {
		this.fName = fName;
		this.lName = lName;
		this.iD = iD;
		myCart = new ShoppingCart(this);
	}
	//getters and setters
	public String getName() {
		return fName + " " + lName;
	}
	public void setName(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}
	public String getID() {
		return iD;
	}
	public void setID(String iD) {
		this.iD = iD;
	}
	public ShoppingCart getCart() {
		return myCart;
	}
}

class BDC{
	ArrayList<Item> store;
	public BDC() {
		store = new ArrayList<Item>();
		
		//item number 1
		Item telescope = new Item(
				"Telescope",
				"high-powered refractor telescope great for stargazing!",
				79.99
			);
		store.add(telescope);
		
		//item number 2
		Item kindOfBlue = new CD(
				"Kind of Blue",
				"A studio album by American jazz trumpeter Miles Davis. It is regarded by many critics as jazz's greatest record, Davis\'s\n"
				+ "             masterpiece, and one of the best albums of all time.",
				15.95,
				5
			);
		store.add(kindOfBlue);
		
		//item number 3
		Item crackingTheCodingInterview = new Book(
				"Cracking the Coding Interview",
				"Cracking the Coding Interview, 6th Edition is designed to help prospective software engineers through the process of\n"
				+ "             preparing for the job hunt, teaching them what they need to know and enabling optimal performance during the interview.",
				34.89,
				696
			);
		store.add(crackingTheCodingInterview);
		
		//item number 4
		Item harryPotter1 = new Book(
				"Harry Potter and the Sorcerer\'s Stone",
				"The story of Harry Potter, a boy who learns on his eleventh birthday that he is the orphaned son of two powerful\n"
				+ "             wizards and possesses unique magical powers of his own. He is summoned from his life as an unwanted child to\n"
				+ "             become a student at Hogwarts, an English boarding school for wizards. There, he meets several friends who become\n"
				+ "             his closest allies and help him discover the truth about his parents' mysterious deaths.",
				8.99,
				223
			);
		store.add(harryPotter1);
		
		//item number 5
		Item littleFiresEverywhere = new Book(
				"Little Fires Everywhere", 
				"Mia starts as Mrs. Richardon's tenant, then becomes her housekeeper, then a mentor and secret keeper for her\n"
				+ "             children; Pearl falls into a love triangle with the two Richardson boys. Like Shaker Heights, \"Little Fires\n"
				+ "             Everywhere\" is meticulously planned, every storyline and detail placed with obvious purpose.",
				13.99,
				352
			);
		store.add(littleFiresEverywhere);
		
		//item number 6
		Item zootopia = new Movie(
				"Zootopia",
				"From the largest elephant to the smallest shrew, the city of Zootopia is a mammal metropolis where\n"
				+ "             various animals live and thrive. When Judy Hopps (Ginnifer Goodwin) becomes the first rabbit to join the\n"
				+ "             police force, she quickly learns how tough it is to enforce the law. Determined to prove herself, Judy\n"
				+ "             jumps at the opportunity to solve a mysterious case. Unfortunately, that means working with Nick Wilde\n"
				+ "             (Jason Bateman), a wily fox who makes her job even harder.",
				15.97,
				110
			);
		store.add(zootopia);
		
		//item number 7
		Item blackPanther = new Movie(
				"Black Panther",
				"After the death of his father, T'Challa returns home to the African nation of Wakanda to take his rightful place\n"
				+ "             as king. When a powerful enemy suddenly reappears, T'Challa's mettle as king -- and as Black Panther -- gets\n"
				+ "             tested when he's drawn into a conflict that puts the fate of Wakanda and the entire world at risk. Faced with\n"
				+ "             treachery and danger, the young king must rally his allies and release the full power of Black Panther to defeat\n"
				+ "             his foes and secure the safety of his people.",
				24.99,
				135
			);
		store.add(blackPanther);
		
		//item number 8
		Item starWars = new Movie(
				"Star Wars: Episode VIII: The Last Jedi", 
				"Luke Skywalker's peaceful and solitary existence gets upended when he encounters Rey, a young woman who shows strong\n"
				+ "             signs of the Force. Her desire to learn the ways of the Jedi forces Luke to make a decision that changes their\n"
				+ "             lives forever. Meanwhile, Kylo Ren and General Hux lead the First Order in an all-out assault against Leia and\n"
				+ "             the Resistance for supremacy of the galaxy.",
				19.99, 
				152
			);
		store.add(starWars);
		
		//item number 9
		Item karateKid = new Movie(
				"The Karate Kid",
				"Daniel (Ralph Macchio) moves to Southern California with his mother, Lucille (Randee Heller), but quickly finds himself\n"
				+ "             the target of a group of bullies who study karate at the Cobra Kai dojo. Fortunately, Daniel befriends Mr. Miyagi\n"
				+ "             (Noriyuki \"Pat\" Morita), an unassuming repairman who just happens to be a martial arts master himself. Miyagi takes"
				+ "             Daniel under his wing, training him in a more compassionate form of karate and preparing him to compete against the\n"
				+ "             brutal Cobra Kai.",
				7.88,
				127
			);
		store.add(karateKid);
	}
	public void printBooks() {
		System.out.println("\'Available Books\'");
		int itemNumber = 1;
		for (Item e: store) {
			if (e instanceof Book) {
				System.out.println("Item #" + itemNumber + ":\n" + e.toString() + "\n");
				itemNumber++;
			}
		}
	}
	public void printMovies() {
		System.out.println("\'Available Movies\'");
		int itemNumber = 1;
		for (Item e: store) {
			if (e instanceof Movie) {
				System.out.println("Item #" + itemNumber + ":\n" + e.toString() + "\n");
				itemNumber++;
			}
		}
	}
	public void printCDs() {
		System.out.println("\'Available CDs\'");
		int itemNumber = 1;
		for (Item e: store) {
			if (e instanceof CD) {
				System.out.println("Item #" + itemNumber + ":\n" + e.toString() + "\n");
				itemNumber++;
			}
		}
	}
	public void printMisc() {
		System.out.println("\'Available Items\'");
		int itemNumber = 1;
		for (Item e: store) {
			if (!(e instanceof CD) && !(e instanceof Movie) && !(e instanceof Book)) {
				System.out.println("Item #" + itemNumber + ":\n" + e.toString() + "\n");
				itemNumber++;
			}
		}
	}
	public void printAllItems() {
		for (Item e: store) {
			System.out.println("Item #" + (store.indexOf(e)+1) + ":");
			System.out.println(e.toString());
			System.out.print("Type: ");
			if (e instanceof Movie)
				System.out.println("\'Movie\'");
			else if (e instanceof CD)
				System.out.println("\'CD\'");
			else if (e instanceof Book)
				System.out.println("\'Book\'");
			else
				System.out.println("\'Item\'");
		}
	}
	public Item findItem(String iD) {
		for (Item e: store) {
			if (e.getID().equals(iD)) {
				return e;
			}
		}
		return null;
	}
	public void checkOut(ShoppingCart s) {
		DecimalFormat df = new DecimalFormat("#.00");
			System.out.println("$" + s.getBalance() + " was charged to your bank account successfully.\nThanks for shopping at BDC!");
			return true;
	}
}
