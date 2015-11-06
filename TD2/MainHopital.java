import java.io.IOException;
import java.net.UnknownHostException;

public class MainHopital
{
	public static void main(String[] args) 
	{
		try 
		{
			SynchServerSocket ch_server = new SynchServerSocket(9000);

			while(true)
			{
				SynchSocket CH = ch_server.accept();
				System.out.println("H: employé connecté");
				SynchSocket CA = new SynchSocket("localhost", 8000);
				System.out.println("H: connecté au travail");
				
				new Hopital(CH, CA).start();
				System.out.println("H: Début de traitement");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
