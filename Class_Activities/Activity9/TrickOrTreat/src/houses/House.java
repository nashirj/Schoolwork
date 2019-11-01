package houses;

import myProps.CandyType;
import myProps.TrickType;

public class House implements Comparable {
	protected CandyType c;
	protected TrickType t;
	protected int amountOfCandy;
	
	public House(CandyType a, int maxCandy) {
		this.c = a;
		//set some random amount from our estimate of max candy
		this.amountOfCandy =  (int) ((Math.random()*((maxCandy-0)+1))+0);
	}

	
	public CandyType trickOrTreat() {
		if(this.amountOfCandy > 0) {
			this.amountOfCandy--;
			return this.c;
		}
		else {
			System.out.println("What there is no more candy???");	
			return null;
		}
	}
	
	public void trick(TrickType t) {
		this.t = t;
	}


	public String toString() {
		return "HOUSE: " + this.amountOfCandy; 
	}


	@Override
	public int compareTo(Object o) {
		// This line will cause a runtime exception if o is not of type House
		House h = (House) o;
//		if (h.amountOfCandy < this.amountOfCandy)
//			return 1;
//		else if (h.amountOfCandy > this.amountOfCandy)
//			return -1;
//		else
//			return 0;
		return this.amountOfCandy - h.amountOfCandy;
	}
}
