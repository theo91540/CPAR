package exo1corba;

import java.util.Properties;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class Server
{
	public static void main(String[] args)
	{
		HorlogeImpl h = new HorlogeImpl();

		Properties props = new Properties();

		props.put("org.omg.CORBA.ORBInitialHost", "localhost");

		props.put("org.omg.CORBA.ORBInitialPort", "8989");

		ORB orb = ORB.init(args, props);

		try
		{
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			byte[] id = rootPOA.activate_object(h);

			org.omg.CORBA.Object ref = rootPOA.id_to_reference(id);
			
			System.out.println(orb.object_to_string(ref));
			
			rootPOA.the_POAManager().activate();

			orb.run();
			
			/*
			org.omg.CORBA.Object o = orb.resolve_initial_references("NameService");

			NamingContextExt context = NamingContextExtHelper.narrow(o);

			System.out.println(orb.object_to_string(o));

			NameComponent[] name = context.to_name("hhh");
			context.rebind(name, ref);
			*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}