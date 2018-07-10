/*
 * Game Board Mechanics
 */

package edu.century.FinalProject;


public class BoardMechanic extends PlayerMechanics{

	private int[] row1;
	private int[] row2;
	private int[] row3;
	private int[] row4;
	private int[] row5;
	private int[] row6;
	private int playerTurn = 0;
	private Boolean currentGameWon = false;
	private Boolean gameStarted = false;
	public PlayerMechanics players = new PlayerMechanics();

	public BoardMechanic() {
	}

	public void printRow1() {
		System.out.println("Row 1: ");
		for (int i = 0; i < 7; i++) {
			System.out.println(row1[i]);
		}
	}
	public int getRow1(int i) {
		return row1[i];
	}
	public int getRow2(int i) {
		return row2[i];
	}
	public int getRow3(int i) {
		return row3[i];
	}
	public int getRow4(int i) {
		return row4[i];
	}
	public int getRow5(int i) {
		return row5[i];
	}
	public int getRow6(int i) {
		return row6[i];
	}




	public void setGameStatus() {
		this.gameStarted = false;
		this.currentGameWon = false;
	}

	public Boolean isGameWon() {
		return this.currentGameWon;
	}
	
	public Boolean getGameStartStatus() {
		return this.gameStarted;
	}
	//
	//StartGame
	public void startGame() {
		if (players.isPlayer1Ready() == true && players.isPlayer2Ready() == true) {
			System.out.println("Game Start!");
			gameStarted = true;
			this.row1 = new int[7];
			this.row2 = new int[7];
			this.row3 = new int[7];
			this.row4 = new int[7];
			this.row5 = new int[7];
			this.row6 = new int[7];
			playerTurn = 0;
			setPlayerTurn();
		}else {
			System.out.println("Both players need to be ready to start the game.");
		}

	}


	//
	//PlayerTurn
	public int getPlayerTurn() {
		return playerTurn;
	}

	//
	//Check if a spot has been taken
	public void playerTurn(int index) {
		if (gameStarted == false) {
			System.out.println("Game has not started.");
		}else if(currentGameWon == true) {
			System.out.println("Game is over start a new game to play again.");
		}else if (gameStarted == true) {
			if(row1[index] == 0) {
				this.row1[index] = this.playerTurn;
				System.out.println("Player " + playerTurn + " put a piece on row 1 column " + ++index + ".");
				checkWin(playerTurn);
			}else if(row1[index] != 0) {
				if(row2[index] == 0) {
					this.row2[index] = this.playerTurn;
					System.out.println("Player " + playerTurn + " put a piece on row 2 column " + ++index + ".");
					checkWin(playerTurn);
				}else if(row2[index] != 0) {
					if(row3[index] == 0) {
						this.row3[index] = this.playerTurn;
						System.out.println("Player " + playerTurn + " put a piece on row 3 column " + ++index + ".");
						checkWin(playerTurn);
					}else if(row3[index] != 0) {
						if(row4[index] == 0) {
							this.row4[index] = this.playerTurn;
							System.out.println("Player " + playerTurn + " put a piece on row 4 column " + ++index + ".");
							checkWin(playerTurn);
						}else if(row4[index] != 0) {
							if(row5[index] == 0) {
								this.row5[index] = this.playerTurn;
								System.out.println("Player " + playerTurn + " put a piece on row 5 column " + ++index + ".");
								checkWin(playerTurn);
							}else if(row5[index] != 0) {
								if(row6[index] == 0) {
									this.row6[index] = this.playerTurn;
									System.out.println("Player " + playerTurn + " put a piece on row 6 column " + ++index + ".");
									checkWin(playerTurn);
								}else if(row6[index] != 0) {
									System.out.println("Cannot choose this column.");
								}
							}
						}
					}
				}
			}
		}
	}

	public void setPlayerTurn() {
		switch(this.playerTurn) {
		case 0:
			this.playerTurn = 1;
			System.out.println("Player " + getPlayerTurn() + "'s turn.");
			break;
		case 1:
			this.playerTurn = 2;
			System.out.println("Player " + getPlayerTurn() + "'s turn.");
			break;
		case 2:
			this.playerTurn = 1;
			System.out.println("Player " + getPlayerTurn() + "'s turn.");
			break;
		}
	}

	public void resetTurn() {
		this.playerTurn = 0;
		setPlayerTurn();
	}

