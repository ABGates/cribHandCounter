package cribHandCounter;
import java.util.ArrayList;


public class TreeBuilder {
	public Hand hand;
	public ArrayList<TreeCard> tree;
	
	public TreeBuilder(Hand h) {
		this.hand = h;
		this.tree = new ArrayList<TreeCard>();
		this.tree.add(new TreeCard(this.hand.getCard(0),null,1));
	}
	
	
	public void addRing(TreeCard parent) {
		int start = this.hand.indexOf(parent.getCard());
		for (int i = start+1; i<this.hand.getHandSize(); i++){
			tree.add(new TreeCard(hand.getCard(i),parent,parent.getRank()+1));
		}
	}
	
	public int calcPoint() {
		int displayCount = 0;
		int points = 0;
		for (int rank = hand.getHandSize(); rank>1; rank--) {
			for(TreeCard t:tree) {
				if (t.getRank() == rank) {
					if(treeTraverser(t))
						points+=2; displayCount++;
				}
			}
		}
		
		for (TreeCard branch:tree) {
			if (branch.getRank() == 2) 
				branch.setParent(null);
		}
		
		
	for (int rank = hand.getHandSize(); rank>2; rank--) {
			for(TreeCard t:tree) {
				if (t.getRank() == rank) {
					if(treeTraverser(t))
						points+=2; displayCount++;
				}
			}
		}
		
		System.out.println("points:" + points);
		System.out.println("totalCombinations: " + displayCount);
		return points;
	}
	
	public boolean treeTraverser(TreeCard tCard) {
		int sum = 0;
		boolean hasParent = true;
		//System.out.print("sum:");
		while(hasParent) {
			sum+=tCard.getCard().getCribValue();
			//System.out.print(tCard.getCard().getCribValue() + " + ");
			if (tCard.hasParent()) {
				tCard = tCard.getParent();
				hasParent = true;
			}
			else
				hasParent = false;
				
		}
		
		//System.out.println("=" + sum);
		if(sum == 15) 
			return true;
		else 
			return false;
	}
	
	public TreeCard getTreeCard(int index) {
		return this.tree.get(index);
	}
	
	public int size() {
		return this.tree.size();
	}
	
	public String toString() {
		String treeString = "";
		int rank = 1;
		for (int i = 0; i<tree.size(); i++) {
			if(tree.get(i).getRank() != rank) {
				treeString += "\n";
				rank++;
			}
			
			if(!tree.get(i).hasParent()) 
				treeString += "(C:" + tree.get(i).getCard().getAbsValue() + tree.get(i).getCard().getSuit().substring(0,1) + ")(R:" + tree.get(i).getRank() + ")(ROOT)|";
			else 
				treeString += "(C:" + tree.get(i).getCard().getAbsValue() + tree.get(i).getCard().getSuit().substring(0,1) + ")(R:" + tree.get(i).getRank() + ")(^:" + tree.get(i).getParent().getCard().getAbsValue() +  tree.get(i).getParent().getCard().getSuit().substring(0,1) +  tree.get(i).getParent().getRank() + ")|"; 
		
			
		}
		return treeString;
	}
}
