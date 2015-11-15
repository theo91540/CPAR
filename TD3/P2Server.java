package TD3;

import java.rmi.Naming;

public class P2Server
{
	public static void main(String args[]) 
	{
		try 
		{
			P2I p2 = new P2Impl();
			Naming.rebind("rmi://localhost/P2", p2);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 