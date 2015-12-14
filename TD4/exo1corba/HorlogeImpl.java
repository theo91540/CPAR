package exo1corba;

public class HorlogeImpl extends HorlogePOA
{
	public String localite()
	{
		return "localite";
	}

	public String getTime()
	{
		return "time";
	}

	public String getTimeZone()
	{
		return "time_zone";
	}
}