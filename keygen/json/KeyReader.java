package keygen.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import keygen.Key;

import com.google.gson.Gson;

/**
 * Reads the key
 * @author John
 *
 */
public class KeyReader {
	
	private static Key keyObject;

	/**
	 * Static path to main key folder
	 */
	private static final String KEYGEN_PATH = "." + File.pathSeparator + "data"
			+ File.pathSeparator + "keys" + File.pathSeparator + "active"
			+ File.pathSeparator;

	/**
	 * Read informatiom from a key file
	 * @param key
	 * @return key exists and can be read
	 */
	public static boolean readKey(String key) {
		Gson gson = new Gson();
		try {
			if (!keyExists(key)) {
				return false;
			}
			File f = new File(getKeyPath(key));
			BufferedReader br = new BufferedReader(new FileReader(f));
			Key keyObject = gson.fromJson(br, Key.class);
			setKeyObject(keyObject);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Check if they key exists
	 * @param key
	 * @return key exists
	 */
	public static boolean keyExists(String key) {
		return getKeyPath(key) != null;
	}

	/**
	 * Make sure the file exists in a path before we try to read it.
	 * 
	 * @param key
	 * @return key file location or null
	 */
	public static String getKeyPath(String key) {
		if (new File(KEYGEN_PATH + File.pathSeparator + "item"
				+ File.pathSeparator + key + ".json").exists()) {
			return KEYGEN_PATH + File.pathSeparator + "item"
					+ File.pathSeparator + key + ".json";
		}
		if (new File(KEYGEN_PATH + File.pathSeparator + "membership"
				+ File.pathSeparator + key + ".json").exists()) {
			return KEYGEN_PATH + File.pathSeparator + "membership"
					+ File.pathSeparator + key + ".json";
		}
		return null;
	}

	public static Key getKeyObject() {
		return keyObject;
	}

	public static void setKeyObject(Key keyObject) {
		KeyReader.keyObject = keyObject;
	}
}