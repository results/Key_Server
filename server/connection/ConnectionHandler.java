package server.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Logger;

import server.Constants;
import keygen.KeyManager;

/**
 * Handles connections for TCP server
 * @author John
 *
 */
public class ConnectionHandler implements Runnable {

	private static final Logger logger = Logger.getLogger(ConnectionHandler.class.getName());

	private Socket client;

	public ConnectionHandler(Socket client) {
		this.setClient(client);
	}

	/**
	 * Listens for connections and requests, rejects invalid hosts and responds to key requests
	 */
	public void run() {
		try {
			for (String acceptedHosts : Constants.ACCEPTED_HOSTS) {
				if (!client.getInetAddress().equals(InetAddress.getByName(acceptedHosts))) {
					logger.info("Connection rejected from: " + client.getInetAddress());
					return;
				} else {
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					KeyManager keys = new KeyManager();
					keys.addKey(in);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

}