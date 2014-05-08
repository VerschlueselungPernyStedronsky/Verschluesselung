package pernystedronsky.cipher;

/**
 * Interface zum ent- und verschlüüseln
 * @author Stedronsky Thomas
 * @version 2014-04-07
 *
 */
public interface Cipher {
	
	/**
	 * Die Methode verschlüsselt einen Text mit dem zugehörigen secretAlphabet.
	 * @param  text			Text
	 * @return verText		verschlüsselter Text
	 */
	public String encrypt(String text);
	
	/**
	 * Die Methode entschlüsselt einen Text mit dem zugehörigen secretAlphabet
	 * @param verText	verschlüsselter Text
	 * @return entText	entschlüsselter Text
	 */
	public String decrypt(String verText);
}
