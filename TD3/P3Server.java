package TD3;

import java.rmi.Naming;

public class P3Server
{
	public static void main(String args[]) 
	{
		try 
		{
			P3I p3 = new P3Impl();
			Naming.rebind("rmi://localhost/P3", p3);
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 