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
			text=g.getTextField(0);
			att=g.getTextField(1);
			stage=Integer.parseInt(att);
			TranspositionCipher t= new TranspositionCipher(stage);
			endtext=t.encrypt(text);
			g.setTextField(0, endtext);
		}
		
		if(command.equals("decryptTrans")){
			text=g.getTextField(2);
			att=g.getTextField(3);
			stage=Integer.parseInt(att);
			TranspositionCipher t= new TranspositionCipher(stage);
			endtext=t.decrypt(text);
			g.setTextField(2, endtext);
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
			text=g.getTextField(0);
			att=g.getTextField(1);
			SubstitutionCipher s= new SubstitutionCipher(att);
			endtext=s.encrypt(text);
			g.setTextField(0, endtext);
		}
		
		if(command.equals("decryptSub")){
			text=g.getTextField(2);
			att=g.getTextField(3);
			SubstitutionCipher s= new SubstitutionCipher(att);
			endtext=s.decrypt(text);
			g.setTextField(2, endtext);
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
			text=g.getTextField(0);
			att=g.getTextField(1);
			versch=Integer.parseInt(att);
			ShiftCipher s= new ShiftCipher(versch);
			s.setSecretAlphabet(att);
			endtext=s.encrypt(text);
			g.setTextField(0, endtext);
		}

		if(command.equals("decryptShift")){
			text=g.getTextField(2);
			att=g.getTextField(3);
			versch=Integer.parseInt(att);
			ShiftCipher s= new ShiftCipher(versch);
			s.setSecretAlphabet(att);
			endtext=s.decrypt(text);
			g.setTextField(2, endtext);
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
			text=g.getTextField(0);
			att=g.getTextField(1);
			KeywordCipher k= new KeywordCipher(att);
			k.setSecretAlphabet(att);
			endtext=k.encrypt(text);
			g.setTextField(0, endtext);
		}
		if(command.equals("decryptKey")){
			text=g.getTextField(2);
			att=g.getTextField(3);
			KeywordCipher k= new KeywordCipher(att);
			k.setSecretAlphabet(att);
			endtext=k.decrypt(text);
			g.setTextField(2, endtext);
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
			text=g.getTextField(0);
			att=g.getTextField(1);
			MonoAlphabeticCipher m= new MonoAlphabeticCipher();
			m.setSecretAlphabet(att);
			endtext=m.encrypt(text);
			g.setTextField(0, endtext);
		}
		
		if(command.equals("decryptMono")){
			text=g.getTextField(2);
			att=g.getTextField(3);
			MonoAlphabeticCipher m= new MonoAlphabeticCipher();
			m.setSecretAlphabet(att);
			endtext=m.decrypt(text);
			g.setTextField(2, endtext);
		}
		
	}
	
}
