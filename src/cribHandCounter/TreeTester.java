package cribHandCounter;

public class TreeTester {

	public static void main(String[] args) {
		Hand hand = new Hand();
		
		String[] suits = {"Spades","Diamonds","Clubs","Hearts"};
		String[] vals = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
		
		for (int i=0; i<25; i++) {
			Card c = new Card(vals[(int) (Math.random() * 13)],suits[(int) (Math.random() * 3)]);
			hand.addCard(c);
		}
		System.out.println(hand);
	
	
		TreeBuilder tree = new TreeBuilder(hand);
		int count = 0;
		while(tree.getTreeCard(tree.size()-1).getRank() <hand.getHandSize()) {
			tree.addRing(tree.getTreeCard(count));
			count++;
		}
		
		tree.calcPoint();
		
	}
}
