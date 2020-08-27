package cribHandCounter;


import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;    
public class CribGUI {  

	public static void main(String[] args) {  
		
		Hand hand = new Hand();
		
		JFrame frame=new JFrame("Cribbage");
		
		JButton addCard=new JButton(new ImageIcon("C:\\Users\\alexa\\Desktop\\Deck\\addCard.png"));  
		addCard.setBounds(30,30,180,252);  
		
		JLabel cardFormat = new JLabel("Format: 1,2,3 using 1-13 for Ace-King");
		cardFormat.setBounds(30,300,240,20);
		frame.add(cardFormat);
		
		JTextField cards = new JTextField();
		cards.setBounds(30,330,180,25);
		frame.add(cards);
		
		JRadioButton nobs = new JRadioButton("Nobs");
		nobs.setBounds(30,380,60,25);
		frame.add(nobs);
		
		JRadioButton flush = new JRadioButton("Flush");
		flush.setBounds(90,380,60,25);
		frame.add(flush);
		
		JRadioButton cutCard = new JRadioButton("Cut Card");
		cutCard.setBounds(150,380,60,25);
		frame.add(cutCard);
		
		JLabel handLabel = new JLabel("HAND");
		handLabel.setBounds(650,30,300,30);
		handLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		frame.add(handLabel);
		
		JPanel handDisplay = new JPanel(/*new GridLayout(0,5)*/);
		handDisplay.setBounds(550,70,300,300);
		//handDisplay.setBackground(Color.GRAY);
		
		JButton calcPoints = new JButton("Calculate Points");
		calcPoints.setBounds(30,450,180,30);
		frame.add(calcPoints);
		
		JTextArea pointDisplay = new JTextArea(6,1);
		pointDisplay.setBounds(30, 500, 180, 300);
		frame.add(pointDisplay);
		
		frame.add(handDisplay);
		frame.add(addCard);  
		frame.setSize(900,900);  
		frame.setLayout(null);  
		frame.setVisible(true);   
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		addCard.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				String[] handArray = cards.getText().split(",");
				for(String s:handArray) {
					Card c = new Card(Integer.parseInt(s));
					JLabel newCard = new JLabel(c.toString());
					newCard.setBorder(BorderFactory.createLineBorder(Color.black,2));
					handDisplay.add(newCard);
					hand.addCard(c);
				}
				//System.out.println(hand);
				handDisplay.revalidate();
			}  
		}); 
		
		calcPoints.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				PointCount points = new PointCount(hand);
				hand.sort();
				
				pointDisplay.append("Nobs Points: " + points.jackPoints(nobs.isSelected()) + "\n");
				pointDisplay.append("Flush Points: " + points.fullSuitPoints(flush.isSelected(), cutCard.isSelected()) + "\n");		
				
				pointDisplay.append("Run Points: " + points.findRuns() + "\n");
			    pointDisplay.append("Pair Points: " + points.pairsPoints() + "\n");
					
				//15's need just an int array
				int[] handArray1 = hand.toIntArray();
				int[] handArray2 = new int[handArray1.length];
				points.fifteenCombination(handArray1,handArray2,0,-1);
				pointDisplay.append("Fifteen Points: " + points.addFifteenPoint() + "\n");
	
				pointDisplay.append("Total Points:" + points);
				System.out.println(points);
				System.out.println(hand);
				} 
		}); 
	}  
}