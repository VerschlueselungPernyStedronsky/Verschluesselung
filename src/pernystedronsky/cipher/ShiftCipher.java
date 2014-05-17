package pernystedronsky.cipher;

public class ShiftCipher extends MonoAlphabeticCipher {

	/**
	 * Konstruktor
	 * 
	 * @param value der Wert der Verschiebung
	 * @author Perny Tboas
	 */
	public ShiftCipher(int value){
		super();//Super konstruktor
		if(value>0){
			setShiftCipher(value); //interne methode zum setzen des shiftlevels
		}
		else {
			setShiftCipher(2);
		}
	}
 

	/**
	 * In dieser Methode wird das Standardalphabet um einen Übergebenen Wert verschoben.
	 * 
	 * @param shiftValue der Wert der Verschiebung.
	 */
	public void setShiftCipher(int shiftValue){
		String alph = super.getSecretAlphabet();
		String temp = "";
		for(int i=0; i<super.getSecretAlphabet().length(); i++){
			if(i+shiftValue >= super.getSecretAlphabet().length()){ //Sollte der Wert Größer als 30 sein 
				temp += "" + alph.charAt((i+shiftValue)-super.getSecretAlphabet().length()); //Das Alphabet wird um die gewisse Zahl verschoben
			}else{ //unter 30
				temp += "" + alph.charAt(i+shiftValue);  //Das Alphabet wird um die gewisse Zahl verschoben
			}
		}
		super.setSecretAlphabet(temp); //Alphabeth wird mit der super methode gesesetzt.
	}

}
