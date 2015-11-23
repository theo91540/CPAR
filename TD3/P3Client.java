package TD3;

import java.rmi.*;
import java.rmi.registry.*;

public class P3Client 
{
	public static void main(String[] args)
	{
		try 
		{	
			// Recuperation du registre
			Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1100);
			
			// Recuperation des objets distants
			P1I p1 = (P1I) reg.lookup("P1");
			P2I p2 = (P2I) reg.lookup("P2");
			P3I p3 = (P3I) reg.lookup("P3");

			// Debut du protocole
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
