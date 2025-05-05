import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import SimpleString.*;
public class StringOperationServer
{
    public static void main(String args[])
    {
        try
        {
            ORB orb=ORB.init(args,null);
            StringOperationImpl stringOperationImpl = new StringOperationImpl();
            orb.connect(stringOperationImpl);

            org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
            NamingContext ncRef=NamingContextHelper.narrow(objRef);

            NameComponent nc=new NameComponent("NASDAQ","");
            NameComponent path[]={nc};
            
            ncRef.rebind(path,stringOperationImpl);

            System.out.println("Server is ready");
            Thread.currentThread().join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}