	//
	//All the possibilities if winning
	public void checkWin(int playerTurn) {
		if(this.currentGameWon == false) {
			//Column 1 POSSIBILITIES
			//Vertical
			if (row1[0] == playerTurn && row2[0] == playerTurn && row3[0] == playerTurn && row4[0] == playerTurn) {
				win();
			}else if (row2[0] == playerTurn && row3[0] == playerTurn && row4[0] == playerTurn && row5[0] == playerTurn) {
				win();
			}else if (row3[0] == playerTurn && row4[0] == playerTurn && row5[0] == playerTurn && row6[0] == playerTurn) {
				win();
				//horizontal
			}else if (row1[0] == playerTurn && row1[1] == playerTurn && row1[2] == playerTurn && row1[3] == playerTurn) {
				win();
			}else if (row2[0] == playerTurn && row2[1] == playerTurn && row2[2] == playerTurn && row2[3] == playerTurn) {
				win();
			}else if (row3[0] == playerTurn && row3[1] == playerTurn && row3[2] == playerTurn && row3[3] == playerTurn) {
				win();
			}else if (row4[0] == playerTurn && row4[1] == playerTurn && row4[2] == playerTurn && row4[3] == playerTurn) {
				win();
			}else if (row5[0] == playerTurn && row5[1] == playerTurn && row5[2] == playerTurn && row5[3] == playerTurn) {
				win();
			}else if (row6[0] == playerTurn && row6[1] == playerTurn && row6[2] == playerTurn && row6[3] == playerTurn) {
				win();
				//Diagonal
			}else if (row1[0] == playerTurn && row2[1] == playerTurn && row3[2] == playerTurn && row4[3] == playerTurn) {
				win();
			}else if (row2[0] == playerTurn && row3[1] == playerTurn && row4[2] == playerTurn && row5[3] == playerTurn) {
				win();
			}else if (row3[0] == playerTurn && row4[1] == playerTurn && row5[2] == playerTurn && row6[3] == playerTurn) {
				win();
			}else if (row4[0] == playerTurn && row3[1] == playerTurn && row2[2] == playerTurn && row1[3] == playerTurn) {
				win();
			}else if (row5[0] == playerTurn && row4[1] == playerTurn && row3[2] == playerTurn && row2[3] == playerTurn) {
				win();
			}else if (row6[0] == playerTurn && row5[1] == playerTurn && row4[2] == playerTurn && row3[3] == playerTurn) {
				win();

				//Column 2
				//Vertical
			}else if (row1[1] == playerTurn && row2[1] == playerTurn && row3[1] == playerTurn && row4[1] == playerTurn) {
				win();
			}else if (row2[1] == playerTurn && row3[1] == playerTurn && row4[1] == playerTurn && row5[1] == playerTurn) {
				win();
			}else if (row3[1] == playerTurn && row4[1] == playerTurn && row5[1] == playerTurn && row6[1] == playerTurn) {
				win();
				//horizontal
			}else if (row1[1] == playerTurn && row1[2] == playerTurn && row1[3] == playerTurn && row1[4] == playerTurn) {
				win();
			}else if (row2[1] == playerTurn && row2[2] == playerTurn && row2[3] == playerTurn && row2[4] == playerTurn) {
				win();
			}else if (row3[1] == playerTurn && row3[2] == playerTurn && row3[3] == playerTurn && row3[4] == playerTurn) {
				win();
			}else if (row4[1] == playerTurn && row4[2] == playerTurn && row4[3] == playerTurn && row4[4] == playerTurn) {
				win();
			}else if (row5[1] == playerTurn && row5[2] == playerTurn && row5[3] == playerTurn && row5[4] == playerTurn) {
				win();
			}else if (row6[1] == playerTurn && row6[2] == playerTurn && row6[3] == playerTurn && row6[4] == playerTurn) {
				win();
				//Diagonal
			}else if (row1[1] == playerTurn && row2[2] == playerTurn && row3[3] == playerTurn && row4[4] == playerTurn) {
				win();
			}else if (row2[1] == playerTurn && row3[2] == playerTurn && row4[3] == playerTurn && row5[4] == playerTurn) {
				win();
			}else if (row3[1] == playerTurn && row4[2] == playerTurn && row5[3] == playerTurn && row6[4] == playerTurn) {
				win();
			}else if (row4[1] == playerTurn && row3[2] == playerTurn && row2[3] == playerTurn && row1[4] == playerTurn) {
				win();
			}else if (row5[1] == playerTurn && row4[2] == playerTurn && row3[3] == playerTurn && row2[4] == playerTurn) {
				win();
			}else if (row6[1] == playerTurn && row5[2] == playerTurn && row4[3] == playerTurn && row3[4] == playerTurn) {
				win();

				//Column 3
				//Vertical
			}else if (row1[2] == playerTurn && row2[2] == playerTurn && row3[2] == playerTurn && row4[2] == playerTurn) {
				win();
			}else if (row2[2] == playerTurn && row3[2] == playerTurn && row4[2] == playerTurn && row5[2] == playerTurn) {
				win();
			}else if (row3[2] == playerTurn && row4[2] == playerTurn && row5[2] == playerTurn && row6[2] == playerTurn) {
				win();
				//horizontal
			}else if (row1[2] == playerTurn && row1[3] == playerTurn && row1[4] == playerTurn && row1[5] == playerTurn) {
				win();
			}else if (row2[2] == playerTurn && row2[3] == playerTurn && row2[4] == playerTurn && row2[5] == playerTurn) {
				win();
			}else if (row3[2] == playerTurn && row3[3] == playerTurn && row3[4] == playerTurn && row3[5] == playerTurn) {
				win();
			}else if (row4[2] == playerTurn && row4[3] == playerTurn && row4[4] == playerTurn && row4[5] == playerTurn) {
				win();
			}else if (row5[2] == playerTurn && row5[3] == playerTurn && row5[4] == playerTurn && row5[5] == playerTurn) {
				win();
			}else if (row6[2] == playerTurn && row6[3] == playerTurn && row6[4] == playerTurn && row6[5] == playerTurn) {
				win();
				//Diagonal
			}else if (row1[2] == playerTurn && row2[3] == playerTurn && row3[4] == playerTurn && row4[5] == playerTurn) {
				win();
			}else if (row2[2] == playerTurn && row3[3] == playerTurn && row4[4] == playerTurn && row5[5] == playerTurn) {
				win();
			}else if (row3[2] == playerTurn && row4[3] == playerTurn && row5[4] == playerTurn && row6[5] == playerTurn) {
				win();
			}else if (row4[2] == playerTurn && row3[3] == playerTurn && row2[4] == playerTurn && row1[5] == playerTurn) {
				win();
			}else if (row5[2] == playerTurn && row4[3] == playerTurn && row3[4] == playerTurn && row2[5] == playerTurn) {
				win();
			}else if (row6[2] == playerTurn && row5[3] == playerTurn && row4[4] == playerTurn && row3[5] == playerTurn) {
				win();

				//Column 4
				//Vertical
			}else if (row1[3] == playerTurn && row2[3] == playerTurn && row3[3] == playerTurn && row4[3] == playerTurn) {
				win();
			}else if (row2[3] == playerTurn && row3[3] == playerTurn && row4[3] == playerTurn && row5[3] == playerTurn) {
				win();
			}else if (row3[3] == playerTurn && row4[3] == playerTurn && row5[3] == playerTurn && row6[3] == playerTurn) {
				win();
				//horizontal
			}else if (row1[3] == playerTurn && row1[4] == playerTurn && row1[5] == playerTurn && row1[6] == playerTurn) {
				win();
			}else if (row2[3] == playerTurn && row2[4] == playerTurn && row2[5] == playerTurn && row2[6] == playerTurn) {
				win();
			}else if (row3[3] == playerTurn && row3[4] == playerTurn && row3[5] == playerTurn && row3[6] == playerTurn) {
				win();
			}else if (row4[3] == playerTurn && row4[4] == playerTurn && row4[5] == playerTurn && row4[6] == playerTurn) {
				win();
			}else if (row5[3] == playerTurn && row5[4] == playerTurn && row5[5] == playerTurn && row5[6] == playerTurn) {
				win();
			}else if (row6[3] == playerTurn && row6[4] == playerTurn && row6[5] == playerTurn && row6[6] == playerTurn) {
				win();
				//Diagonal
			}else if (row1[3] == playerTurn && row2[4] == playerTurn && row3[5] == playerTurn && row4[6] == playerTurn) {
				win();
			}else if (row2[3] == playerTurn && row3[4] == playerTurn && row4[5] == playerTurn && row5[6] == playerTurn) {
				win();
			}else if (row3[3] == playerTurn && row4[4] == playerTurn && row5[5] == playerTurn && row6[6] == playerTurn) {
				win();
			}else if (row4[3] == playerTurn && row3[4] == playerTurn && row2[5] == playerTurn && row1[6] == playerTurn) {
				win();
			}else if (row5[3] == playerTurn && row4[4] == playerTurn && row3[5] == playerTurn && row2[6] == playerTurn) {
				win();
			}else if (row6[3] == playerTurn && row5[4] == playerTurn && row4[5] == playerTurn && row3[6] == playerTurn) {
				win();

				//Column 5
				//Vertical
			}else if (row1[4] == playerTurn && row2[4] == playerTurn && row3[4] == playerTurn && row4[4] == playerTurn) {
				win();
			}else if (row2[4] == playerTurn && row3[4] == playerTurn && row4[4] == playerTurn && row5[4] == playerTurn) {
				win();
			}else if (row3[4] == playerTurn && row4[4] == playerTurn && row5[4] == playerTurn && row6[4] == playerTurn) {
				win();

				//Column 6
				//Vertical
			}else if (row1[5] == playerTurn && row2[5] == playerTurn && row3[5] == playerTurn && row4[5] == playerTurn) {
				win();
			}else if (row2[5] == playerTurn && row3[5] == playerTurn && row4[5] == playerTurn && row5[5] == playerTurn) {
				win();
			}else if (row3[5] == playerTurn && row4[5] == playerTurn && row5[5] == playerTurn && row6[5] == playerTurn) {
				win();

				//Column 7
				//Vertical
			}else if (row1[6] == playerTurn && row2[6] == playerTurn && row3[6] == playerTurn && row4[6] == playerTurn) {
				win();
			}else if (row2[6] == playerTurn && row3[6] == playerTurn && row4[6] == playerTurn && row5[6] == playerTurn) {
				win();
			}else if (row3[6] == playerTurn && row4[6] == playerTurn && row5[6] == playerTurn && row6[6] == playerTurn) {
				win();

			}else {
				setPlayerTurn();
			}
		} else if(this.currentGameWon == true) {
			String gameWon = "Current game is over start a new one to play again.";
			System.out.println(gameWon);
		} else {
			System.out.println("Unexpected Error");
		}
	}



