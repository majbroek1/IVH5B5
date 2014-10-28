package Impl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Interface.FysioServiceIF;

public class Server {
	// Get a logger instance for the current class
	static Logger logger = Logger.getLogger(Server.class);

	public Server() throws RemoteException {
		logger.debug("Constructor");
		logger.debug("Done");
	}

	public static void main(String args[]) {

		String hostname = null;

		/*if (args.length != 1) {
			System.out.println("Usage: Server [hostname]");
			System.exit(1);
		} else {
			hostname = args[0];
		}*/
		hostname = "localhost";

		// Configure logging.
		PropertyConfigurator.configure("./resources/FysioServer.logconf");
		Settings.loadProperties("./resources/FysioServer.settings");
		
		logger.debug("Starting application ---------------------------------");

		System.setProperty("java.rmi.server.hostname", hostname);
		System.setProperty("java.rmi.server.codebase", "http://" + hostname
				+ "/classes/bin/");
		System.setProperty("java.security.policy", "http://" + hostname
				+ "/classes/resources/FysioServer.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
			logger.debug("SecurityManager installed");
		}

		try {
			logger.debug("Creating stub");
			FysioImpl obj = new FysioImpl();
			FysioServiceIF stub = (FysioServiceIF) UnicastRemoteObject
					.exportObject(obj, 0);

			logger.debug("Locating registry on host '" + hostname + "'");
			Registry registry = LocateRegistry.getRegistry(hostname);
			logger.debug("Trying to register stub using name '"
					+ FysioImpl.servicename + "'");
			registry.rebind(FysioServiceIF.servicename, stub);
			logger.debug("Stub registered");

			logger.info("Server ready");
		} catch (java.rmi.ConnectException e) {
			logger.error("Could not connect: " + e.getMessage());
		} catch (java.security.AccessControlException e) {
			logger.error("Could not access registry: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}