package exo1corba;

/**
* exo1corba/HorlogeHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from contrat.idl
* lundi 14 décembre 2015 09 h 34 CET
*/

public final class HorlogeHolder implements org.omg.CORBA.portable.Streamable
{
  public exo1corba.Horloge value = null;

  public HorlogeHolder ()
  {
  }

  public HorlogeHolder (exo1corba.Horloge initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = exo1corba.HorlogeHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    exo1corba.HorlogeHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return exo1corba.HorlogeHelper.type ();
  }

}
