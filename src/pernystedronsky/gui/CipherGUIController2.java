package pernystedronsky.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import pernystedronsky.cipher.*;

/**
 * Controller der die Funktion der GUi steuert.
 * @author Stedronsky Thomas
 *
 */ 
public class CipherGUIController2 implements ActionListener{
	private CipherGUI2 g;
	/**
	 * Konstruktor
	 * @author Stedronsky Thomas
	 */
	public CipherGUIController2() {
		this.g=new CipherGUI2(this);
	}

	/**
	 * Methode die auf den Klick auf einen Button reagiert.
	 * @param ActionEvent(gedrückter button)
	 * @author Stedronsky Thomas
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		//Die if's bestimmen welche Klasse aufgerufen wird 
		if(command.equals("Mono")){
			this.Mono(command);
		}
		else if(command.equals("Key")){
			this.Key(command);
		}
		else if(command.equals("Shift")){
			this.Shift(command);
		}
		else if(command.equals("Sub")){
			this.Sub(command);
		}
		else if(command.equals("Trans")){
			this.Trans(command);
		}
	}

	/**
	 * Methode die den TranspositionCipher steuert.
	 * @param command ActionCommand des Button
	 * @author Stedronsky Thomas
	 */
	public void Trans(String command) {
		String text="";
		String att="";
		String endtext="";
		int stage=0;
		//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
		text=g.getTextField(0);
		att=g.getTextField(1);
		stage=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
		TranspositionCipher t= new TranspositionCipher(stage);
		if(g.getItem()==0){
			endtext=t.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(g.getItem()==1){
			endtext=t.decrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}
	}

	/**
	 * Methode die den SubstitutionCipher steuert
	 * @param command ActionCommand
	 * @author Stedronsky Thomas
	 */
	public void Sub(String command) {
		String text="";
		String att="";
		String endtext="";
		//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
		text=g.getTextField(0);
		att=g.getTextField(1);
		SubstitutionCipher s= new SubstitutionCipher(att);
		if(g.getItem()==0){
			endtext=s.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(g.getItem()==1){
			endtext=s.decrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

	}
	
	
	/**
	 * Methode die den ShiftCipher Steuert
	 * @param command ActioCommand
	 * @author Perny Tobias
	 */
	public void Shift(String command) {
		String text="";
		String att="";
		text=g.getTextField(0);
		att=g.getTextField(1);
		int versch=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
		String endtext="";
		ShiftCipher s= new ShiftCipher(versch);
		if(g.getItem()==0){
			endtext=s.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(g.getItem()==1){
			endtext=s.decrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

	}

	/**
	 * Methode die den KeywordCipher Steuert
	 * @param command ActioCommand
	 * @author Perny Tobias
	 */
	public void Key(String command) {
		String text="";
		String att="";
		String endtext="";
		//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
		text=g.getTextField(0);
		att=g.getTextField(1);
		KeywordCipher k= new KeywordCipher(att);
		if(g.getItem()==0){
			endtext=k.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}
		if(g.getItem()==1){
			endtext=k.decrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}
		

	}

	/**
	 * Methode die den MonoAlpabethicCipher Steuert
	 * @param command ActioCommand
	 * @author Stedronsky Thomas
	 */
	public void Mono(String command) {
		String text="";
		String att="";
		String endtext="";
		//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
		text=g.getTextField(0);
		att=g.getTextField(1);
		MonoAlphabeticCipher m= new MonoAlphabeticCipher();
		m.setSecretAlphabet(att);
		if(g.getItem()==0){
			endtext=m.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(g.getItem()==1){
			endtext=m.decrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

	}

}