	//
	//WIN
	public void win() {
		setScore();
		this.currentGameWon = true;
		System.out.print("Player " + playerTurn + " wins!\n" );
		System.out.println("Reset the board and ready up to play again." );
	}


	//
	//Score

	public void setScore() {
		if(this.playerTurn == 1) {
			players.setPlayer1Score(getPlayer1Score()+1);
		}else if(this.playerTurn == 2) {
			players.setPlayer2Score(getPlayer2Score()+1);
		}
	}



	//
	//Reset game to play again.
	public void resetGame() {
		int[] newArray;
		newArray = new int[] {0,0,0,0,0,0,0};
		this.row1 = newArray;
		this.row2 = newArray;
		this.row3 = newArray;
		this.row4 = newArray;
		this.row5 = newArray;
		this.row6 = newArray;
	}


	//
	//
	//Override&Overload Methods

	//Player1
	public int getPlayer1Score() {
		return players.getPlayer1Score();
	}
	public boolean isPlayer1Ready() {
		return players.isPlayer1Ready();
	}
	public void setPlayer1Ready() {
		if(players.isPlayer1Ready() == true) {
			System.out.println("Player 1 is already ready.");
		}else if (players.isPlayer1Ready() == false) {
			players.setPlayer1Ready(true);
			System.out.println("Player 1 Ready!");
		}else {
			System.out.println("Unexpected Error");
		}
	}
	public void setP1Ready() {
		players.setPlayer1Ready(false);
	}
	//Player2
	public int getPlayer2Score() {
		return players.getPlayer2Score();
	}
	public boolean isPlayer2Ready() {
		return players.isPlayer2Ready();
	}
	public void setPlayer2Ready() {
		if(players.isPlayer2Ready() == true) {
			System.out.println("Player 2 is already ready.");
		}else if (players.isPlayer2Ready() == false) {
			players.setPlayer2Ready(true);
			System.out.println("Player 2 Ready!");
		}else {
			System.out.println("Unexpected Error");
		}
	}
	public void setP2Ready() {
		players.setPlayer2Ready(false);
	}


}
