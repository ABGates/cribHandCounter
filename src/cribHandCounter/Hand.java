package cribHandCounter;
/*
 * Hand class creates a hand of cards 
 * Also adds the cut card to the hand the ability to distinguish cut cards
 * @author Alexander Gates
 * @date Nov.06.2019
 */

import java.util.ArrayList;
public class Hand implements Cloneable{

	private ArrayList<Card> hand;
	private Card cutCard;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
	}

	public void addCard(Card card) {this.hand.add(card);}
	
	public Card getCard(int index) {return hand.get(index);}
	
	public void setCutCard(Card card) {
		this.cutCard = card;
		this.hand.add(this.cutCard);
	}
	
	public Card getCutCard() {return this.cutCard;}
	
	public int getHandSize() {
		return this.hand.size();
	}
	
	public String toString() {
		String handString = "Hand Size: " + this.getHandSize() + "\nCards in hand: ";
		for(Card c:this.hand) {
			handString += c.toString() + "|";
		}
		return handString;
	}
	
	public void sort() {
		for(int j = 0; j<this.hand.size(); j++) {
			for(int i = 0; i<this.hand.size()-1; i++) {
				Card temp = this.hand.get(i);
			
				if(this.hand.get(i).getAbsValue() > this.hand.get(i+1).getAbsValue()) {
					this.hand.set(i, this.hand.get(i+1));
					this.hand.set(i+1, temp);
				}
			}
		}
	}
	
	public Object clone() {
		Hand copiedHand = new Hand();
		for(int i = 0; i<this.hand.size(); i++) {
			copiedHand.addCard(hand.get(i));
		}
		return copiedHand;
	}
	
	public int[] toIntArray() {
		int[] valueArray = new int[this.getHandSize()];
		
		for(int i =0; i<this.getHandSize(); i++) 
			valueArray[i] = this.getCard(i).getCribValue();
		
		return valueArray;
	}
	
}
