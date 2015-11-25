package TD3;

import java.rmi.*;
import java.rmi.registry.*;

public class P2Client extends Thread
{
	private P1I p1;
	private P2I p2;
	private P3I p3;

	public P2Client(P1I p1, P2I p2, P3I p3)
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
			Thread.sleep(5000);
			p1.A();
			p1.jobDoneA();
			p1.isJobDoneB();

			Thread.sleep(5000);
			p3.E();
			p3.jobDoneE();
			p1.isJobDoneC();

			Thread.sleep(5000);
			p3.F();
			p3.jobDoneF();

		}
		catch (Exception e) 
		{
			System.out.println("Une exception est intervenue: " + e);
		}

		System.out.println("Fin du protocole");
	}
} 
