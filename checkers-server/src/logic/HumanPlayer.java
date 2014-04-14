package logic;

import java.rmi.RemoteException;

import checkersApi.User;

public class HumanPlayer extends Player {

	private User user;
	
	String colorString = "";

	public HumanPlayer(Color color, User user) {
		super(color);
		this.user = user;
		
		if (color == Color.BLACK) {
			colorString = "czarne";
		} else {
			colorString = "białe";
		}
	}

	@Override
	public void notifyMeAboutStart(Chessboard startingChessboard) {
		try {
			user.onGameStateChanged("Rozpoczecie gry. Ruch białego gracza.\n" + startingChessboard.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void sendMeNewGameState(Chessboard newState) {
		try {
			user.onGameStateChanged(newState.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void notifyMeAboutMyMove() {
		try {
			user.onGameStateChanged("Twój ruch (" + colorString + ") (składnia: \"skąd_x skąd_y dokąd_x dokąd_y\")");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void didIWon(boolean did) {
		try {
			if (did) {
				user.onGameStateChanged("Gratulacje, wygrałeś");
			} else {
				user.onGameStateChanged("Przegrałeś");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
