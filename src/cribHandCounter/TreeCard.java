package cribHandCounter;

public class TreeCard {
	
	private Card card;
	private TreeCard parent;
	private int rank;
	
	public TreeCard(Card card,TreeCard parent, int rank) {
		this.card = card;
		this.parent= parent;
		this.rank = rank;
	}
	
	public void setParent(TreeCard parent) {
		this.parent = parent;
	}
	
	public TreeCard getParent() {
		return this.parent;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	public int getRank() {
		return this.rank;
	}
	
	public Card getCard() {
		return this.card;
	}
	
	public String toString() {
		String s;
		
		if (this.parent != null) {
			 s =  "Card: " + this.card + " Parent: " + this.parent.getCard() + " Rank: " + this.rank;
		}
		else  s =  "Card: " + this.card + " Parent: None (ROOT Node) Children: " + " Rank: " + this.rank;
		
		return s;
	}
	
	public boolean hasParent()
	{
		return this.parent != null;
	}

}
