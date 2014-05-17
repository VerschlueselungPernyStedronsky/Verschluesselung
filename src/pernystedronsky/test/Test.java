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
	 * JUnit Test f�r MonoAlphabeticCipher()
	 */
	@org.junit.Test
	public void MonoAlphabeticCipher(){
		MonoAlphabeticCipher c= new MonoAlphabeticCipher();
	}

	/**
	 * JUnit Test f�r getSecretAlphabet() 
	 */
	@org.junit.Test
	public void getSecretAlphabet() {
		MonoAlphabeticCipher c= new MonoAlphabeticCipher();
		String x=c.getSecretAlphabet(); //Wird zur�ckgegeben
		if(x.equals("abcdefghijklmnopqrstuvwxyz����")){ //�berpr�ft
			System.out.println("Erfolgreich");
		}
	}

	/**
	 * JUnit Test f�r setSecretAlphabet()
	 */
	@org.junit.Test
	public void setSecretAlphabet() {
		SubstitutionCipher c1= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		try {
		c1.setSecretAlphabet("����zyxwvutsrfedcba"); //Gesetzt
		}
		catch(IllegalArgumentException e){ //Wenn fals wird eine Exception geworfen
			System.out.println("FAIL");
		}
	}

	/**
	 * JUnit Test f�r encrypt
	 */
	@org.junit.Test
	public void encrypt() {
		SubstitutionCipher c= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		c.setSecretAlphabet("����zyxwvutsrqponmlkjihgfedcba"); //Wird gesetzt 
		String verschl=c.encrypt("3BHIT"); //Verschl�sselt
		if(verschl.equals("3�wvk")){ //�berpr�ft 
			System.out.println("Erfolgreich");
		}
	}

	/**
	 * JUnit Test f�r decrypt
	 */
	@org.junit.Test
	public void decrypt() {
		SubstitutionCipher c= new SubstitutionCipher("abcdefghijklmnopqrstuvwxyz����");
		c.setSecretAlphabet("����zyxwvutsrqponmlkjihgfedcba"); //gesetzt
		String verschl=c.decrypt("3�wvk"); //Entschl�sselt
		if(verschl.equals("3bhit")){ //�berpr�ft
			System.out.println("Erfolgreich");
		}
	}
	
	/**
	 * JUnit Test f�r TranspositonCipher
	 */
	@org.junit.Test
	public void trans() {
		TranspositionCipher t= new TranspositionCipher(2);
		t.encrypt("Thomas");
		if(t.decrypt("TOAHMS").equals("THOMAS"))System.out.println("Transposition Erfolgreich");
	}
	
	/**
	 * JUnit Test f�r TranspositonCipher
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
	 * JUnit Test f�r ShiftCipher
	 */
	@org.junit.Test
	public void shift() {
		ShiftCipher s= new ShiftCipher(-1); //Um die else Bedindung zu checken
		ShiftCipher s1= new ShiftCipher(3); //Um die else Bedindung zu checken
		s1.encrypt("3BHIT");
		if(s1.decrypt("3eklw").equals("3bhit"))System.out.println("Shift Erfolgreich");
	}
	
	/**
	 * JUnit Test f�r KeyWordCipher
	 */
	@org.junit.Test
	public void key() {
		KeywordCipher s= new KeywordCipher("hallo"); 
		s.encrypt("3BHIT");
		if(s.decrypt("3aeft").equals("3bhit"))System.out.println("KeyWordCipher Erfolgreich");
	}
	
	/**
	 * JUnit Test f�r GUIController
	 */
	@org.junit.Test
	public void gui() {
		CipherGUIController c= new CipherGUIController();
	}
	
	/**
	 * JUnit Test f�r GUIController
	 */
	@org.junit.Test
	public void gui1() {
		CipherGUIController2 c= new CipherGUIController2();
	}
}
