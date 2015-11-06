import java.util.Vector;
import java.io.IOException;

public class Travail extends Thread
{
	private SynchSocket CT;
	private SynchSocket CA;
	
	public Travail(SynchSocket CT, SynchSocket CA)
	{
		this.CT = CT;
		this.CA = CA;
	}
	
	public void run()
	{
		Vector<String> message = new Vector<String>();

		try
		{
			message.add("autorisation");
			CT.receiveMessage(message);
			System.out.println("T : Autorisation reçu.");
			message.clear();
			message.add("code");
			CT.receiveMessage(message);
			System.out.println("T : Code employé reçu.");
			message.clear();
			message.add("code");
			CA.receiveMessage(message);
			System.out.println("T : Code hopital reçu.");
			message.clear();
			message.add("demandePlages");
			CA.receiveMessage(message);
			System.out.println("T : Demande de plages horaires reçu.");
			//tau(calcul)
			CA.sendMessage("plagesLibres");
			System.out.println("T : Envoie des plages libres.");

			System.out.println("T : Fin de traitement");
		}
		catch (IOException | InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
