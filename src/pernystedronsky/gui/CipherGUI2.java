package pernystedronsky.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * GUI
 * @author Stedronsky Thomas
 *
 */
public class CipherGUI2 extends JFrame{
	
private CipherGUIController2 c;
private JTextField[] t1= new JTextField[2];
private JComboBox r;
	/**
	 * Konstruktor init() wird aufgerufen
	 * @author Stedronsky Thomas
	 */
	public CipherGUI2(CipherGUIController2 c){
		this.c=c;
		this.init();
	}
	
	/**
	 * init() Designen der GUI 
	 * wird im Konstruktor aufegrufen 
	 * @author Stedronsky Thomas
	 */
	public void init() {
		setLayout(new GridLayout(4, 1)); //LAyut des fensters wird gestzt
		setSize(800, 200); //Fenster größe
		JLabel l;
		//Überschriftwerden mit JLAbel erzeugt
		l=new JLabel("^^ Verschlüsselung Perny Stedronsky ^^");
		/*Die Panels werden mit dem jeweiligen LAyout versehen*/
		JPanel[] p= new JPanel[4]; 
		p[0]=new JPanel();
		p[1]=new JPanel(new GridLayout(1,3));
		p[2]=new JPanel(new GridLayout(1,2));
		p[3]= new JPanel(new GridLayout(1,5));
		
		t1[0] = new JTextField();
		t1[1] = new JTextField();
		
		String[] q={"entschlüsseln", "verschlüsseln"};
		r= new JComboBox(q);
		
		/*Die Buttons für die verschlüsselung werden gesetzt und der ActionListener + ActionCommand werden hinzugefügt.*/
		JButton[] b1 = new JButton[5];
		b1[0]= new JButton("MonoAlpha");
		b1[0].setActionCommand("Mono");
		b1[0].addActionListener(this.c);
		
		b1[1]= new JButton("KeyWord");
		b1[1].setActionCommand("Key");
		b1[1].addActionListener(this.c);
		
		b1[2]= new JButton("Shift");
		b1[2].setActionCommand("Shift");
		b1[2].addActionListener(this.c);
		
		b1[3]= new JButton("Substitution");
		b1[3].setActionCommand("Sub");
		b1[3].addActionListener(this.c);
		
		b1[4]= new JButton("Transposition");
		b1[4].setActionCommand("Trans");
		b1[4].addActionListener(this.c);
		
		/*Die einzelnen GUI Elemente werden den Panels hinzugefügt.*/
		p[0].add(l);
		p[1].add(r);
		for(int i=0; i<t1.length; ++i){
			p[2].add(t1[i]);
		}
		
		for(int i=0; i<b1.length;++i){
			p[3].add(b1[i]);
		}
		for(int i=0; i<p.length;++i){
			this.add(p[i]);
		}
		
		setVisible(true);
	}
	
	/**
	 * Getter Methode für die Textfelder
	 * @param nummer des textfeldes
	 * @return enthaltener text
	 * @author Stedronsky Thomas
	 */
	public String getTextField(int nr){
		return t1[nr].getText();
	}
	
	/**
	 * Setter Methode für die textfelder
	 * @param numer des Textfeldes
	 * @param text der hineingschrieben werden soll
	 * @author Stedronsky Thomas
	 */
	public void setTextField(int nr, String text){
		t1[nr].setText(text);
	}
	
	/**
	 * Item At
	 * @return welche combobox gewälht ist
	 * @author Stedronsky Thomas
	 */
	public int getItem(){
		return  r.getSelectedIndex();
	}
}
