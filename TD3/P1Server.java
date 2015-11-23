package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P1Server
{
	public static void main(String args[]) 
	{
		try 
		{
			Registry reg = LocateRegistry.createRegistry(1100);
			P1I p1 = new P1Impl();
			reg.rebind("P1", p1);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
