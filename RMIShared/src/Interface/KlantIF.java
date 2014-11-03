package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import shared.Klant;

/**
 * @author Pieter
 *
 */
public interface KlantIF extends Remote {
	
	public static final String servicename = "KlantService";
	
    /**
     * @return
     * @throws RemoteException
     */
    String sayHello() throws RemoteException;
    
    public Klant getKlant(String bsn) throws RemoteException;
    
    public ArrayList<Klant> getKlanten() throws RemoteException;
}
