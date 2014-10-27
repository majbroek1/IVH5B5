package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import fysioSysteem.domain.Behandeling;

public interface FysioServiceIF extends Remote{
	public static final String servicename = "FysioService";
	
	String test() throws RemoteException;
	public ArrayList<Behandeling> getBehandelingen(String bsn) throws RemoteException;
}
