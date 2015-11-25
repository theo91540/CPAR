package TD3;

import java.rmi.*;
import java.rmi.registry.*;

public class P3Client  extends Thread
{
	private P1I p1;
	private P2I p2;
	private P3I p3;

	public P3Client(P1I p1, P2I p2, P3I p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public void run()
	{
		System.out.println("Lancement du protocole");

		try 
		{	
			p1.isJobDoneA();

			Thread.sleep(5000);
			p1.B();
			p1.jobDoneB();
			p2.isJobDoneG();

			Thread.sleep(5000);
			p1.C();
			p1.jobDoneC();
			p3.isJobDoneF();
		}
		catch (Exception e) 
		{
			System.out.println("Une exception est intervenue: " + e);
		}

		System.out.println("Fin du protocole");
	}
} 
