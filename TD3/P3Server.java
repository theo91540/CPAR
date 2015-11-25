package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P3Server
{
	public static void main(String args[]) throws InterruptedException, RemoteException
	{
		String ip_p1 = "localhost";
		String ip_p2 = "localhost";

		if(args.length == 3)
		{
			ip_p1 = args[1];
			ip_p2 = args[2];
		}

		P1I p1 = null;
		P2I p2 = null;
		P3I p3 = null;

		Registry registry = null;
		try 
		{	
			registry = LocateRegistry.getRegistry(1099);
		} 
		catch(RemoteException re)
		{
			registry = LocateRegistry.createRegistry(1099);
		}
		
		try
		{
			p3 = new P3Impl();
			registry.rebind("P3", p3);
		}
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
			System.exit(0);
		}

		System.out.println("Serveur P3: Ok");

		boolean error = false;
		
		System.out.print("Connexion au partenaire 1.");

		do
		{
			error = false;
			try
			{
				Registry reg3 = LocateRegistry.getRegistry(ip_p1, 1099);
				p1 = (P1I) reg3.lookup("P1");
			}	
			catch (Exception e)
			{
				error = true;
				System.out.print(".");
				Thread.sleep(2000);
			} 

		} while(error);

		System.out.println("\nConnection au partenaire 1 réussie.");

		System.out.print("Connexion au partenaire 2.");

		do
		{
			error = false;
			try
			{
				Registry reg2 = LocateRegistry.getRegistry(ip_p2, 1099);
				p2 = (P2I) reg2.lookup("P2");
			}	
			catch (Exception e)
			{
				error = true;
				System.out.print(".");
				Thread.sleep(2000);
			} 

		} while(error);

		System.out.println("\nConnection au partenaire 2 réussie.");

		P3Client client = new P3Client(p1, p2, p3);
		client.start();
	}
} 
