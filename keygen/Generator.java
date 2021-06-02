package keygen;

import java.security.SecureRandom;
import java.util.logging.Logger;

/**
 * Generator of a random key with set segments and character amounts
 * @author John
 *
 */
public class Generator {
	
	private static final Logger logger = Logger.getLogger(Generator.class.getName());

	/**
	 * The valid characters that the key can use.
	 */
	final static char[] VALID_CHARS = { '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	/**
	 * The amount of segments inside the key (Dashs + 1)
	 */
	private static final int SEGMENT_AMOUNT = 4;
	
	/**
	 * The amount of characters per segment
	 */
	private static final int CHARACTERS_PER_SEGMENT = 5;

	/**
	 * Generates a random key from set characters and shortens to remove last -
	 */
	public static String GenerateKey() {
		SecureRandom random = new SecureRandom();
		String key = "";
		while (key.length() < ((CHARACTERS_PER_SEGMENT * SEGMENT_AMOUNT) + CHARACTERS_PER_SEGMENT)) {
			for (int i = 0; i < CHARACTERS_PER_SEGMENT; i++) {
				key += (VALID_CHARS[random.nextInt((VALID_CHARS.length))]);
			}
			key += "-";
		}
		logger.info(key.substring(0, key.length() - 1));
		return key.substring(0, key.length() - 1);
	}

}
