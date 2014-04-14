package checkersApi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {
	
	public UserToken playVsBot(User user) throws RemoteException;
	
	public UserToken playVsPlayer(User user) throws RemoteException;
	
	public boolean tryToMakeMove(UserToken userToken, int fromX, int fromY, int toX, int toY) throws RemoteException;
	
	public boolean gameEnded(UserToken token) throws RemoteException;
	
}
