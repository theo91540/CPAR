import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

public class Employe extends Thread 
{
	private SynchSocket CH;
	private SynchSocket CT;

	public Employe(SynchSocket CH, SynchSocket CT) 
	{
		this.CH = CH;
		this.CT = CT;
	}

	public void run() 
	{
		Vector<String> messages = new Vector<String>();

		try 
		{
			CH.sendMessage("demandeRdzVs");
			System.out.println("E : Envoie demande de rdv.");
			messages.add("code");
			CH.receiveMessage(messages);
			System.out.println("E : Code H reçu.");
			CH.sendMessage("typeMedecin");
			System.out.println("E : Envoie type médecin.");
			CT.sendMessage("autorisation");
			System.out.println("E : Envoie demande autorisation.");
			CT.sendMessage("code");
			System.out.println("E : Envoie code T.");
			messages.removeAllElements();
			messages.add("heureDateRdzVs");
			messages.add("pasPossible");
			String res = CH.receiveMessage(messages);
			
			if(res.equals("heureDateRdzVs"))
				System.out.println("E : heureDateRdzVs H reçu.");
			else
				System.out.println("E : pas possible H reçu.");		

			System.out.println("E : Fin de traitement");
		} 
		catch (IOException | InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
