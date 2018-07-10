/*
 * GUI FOR THE GAMEBOARD
 */

package edu.century.FinalProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.PrintStream;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;


public class GameBoard extends JFrame implements ActionListener, WindowListener{

	private BoardMechanic boardMech;
	JPanel p = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pNorth = new JPanel();
	JPanel pSouth = new JPanel();
	JPanel pEast = new JPanel();
	JPanel pWest = new JPanel();
	private JTextArea outputAreaNorth;
	private PrintStream standardOutputSteam;
	JTextField p1Txt = new JTextField();
	JTextField p2Txt = new JTextField();

	P1P2Buttons buttons[]=new P1P2Buttons[42];

	private class CheckOnExit implements WindowListener{
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void windowClosing(WindowEvent arg0) {
			ConfirmClose confirmWindow = new ConfirmClose();
			confirmWindow.setVisible(true);
		}
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
	private class ConfirmClose extends JFrame implements ActionListener {
		private JButton yesbtn = new JButton("Yes");
		private JButton nobtn = new JButton("No");
		public ConfirmClose() {
			super("Confirm Window");
			setBounds(400, 400, 350, 150);
			getContentPane().setBackground(Color.WHITE);
			setLayout(new BorderLayout());
			JLabel confirmLabel = new JLabel("Are you sure you want to exit?");
			add(confirmLabel, BorderLayout.CENTER);

			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.WHITE);
			yesbtn.addActionListener(this);
			nobtn.addActionListener(this);
			buttonPanel.add(yesbtn);
			buttonPanel.add(nobtn);
			add(buttonPanel, BorderLayout.SOUTH);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			if (actionCommand.equals("Yes")) {
				System.exit(0);
			} else if (actionCommand.equals("No")) {
				dispose();
			}

		}
	}


	public static void main(String args[]){
		new GameBoard();
		System.out.println("Ready up to start the game!");
	}

