package TD3;

import java.rmi.*;

public interface P2I extends Remote 
{
	public void G() throws RemoteException;
	public void isJobDoneG() throws RemoteException; 
	public void jobDoneG() throws RemoteException; 
}