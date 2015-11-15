package TD3;

import java.rmi.Naming;

public class P1Server
{
	public static void main(String args[]) 
	{
		try 
		{
			P1I p1 = new P1Impl();
			Naming.rebind("rmi://localhost/P1", p1);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 