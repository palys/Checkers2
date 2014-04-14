package logic;

import checkersApi.Game;
import checkersApi.UserToken;


public class Bot extends Player {
	
	Game game;
	
	Chessboard currentChessboardState = null;
	
	UserToken token;

	public Bot(Color color, Game game, UserToken token) {
		super(color);
		this.game = game;
		this.token = token;
	}

	@Override
	public void notifyMeAboutStart(Chessboard startingChessboard) {
		currentChessboardState = startingChessboard;
		
	}

	@Override
	public void sendMeNewGameState(Chessboard newState) {
		currentChessboardState = newState;
		
	}

	@Override
	public void notifyMeAboutMyMove() {
		makeMove();
		
	}

	@Override
	public void didIWon(boolean did) {
		// TODO Auto-generated method stub
		
	}
	
	private void makeMove() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				for (int dx = -2; dx <= 2; dx ++) {
					for (int dy = -2; dy <= -1; dy ++) {
						try {
							Move move = Move.newMove(i, j, i + dx, j + dy);
							if (currentChessboardState.isMoveValid(move)) {
								game.tryToMakeMove(token, i, j, i + dx, j + dy);
							}
						} catch(Exception e) {
							
						}
					}
				}
			}
		}
	}

}
