package keygen;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import keygen.json.KeyReader;
import keygen.json.KeyWriter;

/**
 * Manages keys
 * @author John
 *
 */
public class KeyManager {
	
	private static final Logger logger = Logger.getLogger(KeyManager.class.getName());

	/** 
	 * Creating a new key instance
	 * @param in
	 */
	public void addKey(BufferedReader in) {
		Key key = new Key();
		try {
			key.setKey(Generator.GenerateKey());
			key.setPurchaser(in.readLine());
			key.setPurchaseDate(in.readLine());
			key.setPurchaseIP(in.readLine());
			key.setExpirationDate(in.readLine());
			key.setUse(in.readLine());
			key.setItemID(Integer.parseInt(in.readLine()));
			key.setMembershipLength(Integer.parseInt(in.readLine()));
			KeyWriter.writeKey(key);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Removes the key from the server for expiration/redemption etc
	 * @param key
	 */
	public void removeKey(String key) {
		if(KeyReader.keyExists(key)) {
			File f = new File(KeyReader.getKeyPath(key));
			f.delete();
		} else {
			logger.info("Tried to remove a non valid key.");
		}
	}
	
}
