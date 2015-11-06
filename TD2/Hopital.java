import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

public class Hopital extends Thread 
{
	private SynchSocket CH;
	private SynchSocket CA;

	public Hopital(SynchSocket CH, SynchSocket CA)
	{
		this.CH = CH;
		this.CA = CA;
	}

	public void run() 
	{
		Random r = new Random();
		Vector<String> messages = new Vector<String>();

		try 
		{
			messages.add("demandeRdzVs");
			CH.receiveMessage(messages);
			System.out.println("H : Demande de rdv reçu.");
			messages.clear();
			CH.sendMessage("code");
			System.out.println("H : Code hopital envoyé à l'employé.");
			messages.add("typeMedecin");
			CH.receiveMessage(messages);
			System.out.println("H : Type de médecin reçu.");
			messages.clear();
			CA.sendMessage("code");
			System.out.println("H : Code de l'hopital envoyé au travail.");
			CA.sendMessage("demandePlages");
			System.out.println("H : Demande de plages libres envoyé.");
			messages.add("plagesLibres");
			CA.receiveMessage(messages);
			System.out.println("H : Plages libres reçu.");
			messages.clear();
			
			if((r.nextInt())%2==0)
			{
				CH.sendMessage("heureDateRdzVs");
				System.out.println("H : Heure date rdv envoyé.");
			}			
			else
			{
				CH.sendMessage("pasPossible");	
				System.out.println("H : Rdv pas possible envoyé.");
			}
			
			System.out.println("H : Fin de traitement");
		} 
		catch (IOException | InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
