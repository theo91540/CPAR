package TD3;

import java.rmi.*;
import java.rmi.registry.*;

public class P2Client 
{
	public static void main(String[] args)
	{
		try 
		{
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1100);
			P1I p1 = (P1I) reg.lookup("P1");
			P2I p2 = (P2I) reg.lookup("P2");
			P3I p3 = (P3I) reg.lookup("P3");

			p1.A();
			p1.jobDoneA();
			p1.isJobDoneB();
			p3.E();
			p3.jobDoneE();
			p1.isJobDoneC();
			p3.F();

		}
		catch (Exception e) 
		{
			System.out.println("Exception : " + e);
		}
	}
} 
