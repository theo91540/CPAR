package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P2Server
{
	public static void main(String args[]) 
	{
		try 
		{
			// Creation du registre serveur
			Registry reg = LocateRegistry.createRegistry(1101);

			// Creation de l'objet distant
			P2I p2 = new P2Impl();

			// Mise a disposition de l'objet distant 
			reg.rebind("P2", p2);

			System.out.println("Server P2: ON !");
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
