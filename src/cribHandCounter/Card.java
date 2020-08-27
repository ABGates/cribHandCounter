package cribHandCounter;
/*
 * Class that creates card objects based on suit & name
 * Adds functionality to get values for counting points in crib
 * @author Alexander Gates
 * @date Nov.06.2019
 */

public class Card {
	
	private int value;


	public Card(int value){
		this.value = value;
	}
	

	public int getAbsValue(){return this.value;}
	
	
	public int getCribValue() {
		if (this.value < 10)
			return this.value;
		else
			return 10;
	}
	
	public String toString(){
		
		switch(this.value) {
			case 1: return "Ace";
			case 2: return "Two";
			case 3: return "Three";
			case 4: return "Four";
			case 5: return "Five";
			case 6: return "Six";
			case 7: return "Seven";
			case 8: return "Eight";
			case 9: return "Nine";
			case 10: return "Ten";
			case 11: return "Jack";
			case 12: return "Queen";
			case 13: return "King";
		}
		
		return "This card has an invalid value";
	}

	/*override of equals method, if cards have the same face value they are equal
	 * @param other is comparison card
	 * @return boolean true/false if equal
	 */
	public boolean equals(Card other) {
		if(other.getAbsValue() == this.getAbsValue())
			return true;
		else return false;
	}

	/* override of compareTo method, if face value is greater than return 1, if lower return -1, if equal return 0
	 * @param o is object to compare
	 * @return is -1,0,1
	 */
	/*public int compareTo(Object o) {
		Card other = (Card)o;
		if(other.getAbsValue() > this.getAbsValue())
			return -1;
		else if(other.getAbsValue() < this.getAbsValue())
			return 1;
		else return 0;
	}*/
	
	

}
