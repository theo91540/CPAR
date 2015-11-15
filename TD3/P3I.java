package TD3;

import java.rmi.*;

public interface P3I extends Remote 
{
	public void E() throws RemoteException;
	public void F() throws RemoteException;
	public void isJobDoneE() throws RemoteException; 
	public void jobDoneE() throws RemoteException; 
	public void isJobDoneF() throws RemoteException; 
	public void jobDoneF() throws RemoteException; 
}