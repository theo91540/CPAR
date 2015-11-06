import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SynchServerSocket extends ServerSocket
{

	public SynchServerSocket() throws IOException 
	{
		super();
	}

	public SynchServerSocket(int a, int p) throws IOException 
	{
		super(a, p);
	}

	public SynchServerSocket(int a) throws IOException 
	{
		super(a);
	}

	public SynchSocket accept() throws IOException 
	{
		return new SynchSocket(super.accept());
	}
}