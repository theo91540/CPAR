package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P1Server
{
	public static void main(String args[]) throws InterruptedException, RemoteException
	{
		String ip_p2 = "localhost";
		String ip_p3 = "localhost";

		if(args.length == 3)
		{
			ip_p2 = args[1];
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
		catch(Exception e)
		{
			System.out.println("Impossible d'accéder au registre");
		}

		p1 = new P1Impl();

		try
		{
			registry.rebind("P1", p1);
		}
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
			System.exit(0);
		}

		System.out.println("Serveur P1: Ok");

		boolean error = false;

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

		System.out.println("\nConnexion au partenaire 2 réussie.");

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

		P1Client client = new P1Client(p1, p2, p3);
		client.start();
	}
} 
