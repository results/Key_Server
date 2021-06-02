import server.Constants;
import server.TCPServer;

/**
 *  Main class - so hard
 * @author John
 *
 */
public class Main {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TCPServer server = new TCPServer(Constants.PORT);
	}
}
