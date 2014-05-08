package pernystedronsky.cipher;

public class KeywordCipher extends MonoAlphabeticCipher{
	
	/*
	 * Konstruktor
	 * 
	 * @param keyword das gewünschte Keyword
	 */
	public KeywordCipher(String keyword){
		super();
		setKeywordCipher(keyword);
	}
	
	
	/*
	 * In dieser Methode wird das Standardalphabet mithilfe eines Keywords Chiffriert.
	 * 
	 * @param keyword das gewünschte Keyword
	 */
	public void setKeywordCipher(String keyword){
		String alph = super.getSecretAlphabet();
		String kalph = "";
		boolean da = false;
		boolean kfer = false;
		for(int i=0;i<keyword.length();i++){
			da = false;
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
			kfer=true;
		for(int i=0;i<alph.length();i++){
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
