import java.rmi.*;

public interface Calculator extends Remote
{
	double add(double a, double b) throws RemoteException;
}
