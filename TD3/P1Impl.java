package TD3;

import java.rmi.*;
import java.rmi.server.*;

public class P1Impl extends UnicastRemoteObject implements P1I
{
	private boolean doneA = false;
	private boolean doneB = false;
	private boolean doneC = false;

	public P1Impl() throws RemoteException
	{ 
		super();
	}

	public void A() throws RemoteException
	{
		System.out.println("Invocation de la méthode A");
	}

	public void B() throws RemoteException
	{
		System.out.println("Invocation de la méthode B");
	}

	public void C() throws RemoteException
	{
		System.out.println("Invocation de la méthode C");
	}	
	
	synchronized public void jobDoneA()
	{
		doneA = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneA()
	{
		if(!doneA)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}
	} 

	synchronized public void jobDoneB()
	{
		doneB = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneB()
	{
		if(!doneB)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}
	} 

	synchronized public void jobDoneC()
	{
		doneC = true;
		this.notifyAll();
	}

	synchronized public void isJobDoneC()
	{
		if(!doneC)
			try{ wait();} catch (InterruptedException e) {e.printStackTrace();}
	} 
}