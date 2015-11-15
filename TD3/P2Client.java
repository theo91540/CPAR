package TD3;

import java.rmi.Naming;

public class P2Client 
{
	public static void main(String[] args)
	{
		try 
		{
			P1I p1 = (P1I) Naming.lookup("rmi://localhost/P1");
			P2I p2 = (P2I) Naming.lookup("rmi://localhost/P2");
			P3I p3 = (P3I) Naming.lookup("rmi://localhost/P3");

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