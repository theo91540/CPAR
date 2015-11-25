package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P2Server
{
	public static void main(String args[]) throws InterruptedException, RemoteException
	{
		String ip_p1 = "localhost";
		String ip_p3 = "localhost";

		if(args.length == 3)
		{
			ip_p1 = args[1];
			ip_p3 = args[2];
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
			p2 = new P2Impl();
			registry.rebind("P2", p2);
		}
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
			System.exit(0);
		}

		System.out.println("Serveur P2: Ok");

		boolean error = false;

		System.out.print("Connexion au partenaire 1.");

		do
		{
			error = false;
			try
			{
				Registry reg2 = LocateRegistry.getRegistry(ip_p1, 1099);
				p1 = (P1I) reg2.lookup("P1");
			}	
			catch (Exception e)
			{
				error = true;
				System.out.print(".");
				Thread.sleep(2000);
			} 

		} while(error);

		System.out.println("\nConnection au partenaire 1 réussie.");

		System.out.print("Connexion au partenaire 3.");

		do
		{
			error = false;
			try
			{
				Registry reg3 = LocateRegistry.getRegistry(ip_p3, 1099);
				p3 = (P3I) reg3.lookup("P3");
			}	
			catch (Exception e)
			{
				error = true;
				System.out.print(".");
				Thread.sleep(2000);
			} 

		} while(error);

		System.out.println("\nConnexion au partenaire 3 réussie.");

		P2Client client = new P2Client(p1, p2, p3);
		client.start();
	}
} 
