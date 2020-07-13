package cribHandCounter;

import javax.swing.*;
class CribGUI{
     
	public static void main(String args[]){
         
		  JFrame frame = new JFrame("My First GUI");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          frame.setSize(300,300);
          JTextField in = new JTextField(10);
          frame.add(in);

          frame.setVisible(true);
     }
}