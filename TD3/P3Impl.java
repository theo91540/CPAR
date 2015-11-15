package TD3;

import java.rmi.*;
import java.rmi.server.*;

public class P3Impl extends UnicastRemoteObject implements P3I
{
	private boolean doneE = false;
	private boolean doneF = false;

	public P3Impl() throws RemoteException
	{ 
		super();
	}

	public void E() throws RemoteException
	{
		System.out.println("Invocation de la méthode E");
	}

	public void F() throws RemoteException
	{
		System.out.println("Invocation de la méthode F");
	}

	synchronized public void jobDoneE()
	{
		doneE = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneE()
	{
		if(!doneE)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}
	} 

	synchronized public void jobDoneF()
	{
		doneF = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneF()
	{
		if(!doneF)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}
	} 
}