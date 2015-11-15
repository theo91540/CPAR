import java.util.*;

public class JTupleSpace
{
	HashSet contenu = new HashSet();

	public synchronized Vector EXT(Vector v)
	{
		Vector res = match(v);
		
		while(res == null)
		{
			try 
			{
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		
			res = match(v);
		}
		
		contenu.remove(res);
		return res;
	}

	public synchronized Vector LEC(Vector v)
	{
		Vector res = match(v);
		
		while(res == null)
		{
			try 
			{
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		
			res = match(v);
		}

		return res;
	}

	public synchronized void ECR(Vector v)
	{
		contenu.add(v);
		notifyAll();
	}

	public Vector match(Vector template)
	{
		Iterator it = contenu.iterator();
		Vector res = null;
		while(it.hasNext() && res==null)
		{
			Vector v = (Vector) it.next();
			if(v.size() == template.size())
			{
				res = v;
				for(int i=0; i<template.size(); i++)
				{
					if(template.get(i)!=null && !v.get(i).equals(template.get(i)))
					{
						res = null;
						break;
					}
				}
			}
		}

		return res;
	}
}
