package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P2Server
{
	public static void main(String args[]) 
	{
		try 
		{
			Registry reg = LocateRegistry.createRegistry(1100);
			P2I p2 = new P2Impl();
			reg.rebind("P2", p2);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
