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
public class CipherGUIController implements ActionListener{
	private CipherGUI g;
	/**
	 * Konstruktor
	 * @author Stedronsky Thomas
	 */
	public CipherGUIController() {
		this.g=new CipherGUI(this);
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
		if(command.equals("encryptMono")||command.equals("decryptMono")){
			this.Mono(command);
		}
		else if(command.equals("encryptKey")||command.equals("decryptKey")){
			this.Key(command);
		}
		else if(command.equals("encryptShift")||command.equals("decryptShift")){
			this.Shift(command);
		}
		else if(command.equals("encryptSub")||command.equals("decryptSub")){
			this.Sub(command);
		}
		else if(command.equals("encryptTrans")||command.equals("decryptTrans")){
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
		if(command.equals("encryptTrans")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(0);
			att=g.getTextField(1);
			stage=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
			TranspositionCipher t= new TranspositionCipher(stage);
			endtext=t.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(command.equals("decryptTrans")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(2);
			att=g.getTextField(3);
			stage=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
			TranspositionCipher t= new TranspositionCipher(stage);
			endtext=t.decrypt(text);
			g.setTextField(2, endtext); //Das Ergebniss wird ins Textfeld geschrieben
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
		if(command.equals("encryptSub")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(0);
			att=g.getTextField(1);
			SubstitutionCipher s= new SubstitutionCipher(att);
			endtext=s.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(command.equals("decryptSub")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(2);
			att=g.getTextField(3);
			SubstitutionCipher s= new SubstitutionCipher(att);
			endtext=s.decrypt(text);
			g.setTextField(2, endtext); //Das Ergebniss wird ins Textfeld geschrieben
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
		String endtext="";
		int versch=0;
		if(command.equals("encryptShift")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(0);
			att=g.getTextField(1);
			versch=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
			ShiftCipher s= new ShiftCipher(versch);
			endtext=s.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(command.equals("decryptShift")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(2);
			att=g.getTextField(3);
			versch=Integer.parseInt(att); //Der String wert wird in eine Int umgewandelt
			ShiftCipher s= new ShiftCipher(versch);
			endtext=s.decrypt(text);
			g.setTextField(2, endtext); //Das Ergebniss wird ins Textfeld geschrieben
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
		if(command.equals("encryptKey")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(0);
			att=g.getTextField(1);
			KeywordCipher k= new KeywordCipher(att);
			endtext=k.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}
		if(command.equals("decryptKey")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(2);
			att=g.getTextField(3);
			KeywordCipher k= new KeywordCipher(att); 
			endtext=k.decrypt(text);
			g.setTextField(2, endtext); //Das Ergebniss wird ins Textfeld geschrieben
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
		if(command.equals("encryptMono")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(0);
			att=g.getTextField(1);
			MonoAlphabeticCipher m= new MonoAlphabeticCipher();
			m.setSecretAlphabet(att);
			endtext=m.encrypt(text);
			g.setTextField(0, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

		if(command.equals("decryptMono")){
			//Die Inhalte aus den Textfeldern werden mit der Methode getTextField geholt.
			text=g.getTextField(2);
			att=g.getTextField(3);
			MonoAlphabeticCipher m= new MonoAlphabeticCipher();
			m.setSecretAlphabet(att);
			endtext=m.decrypt(text);
			g.setTextField(2, endtext); //Das Ergebniss wird ins Textfeld geschrieben
		}

	}

}
