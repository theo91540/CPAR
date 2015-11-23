package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P3Server
{
	public static void main(String args[]) 
	{
		try 
		{
			Registry reg = LocateRegistry.createRegistry(1100);
			P3I p3 = new P3Impl();
			reg.rebind("P3", p3);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
