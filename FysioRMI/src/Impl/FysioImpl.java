package Impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Interface.FysioServiceIF;
import fysioSysteem.dataStorage.BehandelingDAO;
import fysioSysteem.domain.Behandeling;

public class FysioImpl implements FysioServiceIF{
	
	public String test() throws RemoteException{
		return "Alive!!!";
	}
	
	public ArrayList<Behandeling> getBehandelingen(String bsn){
		return BehandelingDAO.getBehandelingen(bsn);
	}
}
