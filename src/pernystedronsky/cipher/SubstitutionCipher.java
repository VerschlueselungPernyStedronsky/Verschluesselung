package pernystedronsky.cipher;

/**
 * erweiterte Klasse zu MonoAlphabeticCipher
 * @author Stedronsky Thomas
 * @version 20914-04-07
 *
 */
public class SubstitutionCipher extends MonoAlphabeticCipher {

	/**
	 * Kontruktor
	 * @param secretAlphabet Geheimalphabet
	 */
	public SubstitutionCipher(String secretAlphabet) {
		super(); //Super Konstruktor
		super.setSecretAlphabet(secretAlphabet); //Methode ändert das Secret Alphabet
	}

	/**
	 * Setter Methode für das Geheimalphabet
	 * @param secretAlphabetneues secretAlphabet
	 */
	@Override
	public void setSecretAlphabet(String secretAlphabet) {	
		//Methode wird von MonoAlphabeticCipheraufgerufen.
		super.setSecretAlphabet(secretAlphabet); 
	}
}
