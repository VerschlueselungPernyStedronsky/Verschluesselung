package pernystedronsky.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI
 * @author Stedronsky Thomas
 *
 */
public class CipherGUI extends JFrame{
	
private CipherGUIController c;
	
	/**
	 * Konstruktor init() wird aufgerufen
	 */
	public CipherGUI(CipherGUIController c){
		this.c=c;
		this.init();
	}
	
	/**
	 * init()
	 */
	public void init() {
		setLayout(new GridLayout(6, 1));
		setSize(800, 200);
		JLabel[] l = new JLabel[2];
		l[0]=new JLabel("Verschlüsseln");
		l[1]=new JLabel("Entschlüsseln");
		JPanel[] p= new JPanel[6]; 
		p[0]=new JPanel();
		p[1]=new JPanel(new GridLayout(1,2));
		p[2]= new JPanel(new GridLayout(1,5));
		p[3]= new JPanel();
		p[4]= new JPanel(new GridLayout(1,2));
		p[5]= new JPanel(new GridLayout(1,5));
		
		JTextField[] t1= new JTextField[2];
		t1[0] = new JTextField();
		t1[1] = new JTextField();
		
		JButton[] b1 = new JButton[5];
		b1[0]= new JButton("MonoAlpha");
		b1[0].setActionCommand("encryptMono");
		b1[1]= new JButton("KeyWord");
		b1[1].setActionCommand("encryptKey");
		b1[2]= new JButton("Shift");
		b1[2].setActionCommand("encryptShift");
		b1[3]= new JButton("Substitution");
		b1[3].setActionCommand("encryptSub");
		b1[4]= new JButton("Transposition");
		b1[4].setActionCommand("encryptTrans");
		
		
		JTextField[] t2= new JTextField[2];
		t2[0] = new JTextField();
		t2[1] = new JTextField();
		
		JButton[] b2 = new JButton[5];
		b2[0]= new JButton("MonoAlpha");
		b2[0].setActionCommand("decryptMono");
		b2[1]= new JButton("KeyWord");
		b2[1].setActionCommand("decryptKey");
		b2[2]= new JButton("Shift");
		b2[2].setActionCommand("decryptShift");
		b2[3]= new JButton("Substitution");
		b2[3].setActionCommand("decryptSub");
		b2[4]= new JButton("Transposition");
		b2[4].setActionCommand("decryptTrans");
		
		p[0].add(l[0]);
		for(int i=0; i<t1.length; ++i){
			p[1].add(t1[i]);
		}
		
		for(int i=0; i<b1.length;++i){
			p[2].add(b1[i]);
		}
		
		p[3].add(l[1]);
		for(int i=0; i<t2.length; ++i){
			p[4].add(t2[i]);
		}
		
		for(int i=0; i<b2.length;++i){
			p[5].add(b2[i]);
		}
		
		for(int i=0; i<p.length;++i){
			this.add(p[i]);
		}
		
		setVisible(true);
	}
}
