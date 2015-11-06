import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

public class SynchSocket extends Socket 
{
	private Socket s;
	private BufferedReader in;
	private PrintWriter out;

	public SynchSocket(Socket s) throws IOException 
	{
		this.s = s;
		this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		this.out = new PrintWriter(s.getOutputStream());
	}
	
	public SynchSocket(String IP, int port) throws UnknownHostException, IOException
	{
		this(new Socket(IP, port));
	}

	public synchronized void sendMessage(String mess) throws IOException, InterruptedException 
	{
		boolean rep = false;
		String receipt = "";
		
		while (!rep) 
		{
			out.println(mess);
			out.flush();

			receipt = in.readLine();
			
			if(receipt.equals("OK " + mess)) 
			{
				out.println(receipt);
				out.flush();
				rep = true;
			} 
			else
			{
				out.println("Echec envoi");
				out.flush();
			}
		}

	}

	public synchronized String receiveMessage(Vector<String> messages) throws IOException, InterruptedException 
	{
		boolean rep = false;
		String receipt = null;
		
		while (!rep) 
		{
			receipt = in.readLine();
			rep = messages.contains(receipt);
		}

		out.println("OK " + receipt);
		out.flush();

		return receipt;
	}
}
