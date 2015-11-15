package TD3;

import java.rmi.Naming;

public class P3Client 
{
	public static void main(String[] args)
	{
		try 
		{
			P1I p1 = (P1I) Naming.lookup("rmi://localhost/P1");
			P2I p2 = (P2I) Naming.lookup("rmi://localhost/P2");
			P3I p3 = (P3I) Naming.lookup("rmi://localhost/P3");

			p1.isJobDoneA();
			p1.B();
			p1.jobDoneB();
			p2.isJobDoneG();
			p1.C();
			p1.jobDoneC();
			p3.isJobDoneF();
		}
		catch (Exception e) 
		{
			System.out.println("Exception : " + e);
		}
	}
} 