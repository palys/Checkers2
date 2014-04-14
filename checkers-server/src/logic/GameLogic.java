package logic;

import checkersApi.Game;
import checkersApi.UserToken;


public class GameLogic {
	
	Player[] players = new Player[2];
	
	Chessboard board = null;
	
	Bot bot = null;
	
	private GameLogic(int size, Player player) {
		players[0] = player;
		board = Chessboard.startingChessboard(size);
	}
	public static GameLogic vsPlayer(int size, Player player) {
	
		return new GameLogic(size, player);
	}
	
	public static GameLogic vsBot(int size, Player player, Game game, UserToken token) {
		GameLogic gameLogic = new GameLogic(size, player);
		gameLogic.bot = new Bot(Color.BLACK, game, token);
		gameLogic.join(gameLogic.bot);		
		return gameLogic;
	}
	
	public Bot getBot() {
		return bot;
	}
	
	private void notifyPlayersAboutStart() {
		for (Player p : players) {
			p.notifyMeAboutStart(board);
		}
	}
	
	public boolean join(Player player) {
		if (players[1] == null) {
			players[1] = player;
			notifyPlayersAboutStart();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean doMove(Move move, Player player) {
		if (!board.isMoveValid(move)) {
			return false;
		}
		
		if (!(player.getColor() == board.getCurrentPlayerColor())) {
			return false;
		}
		
		board.doMove(move);
		
		for (Player p : players) {
			p.sendMeNewGameState(board);
		}
		return true;
	}
	public boolean gameEnded() {
		return board.getState() == GameState.BLACK_WON || board.getState() == GameState.WHITE_WON;
	}
	
	public Color getWinner() {
		if (board.getState() == GameState.BLACK_WON) {
			return Color.BLACK;
		} else if (board.getState() == GameState.WHITE_WON) {
			return Color.WHITE;
		} else {
			return null;
		}
	}
	
}