package exo1corba;

import java.util.Properties;
import org.omg.CORBA.*;

public class ClientSansContext
{
	public static void main(String[] args)
	{
		Properties props = new Properties();

		props.put("org.omg.CORBA.ORBInitialHost", "localhost");

		props.put("org.omg.CORBA.ORBInitialPort", "8989");

		ORB orb = ORB.init(args, props);

		try
		{
			org.omg.CORBA.Object o = orb.string_to_object(args[0]);
			Horloge h = HorlogeHelper.narrow(o);
			System.out.println(o.getClass().getName());
			System.out.println(h.getTime());
			System.out.println(h.getTimeZone());
			System.out.println(h.localite());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}