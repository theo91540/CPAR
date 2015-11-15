package TD3;

import java.rmi.Naming;

public class P1Client
{
	public static void main(String[] args)
	{
		try 
		{
			P1I p1 = (P1I) Naming.lookup("rmi://localhost/P1");
			P2I p2 = (P2I) Naming.lookup("rmi://localhost/P2");
			P3I p3 = (P3I) Naming.lookup("rmi://localhost/P3");

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