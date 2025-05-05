import java.rmi.*;

public interface circleinterface extends Remote {

	public double perimeter(int radius) throws RemoteException;

	public double area(int radius) throws RemoteException;

}
