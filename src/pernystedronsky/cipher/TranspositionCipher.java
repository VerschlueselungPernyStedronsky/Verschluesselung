package pernystedronsky.cipher;

/**
 * 
 * @author Stedronsky Thomas
 * @version 2014-05-08
 *
 */
public class TranspositionCipher implements Cipher {
	private int transpositonLevel; //verschlüsselungsstufe

	/**
	 * Konstruktor der den transpositonLevel
	 * @author Stedronsky Thomas
	 * @param  transpositonLevel Stufe der Gartentzaun verschlüsselung
	 */
	public TranspositionCipher(int transpositonLevel){
		if(transpositonLevel > 0){
			this.transpositonLevel=transpositonLevel;
		}
		else {
			this.transpositonLevel=2;
		}
	}

	/**
	 * TranspositionLEvel wird festgelegt
	 * @author Stedronsky Thomas
	 * @param  level Stufe der Gartentzaun verschlüsselung
	 */
	public void setTranspositionLevel(int level){
		if(level > 0){
			this.transpositonLevel=level;
		}
		else {
			this.transpositonLevel=2;
		}
	}

	/**
	 * Encryptmethode mittels Transpositionsverfahren
	 * @param text 		der zu verschluesselnde Text
	 * @return entext 	der verschluesselte Text
	 */
	@Override
	public String encrypt(String text) {
		String entext="";
		String t=text.toUpperCase();
		String[] encrypt = new String[this.transpositonLevel]; //String Array mit der Stufe des Transpositionslevel wurde erstellt.

		for(int i=0; i<encrypt.length;++i){
			encrypt[i]="";
		}
		for(int i=0; i<t.length();++i){
			int q=i%encrypt.length; 
			encrypt[q]+=""+t.charAt(i); //Zeichen werden eingefügt
		}

		for(int i=0; i<encrypt.length;++i){
			entext=entext+encrypt[i]; //wird in ein String zusammengefasst
		}
		return entext;
	}

	/**
	 * Decrypt methode mitels Transpositon
	 * @param vertext    verschluesselter Text
	 * @return detext entschluesselter Text
	 */
	@Override
	public String decrypt(String verText) {
		String detext="";
		String text=verText.toUpperCase();
		String [] decrypt= new String [this.transpositonLevel]; //Array mit den Stufen des Attributts
		int [] anzahl = new int [this.transpositonLevel];//Anzahl der Buchstaben in jeder Zeile 
		int groesse = 1;
		int anzahlzaehler=0;
		
		//String[] wird initalisiert.
		for(int i = 0; i< decrypt.length; i++){
			decrypt[i] = "";
		}

		int zahl = text.length()/this.transpositonLevel;//Buchstaben in einer Zeile
		int rest = text.length()%this.transpositonLevel;//restliche Buhstaben
		
		//Die Zahl wird in Anzahl gepspeichert
		for(int i=0; i<anzahl.length ;i++){	
			anzahl[i] = zahl;
		}
		
		//Der rest wird solange dazu addiert bis keiner mehr übrig ist.
		for(int i = 0 ; i < rest; i++){
			anzahl[i]++;
		}

		
		for(int i = 0; i < text.length(); i++){
			decrypt[anzahlzaehler] += "" + text.charAt(i);
			if(groesse == anzahl[anzahlzaehler]){
				anzahlzaehler++;
				groesse=0; //Wenn die länge der Zeile erreicht wird die groesse wieder zurückgesetzt.
			}
			groesse++;
		}
		
		
		for(int j = 0; j < anzahl[0]; j++){
			for(int i=0; i<decrypt.length ;i++){	
				if(decrypt[i].length()>j){
					detext+=decrypt[i].charAt(j); //Wird an der stelle in ein String umgewandelt.
				}
			}

		}
		return detext;
	}
}
