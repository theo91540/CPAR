package TD3;

import java.rmi.*;

public interface P1I extends Remote 
{
	public void A() throws RemoteException;
	public void B() throws RemoteException;
	public void C() throws RemoteException; 
	public void isJobDoneA() throws RemoteException; 
	public void jobDoneA() throws RemoteException; 
	public void isJobDoneB() throws RemoteException; 
	public void jobDoneB() throws RemoteException; 
	public void isJobDoneC() throws RemoteException; 
	public void jobDoneC() throws RemoteException; 
}