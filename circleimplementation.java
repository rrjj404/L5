import java.rmi.*;
import java.rmi.server.*;

public class circleimplementation extends UnicastRemoteObject implements circleinterface {
    public circleimplementation() throws RemoteException {
        super();
    }

    public double area(int radius) throws RemoteException {
        return 3.14 * radius * radius;
    }

    public double perimeter(int radius) throws RemoteException {
        return 2 * 3.14 * radius;
    }
}