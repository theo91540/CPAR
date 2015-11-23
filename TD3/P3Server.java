package TD3;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class P3Server
{
	public static void main(String args[]) 
	{
		try 
		{
			
			// Creation du registre serveur
			Registry reg = LocateRegistry.createRegistry(1102);

			// Creation de l'objet distant
			P3I p3 = new P3Impl();

			// Mise a disposition de l'objet distant 
			reg.rebind("P3", p3);

			System.out.println("Server P3: ON !");
		} 
		catch (Exception e) 
		{
			System.out.println("Trouble: " + e);
		}
	}
} 
