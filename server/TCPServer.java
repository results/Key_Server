package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import server.connection.ConnectionHandler;

/**
 * TCP server waiting for commands
 * @author John
 *
 */
public class TCPServer {

	private static final Logger logger = Logger.getLogger(TCPServer.class.getName());
	
	/**
	 * The main TCP server - Listens to php requests
	 * @param port
	 */
	public TCPServer(int port) {
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			logger.info("Server now listening on port " + port);
			while(true) {
				try {
					Socket client = server.accept();
					Thread thread = new Thread(new ConnectionHandler(client));
					thread.start();   
				} catch (IOException e) {
					e.printStackTrace();
					server.close();
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}