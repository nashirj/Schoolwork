package apps;

import houses.ArrayCollection;
import houses.CollectionInterface;
import houses.House;
import myProps.Basket;
import myProps.CandyType;
import myProps.MyTricks;
import myProps.TrickType;

public class HalloweenNight {
	
	public static void main(String[] args) {
		CollectionInterface<House> myNeighbourhood = new ArrayCollection<House>();
		myNeighbourhood.add(new House(CandyType.SNICKERS, 100));
		myNeighbourhood.add(new House(CandyType.TWIZZLERS, 20));
		myNeighbourhood.add(new House(CandyType.TWIX, 0));
		myNeighbourhood.add(new House(CandyType.SWEDISH_FISH, 130));
		myNeighbourhood.add(new House(CandyType.REESES_PIECES, 50));
		
		Basket myBasket = new Basket();
		TrickType myTrickType = TrickType.THROWEGGS;
		
		//We want to sort our neighbourhood houses based on our estimate of candy the houses have
		//Maybe we can order in ascending order - houses having more candy can be visited towards the end
		//because it's unlikely they will run out of candy later in the evening
		
		//For that reason you need to make sure to specify how Houses are ordered by my estimate of candies they give
		myNeighbourhood.sort(); //I provided sort for you, however it will not work if your Houses don't know how to compare
		//themselves
		//TODO: implement comparable for House
		System.out.println(myNeighbourhood); //toString() provided for you
		
		//Let's start trick or treat by using the for-each loop from Iterable
		for(House h: myNeighbourhood) {
			CandyType c  = h.trickOrTreat(); //provided for you
			if(c == null) {
				h.trick(myTrickType); //provided for you
				System.out.println("You just got tricked by my famous " + myTrickType + " trick. ");
				System.out.println(MyTricks.getMyTrick()); //provided for you
			}
			else {
				myBasket.addCandy(c);
			}
		}
		System.out.println(myBasket);
		System.out.println(MyTricks.getMyProp()); //provided for you
	}

}
