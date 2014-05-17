package pernystedronsky.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	
	/**
	 * Konstruktor
	 * 
	 * @param keyword das gewünschte Keyword
	 * @author Perny Tobias
	 */
	public KeywordCipher(String keyword){
		super();
		setKeywordCipher(keyword);
	} 
	
	
	/**
	 * In dieser Methode wird das Standardalphabet mithilfe eines Keywords Chiffriert.
	 * 
	 * @param keyword das gewünschte Keyword
	 */
	public void setKeywordCipher(String keyword){
		String alph = super.getSecretAlphabet();	//Standardalphabet wird gespeichert
		String kalph = "";			//Hier ist am Ende das neue alphabet gespeichert
		boolean da = false;			//booleanvariable die angibt ob ein Buchstabe schon vorhanden ist
		boolean kfer = false;
		for(int i=0;i<keyword.length();i++){	//In dieser schleife wird ausgelesen ob doppelte buchstaben im keyqord enthalten sind
			da = false;							//wenn ja werden diese verworfen
			if(i==0)
				kalph+=keyword.charAt(i);		
			if(i>0 && i<keyword.length()){
				for(int j=0; j<kalph.length();j++){
					if(keyword.charAt(i)==kalph.charAt(j)){ 
						da = true;
					}
				}
				if(da==false){
					kalph+=keyword.charAt(i);
				}
			}
		}
			kfer=true;		//wenn alle buchstaben des Keywords gespeichert sind wird diese Variable true gesetzt
		for(int i=0;i<alph.length();i++){	//In dieser Schleife werden die verbleibenden Buchstaben des Alphabets der Variable hinzugefügt.
			da = false;
			if(kfer==true){
				for(int j = 0; j<kalph.length();j++){
					if(alph.charAt(i)==kalph.charAt(j)){
						da = true;
					}
				}
				if(da==false){
					kalph+=alph.charAt(i);
				}
			}
		}
	}
}
