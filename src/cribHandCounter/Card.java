package cribHandCounter;
/*
 * Class that creates card objects based on suit & name
 * Adds functionality to get values for counting points in crib
 * @author Alexander Gates
 * @date Nov.06.2019
 */

public class Card implements Comparable{
	
	private String name;
	private String suit;

	public Card(String name, String suit){
		this.name = name;
		this.suit = suit;
	}
	

	public String getName(){return this.name;}
	
	public String getSuit(){return this.suit;}
	
	public int getAbsValue() {
		int absValue = 0;
		
		switch(this.name.toLowerCase()) {
			case "1": absValue = 1; break;
			case "2": absValue = 2; break;
			case "3": absValue = 3; break;
			case "4": absValue = 4; break;
			case "5": absValue = 5; break;
			case "6": absValue = 6; break;
			case "7": absValue = 7; break;
			case "8": absValue = 8; break;
			case "9": absValue = 9; break;
			case "10": absValue = 10; break;
			case "11": absValue = 11; break;
			case "12": absValue = 12; break;
			case "13": absValue = 13; break;
		}
		return absValue;		
	}
	
	public int getCribValue() {
		int cribValue = 0;
		
		switch(this.name.toLowerCase()) {
			case "1": cribValue = 1; break;
			case "2": cribValue = 2; break;
			case "3": cribValue = 3; break;
			case "4": cribValue = 4; break;
			case "5": cribValue = 5; break;
			case "6": cribValue = 6; break;
			case "7": cribValue = 7; break;
			case "8": cribValue = 8; break;
			case "9": cribValue = 9; break;
			case "10": cribValue = 10; break;
			case "11": cribValue = 10; break;
			case "12": cribValue = 10; break;
			case "13": cribValue = 10; break;
		}
		
		return cribValue;
	}
	
	public String toString(){
		return this.name + " of " + this.suit;
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
	public int compareTo(Object o) {
		Card other = (Card)o;
		if(other.getAbsValue() > this.getAbsValue())
			return -1;
		else if(other.getAbsValue() < this.getAbsValue())
			return 1;
		else return 0;
	}
	
	

}
