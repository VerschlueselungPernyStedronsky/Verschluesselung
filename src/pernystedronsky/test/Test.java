package pernystedronsky.test;

import static org.junit.Assert.*;
import pernystedronsky.cipher.MonoAlphabeticCipher;
import pernystedronsky.cipher.SubstitutionCipher;


/**
 * JUnit Test-Klasse
 * @author Stedronsky Thomas
 * @version 2014-04-07
 *
 */
public class Test {

	/**
	 * JUnit Test für MonoAlphabeticCipher()
	 */
	@org.junit.Test
	public void MonoAlphabeticCipher(){
		MonoAlphabeticCipher c= new MonoAlphabeticCipher();
	}

	/**
	 * JUnit Test für getSecretAlphabet() 
	 */
	@org.junit.Test
	public void getSecretAlphabet() {
		MonoAlphabeticCipher c= new MonoAlphabeticCipher();
		String x=c.getSecretAlphabet(); //Wird zurückgegeben
		if(x.equals("abcdefghijklmnopqrstuvwxyzäöüß")){ //Überprüft
			System.out.println("Erfolgreich");
		}
	}

	/**
	 * JUnit Test für setSecretAlphabet()
	 */
	@org.junit.Test
	public void setSecretAlphabet() {
		SubstitutionCipher c1= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		try {
		c1.setSecretAlphabet("ßüöäzyxwvutsrfedcba"); //Gesetzt
		}
		catch(IllegalArgumentException e){ //Wenn fals wird eine Exception geworfen
			System.out.println("FAIL");
		}
	}

	/**
	 * JUnit Test für encrypt
	 */
	@org.junit.Test
	public void encrypt() {
		SubstitutionCipher c= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba"); //Wird gesetzt 
		String verschl=c.encrypt("3BHIT"); //Verschlüsselt
		if(verschl.equals("3üwvk")){ //Überprüft 
			System.out.println("Erfolgreich");
		}
	}

	/**
	 * JUnit Test für decrypt
	 */
	@org.junit.Test
	public void decrypt() {
		SubstitutionCipher c= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba"); //gesetzt
		String verschl=c.decrypt("3üwvk"); //Entschlüsselt
		if(verschl.equals("3bhit")){ //Überprüft
			System.out.println("Erfolgreich");
		}
	}

}
