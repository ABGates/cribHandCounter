package cribHandCounter;


import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;    
public class CribGUI {  

	public static void main(String[] args) {  
		
		Hand hand = new Hand();
		
		JFrame frame=new JFrame("Cribbage");
		
		JButton addCard=new JButton(new ImageIcon("C:\\Users\\alexa\\Desktop\\Deck\\addCard.png"));  
		addCard.setBounds(50,30,180,252);  
		
		JLabel sLabel = new JLabel("Suit:");
		sLabel.setBounds(50,300,30,15);
		frame.add(sLabel);
		JTextField suit = new JTextField();
		suit.setBounds(50,320,60,15);
		frame.add(suit);
		
		JLabel vLabel = new JLabel("Value:");
		vLabel.setBounds(175,300,40,15);
		frame.add(vLabel);
		JTextField value = new JTextField();
		value.setBounds(175,320,60,15);
		frame.add(value);
		
		JPanel handDisplay = new JPanel(new GridLayout(0,5));
		handDisplay.setBounds(550,40,300,600);
		handDisplay.setBackground(Color.GRAY);
		
		addCard.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				String s = suit.getText().substring(0,1).toLowerCase();
				String v = value.getText().substring(0,1).toLowerCase();
				Card c = new Card(v,s);
				hand.addCard(c);
				//System.out.println(hand);
				JLabel newCard = new JLabel(s + " " + v);
				handDisplay.add(newCard);
				handDisplay.revalidate();
			}  
		}); 
		
		
		frame.add(handDisplay);
		frame.add(addCard);  
		frame.setSize(900,900);  
		frame.setLayout(null);  
		frame.setVisible(true);   
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
}