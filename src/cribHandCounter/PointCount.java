package cribHandCounter;

/* Functionality for counting all possible points in hands
 * @author Alexander Gates
 * @date Nov.06.2019
 */
public class PointCount {

	private Hand hand;
	private int points;
	private int fifteenPoints; //currently this is just for display purposes, kinda gross, think of a way to get rid of it
	
	public PointCount(Hand hand){
		this.points = 0;
		this.hand = hand;
		this.fifteenPoints = 0;
	}
	
	public int getPoints() {return this.points;}
	
	public String toString() {
		return "Points: " + points;
	}
	
	/*
	 * Calculates points based on pairs that exist in hand
	 */
	public int pairsPoints() {
		int pointCount = 0;
		for(int i = 0; i<=this.hand.getHandSize()-2; i++) {
			for(int j=i+1; j<=this.hand.getHandSize()-1; j++) {
				if(this.hand.getCard(i).getAbsValue() == this.hand.getCard(j).getAbsValue())
					pointCount+=2;
			}
			
		}
		System.out.println("Pairs Points: " + pointCount);
		this.points+=pointCount;
		return pointCount;
	}
	
	/*
	 * Finds runs in your hand 
	 */
	public int findRuns() {
		int runPoints = 0;
		
		int runLength = 1;
		
		//this will create a new hand of no duplicate cards
		Hand noDup = new Hand();
		for(int i=0; i<this.hand.getHandSize()-1; i++) {
			if(!this.hand.getCard(i).equals(this.hand.getCard(i+1)))
				noDup.addCard(this.hand.getCard(i));
			}
		noDup.addCard(this.hand.getCard(this.hand.getHandSize()-1));
		//System.out.println("NonDupeHand:  " + noDup);
		
		
		//iterate at first card of hand, then check each card after to see if its a run
		for(int i = 0; i < noDup.getHandSize()-1; i++) {

			int j = 1;
			while(i+j < noDup.getHandSize() && noDup.getCard(i).getAbsValue() == noDup.getCard(i+j).getAbsValue() - j) {
				runLength++;
				j+=1;
			}
			
			if(runLength >=3) {
				Hand runHand = new Hand();
				
				//add the cards backwards into runHand
				for(int q=i+j-1; q>=i; q--) {
					runHand.addCard(noDup.getCard(q));
				}
				runPoints += runPoints(runHand);
			}
			
			i +=j-1;			//j-1 because for loop iterates 
			runLength = 1;
		}
		return runPoints;
	}
	
	/*
	 * Calculates points in hand using run hand that was created in runPoints method
	 * @param run is a hand of cards that are in the runs
	 */
	public int runPoints(Hand run) {
		int duplicate = 0;
		int multiplier = 1;
		
		//count how many duplicate cards are in the hand
		for(int i=0; i<run.getHandSize(); i++) {
			for(int j=0; j<this.hand.getHandSize(); j++) {
				if(run.getCard(i).getAbsValue() == this.hand.getCard(j).getAbsValue() ) {
					duplicate++;
				}
			}
			if(duplicate>=1)
				multiplier*=duplicate;
			duplicate = 0;
		}
		this.points += multiplier*run.getHandSize();
		System.out.println("Points from Runs: " + multiplier*run.getHandSize());
		return multiplier*run.getHandSize();
	}
	
	
	
	/*
	 * Finds points based on combinations of 15
	 */
	public void fifteenCombination(int[] a,int[] b,int aBeg,int bEnd){
    	for(int i=aBeg;i<a.length;i++){
            b[bEnd+1]=a[i];
            fifteenPoints(b,bEnd+1);
            if(i<a.length-1)
                fifteenCombination(a,b,i+1,bEnd+1);
        }
    }
	
	 public void fifteenPoints(int[] a,int len){
	       int sum = 0;
	    	for (int i=0;i<=len;i++) {
	            sum+= a[i];
	     //       System.out.println("1 combination");
	        }
	        if(sum == 15) 
	        	fifteenPoints+=2;
	}
	 
	 public int addFifteenPoint(){System.out.println("Points from fifteens: " + fifteenPoints); this.points+= this.fifteenPoints; return this.fifteenPoints;} //gross get rid off
	
	/* 
	 * Counts the points for having all cards of the same suit
	 * if the hand size is greater than 5, double points 
	 * cuurently not implementing auto counting for ease of entering values
	 */
	public int fullSuitPoints(boolean sameSuit, boolean cutCard) {
		int pointCount =0;
		
		if(sameSuit && cutCard) 
			pointCount += this.hand.getHandSize();
		else if(sameSuit)
			pointCount += this.hand.getHandSize()-1;
				
		System.out.println("Suit Points: " + pointCount);
		
		this.points+=pointCount;
		return pointCount;
	}
	
	/*
	 * counts the points for having the jack of trumps
	 * currently not implemented for ease of entering true/false
	 */
	public int jackPoints(boolean nobs) {

		if(nobs) {
			System.out.println("Nobs: 1 Point");
			points+=1;
			return 1;
		}
		if(!nobs) 
			System.out.println("Nobs: 0 Points");
			
		return 0;
	}
}