package Impl;

import java.rmi.RemoteException;

import Interface.FysioServiceIF;

public class FysioImpl implements FysioServiceIF{
	
	public String test() throws RemoteException{
		return "Alive!!!";
	}
}
