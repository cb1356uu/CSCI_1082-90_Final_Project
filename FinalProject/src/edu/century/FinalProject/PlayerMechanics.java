/*
 * Player Data Storage
 */

package edu.century.FinalProject;

public class PlayerMechanics{


	private boolean player1Ready = false;
	private int player1Score = 0;
	private boolean player2Ready = false;
	private int player2Score = 0;
	
	public int getPlayer1Score() {
		return player1Score;
	}

	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}

	public boolean isPlayer1Ready() {
		return player1Ready;
	}

	public void setPlayer1Ready(boolean player1Ready) {
		this.player1Ready = player1Ready;
	}
	
	public int getPlayer2Score() {
		return player2Score;
	}

	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}

	public boolean isPlayer2Ready() {
		return player2Ready;
	}

	public void setPlayer2Ready(boolean player2Ready) {
		this.player2Ready = player2Ready;
	}
}
