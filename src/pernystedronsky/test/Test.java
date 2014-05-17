package pernystedronsky.test;

import static org.junit.Assert.*;
import pernystedronsky.cipher.KeywordCipher;
import pernystedronsky.cipher.MonoAlphabeticCipher;
import pernystedronsky.cipher.ShiftCipher;
import pernystedronsky.cipher.SubstitutionCipher;
import pernystedronsky.cipher.TranspositionCipher;
import pernystedronsky.gui.CipherGUIController;
import pernystedronsky.gui.CipherGUIController2;


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
	
	/**
	 * JUnit Test für TranspositonCipher
	 */
	@org.junit.Test
	public void trans() {
		TranspositionCipher t= new TranspositionCipher(2);
		t.encrypt("Thomas");
		if(t.decrypt("TOAHMS").equals("THOMAS"))System.out.println("Transposition Erfolgreich");
	}
	
	/**
	 * JUnit Test für TranspositonCipher
	 */
	@org.junit.Test
	public void trans1() {
		TranspositionCipher t= new TranspositionCipher(-1); //Um die else Bedindung zu checken
		t.setTranspositionLevel(-1); //Um die else Bedindung zu checken
		t.setTranspositionLevel(4);
		t.encrypt("Thomas"); 
		if(t.decrypt("TAHSOM").equals("THOMAS"))System.out.println("Transposition Erfolgreich1");
	}
	
	/**
	 * JUnit Test für ShiftCipher
	 */
	@org.junit.Test
	public void shift() {
		ShiftCipher s= new ShiftCipher(-1); //Um die else Bedindung zu checken
		ShiftCipher s1= new ShiftCipher(3); //Um die else Bedindung zu checken
		s1.encrypt("3BHIT");
		if(s1.decrypt("3eklw").equals("3bhit"))System.out.println("Shift Erfolgreich");
	}
	
	/**
	 * JUnit Test für KeyWordCipher
	 */
	@org.junit.Test
	public void key() {
		KeywordCipher s= new KeywordCipher("hallo"); 
		s.encrypt("3BHIT");
		if(s.decrypt("3aeft").equals("3bhit"))System.out.println("KeyWordCipher Erfolgreich");
	}
	
	/**
	 * JUnit Test für GUIController
	 */
	@org.junit.Test
	public void gui() {
		CipherGUIController c= new CipherGUIController();
	}
	
	/**
	 * JUnit Test für GUIController
	 */
	@org.junit.Test
	public void gui1() {
		CipherGUIController2 c= new CipherGUIController2();
	}
}
