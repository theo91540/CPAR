package TD3;

import java.rmi.*;
import java.rmi.server.*;

public class P2Impl extends UnicastRemoteObject implements P2I
{
	private boolean doneG;

	public P2Impl() throws RemoteException
	{ 
		super();
		this.doneG = false;
	}

	public void G() throws RemoteException
	{
		System.out.println("Invocation de la méthode G");
	}

	synchronized public void jobDoneG()
	{
		doneG = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneG()
	{
		if(!doneG)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}

		this.notifyAll();
	} 
}
