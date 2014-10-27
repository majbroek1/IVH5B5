package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FysioServiceIF extends Remote{
	public static final String servicename = "FysioService";
	
	String test() throws RemoteException;
}
