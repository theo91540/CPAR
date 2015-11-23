package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P1Server
{
	public static void main(String args[]) 
	{
		try 
		{	
			// Creation du registre serveur
			Registry reg = LocateRegistry.createRegistry(1100);

			// Creation de l'objet distant
			P1I p1 = new P1Impl();

			// Mise a disposition de l'objet distant 
			reg.rebind("P1", p1);

			System.out.println("Server P1: ON !");
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
