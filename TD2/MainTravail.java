import java.io.IOException;
import java.net.UnknownHostException;

public class MainTravail 
{
	public static void main(String[] args)
	{
		try 
		{
			SynchServerSocket ct_server = new SynchServerSocket(8001);
			SynchServerSocket ca_server = new SynchServerSocket(8000);

			while (true) 
			{
				SynchSocket CT = ct_server.accept();
				System.out.println("T: employé connecté");

				SynchSocket CA = ca_server.accept();
				System.out.println("T: hopital connecté");

				new Travail(CT, CA).start();
				System.out.println("T: Début de traitement");
			}

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
