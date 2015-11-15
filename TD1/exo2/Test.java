import java.util.*;

public class Test
{
	public static void main(String[] args)
	{
		final int NB_PHILOSOPHE = 3;

		JTupleSpace table = new JTupleSpace();

		for(int i=0; i<NB_PHILOSOPHE; i++)
		{
			Vector v = new Vector();
			v.add(i);
			table.ECR(v);
		}	

		for(int i=0; i<NB_PHILOSOPHE; i++)
			(new Philosophe(table)).start();
		
	}
}