	public GameBoard(){
		super("Connect 4");
		boardMech = new BoardMechanic();
		setSize(950,700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		p.setLayout(new BorderLayout());
		pCenter.setLayout(new GridLayout(0,7));
		for(int i=0;i<42;i++){
			buttons[i]=new P1P2Buttons();
			pCenter.add(buttons[i]);
		}
		add(pCenter, BorderLayout.CENTER);

		//
		//
		//NORTH PANEL
		pNorth.setLayout(new BorderLayout(0, 0));
		Border border = BorderFactory.createTitledBorder("Console");
		pNorth.setBorder(border);
		outputAreaNorth = new JTextArea(3, 30);
		outputAreaNorth.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(outputAreaNorth);
		pNorth.add(scrollPane);
		scrollPane.setViewportView(outputAreaNorth);
		pNorth.add(scrollPane);
		add(pNorth, BorderLayout.NORTH);
		//outputAreaNorth.append(buttons.ac);

		//
		//
		//SOUTH PANEL
		pSouth.setLayout(new GridLayout(2, 1));
		JPanel southPanel1 = new JPanel();
		southPanel1.setLayout(new GridLayout(1, 1, 2, 0));
		JPanel southPanel2 = new JPanel();
		pSouth.add(southPanel1);
		pSouth.add(southPanel2);

		JButton row1Button = new JButton("COLUMN 1");
		row1Button.addActionListener(this);
		southPanel1.add(row1Button);

		JButton row2Button = new JButton("COLUMN 2");
		row2Button.addActionListener(this);
		southPanel1.add(row2Button);

		JButton row3Button = new JButton("COLUMN 3");
		row3Button.addActionListener(this);
		southPanel1.add(row3Button);

		JButton row4Button = new JButton("COLUMN 4");
		row4Button.addActionListener(this);
		southPanel1.add(row4Button);

		JButton row5Button = new JButton("COLUMN 5");
		row5Button.addActionListener(this);
		southPanel1.add(row5Button);

		JButton row6Button = new JButton("COLUMN 6");
		row6Button.addActionListener(this);
		southPanel1.add(row6Button);

		JButton row7Button = new JButton("COLUMN 7");
		row7Button.addActionListener(this);
		southPanel1.add(row7Button);

		//SOUTH ROW2
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(this);
		southPanel2.add(startButton);

		JButton resetButton = new JButton("Reset Board");
		resetButton.addActionListener(this);
		southPanel2.add(resetButton);

		add(pSouth, BorderLayout.SOUTH);


		//
		//
		//EAST PANEL
		pEast.setLayout(new GridLayout(2, 1));
		JPanel westPanel1 = new JPanel();
		JPanel westPanel2 = new JPanel();
		pEast.add(westPanel1);
		pEast.add(westPanel2);

		JButton readyp2Button = new JButton("P2 Ready");
		readyp2Button.addActionListener(this);
		westPanel1.add(readyp2Button);

		String p2Lbl = "P2 Score";
		westPanel2.add(new JLabel(p2Lbl));
		p2Txt.setEditable(false);
		westPanel2.add(p2Txt);
		p2Txt.setText(String.valueOf(boardMech.getPlayer2Score()));
		p2Txt.setColumns(4);

		add(pEast, BorderLayout.EAST);

		//
		//
		//WEST PANEL
		pWest.setLayout(new GridLayout(2, 1));
		JPanel eastPanel1 = new JPanel();
		JPanel eastPanel2 = new JPanel();
		pWest.add(eastPanel1);
		pWest.add(eastPanel2);

		JButton readyp1Button = new JButton("P1 Ready");
		readyp1Button.addActionListener(this);
		eastPanel1.add(readyp1Button);

		String p1Lbl = "P1 Score";
		eastPanel2.add(new JLabel(p1Lbl));
		p1Txt.setEditable(false);
		p1Txt.setText(String.valueOf(boardMech.getPlayer1Score()));
		eastPanel2.add(p1Txt);
		p1Txt.setColumns(4);

		add(pWest, BorderLayout.WEST);

		//
		//TEXTAREA OUTPUT STREAMS
		PrintStream northPrintStream = new PrintStream(new CustomOutputStream(outputAreaNorth));
		standardOutputSteam = System.out;
		System.setOut(northPrintStream);
		System.setErr(northPrintStream);

		setVisible(true);
		
	}

	//
	//Set Player Markers
	public void setMarker() {
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow1(i)) {
			case 1:
				buttons[i+35].setP1Icon();
				break;
			case 2:
				buttons[i+35].setP2Icon();
				break;
			case 0:
				buttons[i+35].setIconNull();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow2(i)) {
			case 1:
				buttons[i+28].setP1Icon();
				break;
			case 2:
				buttons[i+28].setP2Icon();
				break;
			case 0:
				buttons[i+28].setIconNull();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow3(i)) {
			case 1:
				buttons[i+21].setP1Icon();
				break;
			case 2:
				buttons[i+21].setP2Icon();
				break;
			case 0:
				buttons[i+21].setIconNull();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow4(i)) {
			case 1:
				buttons[i+14].setP1Icon();
				break;
			case 2:
				buttons[i+14].setP2Icon();
				break;
			case 0:
				buttons[i+14].setIconNull();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow5(i)) {
			case 1:
				buttons[i+7].setP1Icon();
				break;
			case 2:
				buttons[i+7].setP2Icon();
				break;
			case 0:
				buttons[i+7].setIconNull();
				break;
			default:
				break;
			}
		}
		for (int i = 0; i < 7; i++) {
			switch(boardMech.getRow6(i)) {
			case 1:
				buttons[i].setP1Icon();
				break;
			case 2:
				buttons[i].setP2Icon();
				break;
			case 0:
				buttons[i].setIconNull();
				break;
			default:
				break;
			}
		}
	}

	public void playerMarker1(int i) {
		buttons[i].setP1Icon();
	}
	public void playerMarker2(int i) {
		buttons[i].setP2Icon();
	}


	
	//
	//Set PlayerScore
	public void setPlayerScore() {
		if(boardMech.isGameWon() == true) {
			p1Txt.setText(String.valueOf(boardMech.getPlayer1Score()));
			p2Txt.setText(String.valueOf(boardMech.getPlayer2Score()));
		}else {
			;
		}
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		//
		//IMPLEMNT IF GAMESTARED
		//COLUMN 1 BUTTON
		if(buttonString.equals("COLUMN 1")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(0);
				setMarker();
				setPlayerScore();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 2 BUTTON
		}else if(buttonString.equals("COLUMN 2")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(1);
				setMarker();
				setPlayerScore();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 3 BUTTON
		}else if(buttonString.equals("COLUMN 3")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(2);
				setMarker();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 4 BUTTON
		}else if(buttonString.equals("COLUMN 4")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(3);
				setMarker();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 5 BUTTON
		}else if(buttonString.equals("COLUMN 5")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(4);
				setMarker();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 6 BUTTON
		}else if(buttonString.equals("COLUMN 6")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(5);
				setMarker();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//COLUMN 7 BUTTON
		}else if(buttonString.equals("COLUMN 7")) {
			if(boardMech.getGameStartStatus() == true) {
				boardMech.playerTurn(6);
				setMarker();
			}else if(boardMech.getGameStartStatus() == false) {
				System.out.println("Game has not started yet.");
			}else {
				System.out.println("Unexpected Error");
			}

			//
			//START BUTTON
		}else if(buttonString.equals("Start Game")) {
			if (boardMech.getGameStartStatus() == false) {
				boardMech.startGame();
			}else if (boardMech.getGameStartStatus() == true) {
				System.out.println("Game has already started.");
			}else {
				System.out.println("Unexpected Error");
			}


			//
			//RESET BUTTON
		}else if(buttonString.equals("Reset Board")) {
			
			boardMech.resetGame();
			boardMech.setGameStatus();
			boardMech.setP1Ready();
			boardMech.setP2Ready();
			for(int i=0;i<42;i++){
				buttons[i].setIconNull();
			}
			try {
				outputAreaNorth.getDocument().remove(0,
						outputAreaNorth.getDocument().getLength());
				standardOutputSteam.println("Text area cleared");
			} catch (BadLocationException ex) {
				ex.printStackTrace();
			}
			outputAreaNorth.setText("Ready up to start the game!");
			//
			//P1 READY BUTTON
		}else if(buttonString.equals("P1 Ready")) {
			boardMech.setPlayer1Ready();


			//
			//P2 READY BUTTON
		}else if(buttonString.equals("P2 Ready")) {
			boardMech.setPlayer2Ready();

			//
			//ERRORS
		}else {
			System.out.println("Unexpected error.");
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}


}
