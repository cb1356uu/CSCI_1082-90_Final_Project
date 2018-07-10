/*
 * IMAGES for GUI
 */


package edu.century.FinalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class P1P2Buttons extends JButton implements ActionListener{
	ImageIcon buttonP1, buttonP2;
	int value = 0;
	
	
	
	public P1P2Buttons(){
		buttonP1 = new ImageIcon(this.getClass().getResource("buttonP1.png"));
		buttonP2 = new ImageIcon(this.getClass().getResource("buttonP2.png"));
		this.addActionListener(this);
	}
	
	
	public void setP1Icon() {
		setIcon(buttonP1);
		value = 1;
	}
	public void setP2Icon() {
		setIcon(buttonP2);
		value = 2;
	}
	public void setIconNull() {
		setIcon(null);
		value = 0;
	}
	public ImageIcon getP1Icon() {
	return buttonP1;
	}
	public ImageIcon getP2Icon() {
	return buttonP2;
	}
	
	public void actionPerformed(ActionEvent e) {

		switch(value){
		case 0:
			System.out.println("This spot is open.");
			break;
		case 1:
			System.out.println("Player One has already used this spot.");
			break;
		case 2:
			System.out.println("Player Two has already used this spot.");
			break;
	}
	}
}
