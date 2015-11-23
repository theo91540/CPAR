import java.rmi.*;
import java.rmi.registry.*;

public class CalculatorClient
{

	public static void main(String[] args) throws RemoteException, NotBoundException
	{
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1100);
		Calculator cal = (Calculator) reg.lookup("Calculator");
		System.out.println("It Works : " + cal.add(5,4));		
	}	
}
		
