package pernystedronsky.cipher;

public class ShiftCipher extends MonoAlphabeticCipher {
	
	/*
	 * Konstruktor
	 * 
	 * @param value der Wert der Verschiebung
	 */
	public ShiftCipher(int value){
		super();
		setShiftCipher(value);
	}
	
	
	/*
	 * 
	 */
	public void setShiftCipher(int shiftValue){
		String alph = super.getSecretAlphabet();
		String temp = "";
		for(int i=0; i<super.getSecretAlphabet().length(); i++){
			if(i+shiftValue >= super.getSecretAlphabet().length()){
				temp += "" + alph.charAt((i+shiftValue)-super.getSecretAlphabet().length());
			}else{
				temp += "" + alph.charAt(i+shiftValue);
			}
		}
		super.setSecretAlphabet(temp); 
	}

}
