package logic;

import java.io.Serializable;

public abstract class Player implements Serializable {
	
	protected Color color;

	public Player(Color color) {
		this.color = color;
	}
	
	Color getColor() {
		return this.color;
	}
	
	public abstract void notifyMeAboutStart(Chessboard startingChessboard);
	
	public abstract void sendMeNewGameState(Chessboard newState);
	
	public abstract void notifyMeAboutMyMove();
	
	public abstract void didIWon(boolean did);
	
}
