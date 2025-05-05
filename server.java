import java.rmi.*;
import java.rmi.registry.*;

public class server {
    public static void main(String args[]) throws RemoteException {
        Registry reg = LocateRegistry.createRegistry(3000);
        circleimplementation ci = new circleimplementation();
        reg.rebind("circle", ci);
        System.out.println("SERVER IS WAITING...");
    }
}
