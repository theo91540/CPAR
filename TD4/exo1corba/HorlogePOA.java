package exo1corba;


/**
* exo1corba/HorlogePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from contrat.idl
* lundi 14 décembre 2015 09 h 34 CET
*/

public abstract class HorlogePOA extends org.omg.PortableServer.Servant
 implements exo1corba.HorlogeOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_localite", new java.lang.Integer (0));
    _methods.put ("getTime", new java.lang.Integer (1));
    _methods.put ("getTimeZone", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // exo1corba/Horloge/_get_localite
       {
         String $result = null;
         $result = this.localite ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // exo1corba/Horloge/getTime
       {
         String $result = null;
         $result = this.getTime ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // exo1corba/Horloge/getTimeZone
       {
         String $result = null;
         $result = this.getTimeZone ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:exo1corba/Horloge:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Horloge _this() 
  {
    return HorlogeHelper.narrow(
    super._this_object());
  }

  public Horloge _this(org.omg.CORBA.ORB orb) 
  {
    return HorlogeHelper.narrow(
    super._this_object(orb));
  }


} // class HorlogePOA