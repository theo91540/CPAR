package exo1corba;


/**
* exo1corba/HorlogeHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from contrat.idl
* lundi 14 décembre 2015 09 h 34 CET
*/

abstract public class HorlogeHelper
{
  private static String  _id = "IDL:exo1corba/Horloge:1.0";

  public static void insert (org.omg.CORBA.Any a, exo1corba.Horloge that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static exo1corba.Horloge extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (exo1corba.HorlogeHelper.id (), "Horloge");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static exo1corba.Horloge read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HorlogeStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, exo1corba.Horloge value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static exo1corba.Horloge narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof exo1corba.Horloge)
      return (exo1corba.Horloge)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      exo1corba._HorlogeStub stub = new exo1corba._HorlogeStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static exo1corba.Horloge unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof exo1corba.Horloge)
      return (exo1corba.Horloge)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      exo1corba._HorlogeStub stub = new exo1corba._HorlogeStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
