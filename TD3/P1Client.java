package TD3;

import java.rmi.*;
import java.rmi.registry.*;

public class P1Client
{
	public static void main(String[] args)
	{
		try 
		{
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1100);
			P1I p1 = (P1I) reg.lookup("P1");

			Registry reg2 = LocateRegistry.getRegistry("127.0.0.1", 1101);
			P2I p2 = (P2I) reg2.lookup("P2");

			Registry reg3 = LocateRegistry.getRegistry("127.0.0.1", 1102);
			P3I p3 = (P3I) reg3.lookup("P3");

			// Debut du protocole
			p3.isJobDoneE();
			p2.G();	
			p2.jobDoneG();
			p3.isJobDoneF();
		}
		catch (Exception e) 
		{
			System.out.println("Exception : " + e);
		}
	}
} 
