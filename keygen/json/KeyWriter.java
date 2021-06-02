package keygen.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import keygen.Key;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Writes the keys
 * @author John
 *
 */
public class KeyWriter {
	
	/**
	 * Static path to main key folder
	 */
	private static final String KEYGEN_PATH = "."+File.pathSeparator+"data"+File.pathSeparator+"keys"
			+File.pathSeparator+"active"+File.pathSeparator;

	/**
	 * Writes the key information to keyfile.json - static due to laziness
	 * @param key
	 * @param use
	 */
	public static void writeKey(Key key) {
		try {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();		
			String json = gson.toJson(key);
			FileWriter file = new FileWriter(getFilePath(key.getKey(),key.getUse()));
			file.write(json);
			file.flush();
			file.close();	 
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Error in creating key save.");
		} 
	}
	
	/**
	 * Returns path to generated key file
	 * @param key
	 * @param use
	 * @return file path
	 */
	private static String getFilePath(String key, String use) {
		return KEYGEN_PATH+File.pathSeparator+use+File.pathSeparator+key+".json";
	}
	
}