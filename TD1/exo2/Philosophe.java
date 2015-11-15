import java.util.*;

public class Philosophe extends Thread
{
	private static int nb_p = 0;
	private int num;
	private JTupleSpace jts;

	public Philosophe(JTupleSpace jts)
	{
		nb_p++;
		this.num = nb_p;
		this.jts = jts;
	}

	public synchronized void prendre_fourchettes()
	{
		Vector<Integer> v = new Vector();
		v.add((num-1)%nb_p);
		jts.EXT(v);
		System.out.println("Le Philosophe n°"+num+" prend la fourchette "+(num-1));

		
		Vector<Integer> v2 = new Vector();
		v2.add(num%nb_p);
		jts.EXT(v2);
		System.out.println("Le Philosophe n°"+num+" prend la fourchette "+(num%nb_p));
	}

	public synchronized void poser_fourchettes()
	{
		Vector<Integer> v = new Vector();
		v.add(num%nb_p);
		jts.ECR(v);
		System.out.println("Le Philosophe n°"+num+" pose la fourchette "+(num%nb_p));
		
		Vector<Integer> v2 = new Vector();
		v2.add(num-1);
		jts.ECR(v2);
		System.out.println("Le Philosophe n°"+num+" pose la fourchette "+(num-1));
	}

	public void run()
	{
		while(true)
		{
			Thread.sleep(Math.random() * 2000);
			prendre_fourchettes();
			Thread.sleep(Math.random() * 2000);
			poser_fourchettes();
			Thread.sleep(Math.random() * 2000);
		}
	}
}