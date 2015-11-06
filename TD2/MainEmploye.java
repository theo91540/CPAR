import java.io.IOException;
import java.net.UnknownHostException;

public class MainEmploye
{
	public static void main (String[] args) throws UnknownHostException, IOException
	{
		SynchSocket CH = new SynchSocket("localhost", 9000);
		System.out.println("E: connecté a l'hopital");
		SynchSocket CT = new SynchSocket("localhost", 8001);
		System.out.println("E: connecté au travail");

		new Employe(CH, CT).start();
		System.out.println("E: Début de traitement");
	}
}
