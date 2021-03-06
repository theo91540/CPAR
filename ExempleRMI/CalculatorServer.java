import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class CalculatorServer extends UnicastRemoteObject implements Calculator
{
	public CalculatorServer() throws RemoteException
	{
		super();
	}

	public static void main(String[] args) throws RemoteException
	{
		Registry reg = LocateRegistry.createRegistry(1100);
		Calculator cal = new CalculatorServer();
		reg.rebind("Calculator", cal);
		System.out.println("Server On !");
	}

	public double add(double arg0, double arg1) throws RemoteException
	{
		return arg0 + arg1;
	}
}
