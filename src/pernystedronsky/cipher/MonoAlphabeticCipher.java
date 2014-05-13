package pernystedronsky.cipher;

/**
 * 
 * @author Stedronsky Thomas
 * @version 2014-04-06
 */
public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;
	
	/**
	 * Konstruktor
	 */
	public MonoAlphabeticCipher() {
		secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	/**
	 * Getter Methode für das Geheimalphabet
	 * @return secretAlphabet Das Geheimalphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet; 
	}
	
	/**
	 * Setter Methode für das Geheimalphabet
	 * @param secretAlphabetneues secretAlphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) throws IllegalArgumentException{
		if(secretAlphabet.length()==30){ //Es wird geprüft ob das neue secretAlphabet die entsprechende Anzahl an Zeichen besitzt.
			this.secretAlphabet=secretAlphabet;
		}
		else {
			throw new IllegalArgumentException("Fehler beim setzen des SecretAlphabets");
		}
	}
	

	/**
	 * Die Methode verschlüsselt einen Text mit dem zugehörigen secretAlphabet.
	 * @param  text	Text
	 * @return verText		verschlüsselter Text
	 */
	@Override
	public String encrypt(String text) {
		String alphabet="abcdefghijklmnopqrstuvwxyzäöüß";
		String verText="";
		String t = text.toLowerCase();
		for(int i=0; i<t.length(); ++i){
			char b=t.charAt(i); 
			int index= alphabet.indexOf(b);  //Stelle am Alphabet wird geprüft
			if(index>=0){ 
				verText+=this.secretAlphabet.charAt(index); //An der Stelle des indizes wird der Buchstabe zurückgegeben.
			}
			else {
				verText+=b; //Wenn nicht enthalten einfach der gleich Buchstabe
			}
		}
		return verText;
		
	}
	
	/**
	 * Die Methode entschlüsselt einen Text mit dem zugehörigen secretAlphabet
	 * @param verText	verschlüsselter Text
	 * @return entText	entschlüsselter Text
	 */
	@Override
	public String decrypt(String verText) {
		String alphabet="abcdefghijklmnopqrstuvwxyzäöüß";
		String entText="";
		String t= verText.toLowerCase();
		for(int i=0; i<t.length(); ++i){
			char b=t.charAt(i);
			int index= this.secretAlphabet.indexOf(b); //Stelle am SecretAlphabet wird geprüft
			if(index>=0){ 
				entText+=alphabet.charAt(index); //An der Stelle des indizes wird der Buchstabe zurückgegeben.
			}
			else {
				entText+=b; //Wenn nicht enthalten einfach der gleich Buchstabe
			}
		}
		return entText;
	}
}
