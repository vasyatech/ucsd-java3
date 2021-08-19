import java.math.BigInteger;

public class Hexadecimal {
	private String binValue;
	private String hexValue;
	private int decValue;
	
	public String getHexValue() {
		return hexValue;
	}
	public void setHexValue(String hexValue) {
		this.hexValue = hexValue;
	}
	public String getBinValue() {
		return binValue;
	}
	public int getDecValue() {
		return decValue;
	}
	
	public void convertToBinary() {
		binValue = "";
		convertToDecimal();
		int tmpDec = decValue;
		char binary[] = new char[32];
	    int position = 0;
	    while(tmpDec > 0){
			binary[position++] = (char)(tmpDec%2+48);
			tmpDec /= 2;
	    }
	    StringBuilder sb = new StringBuilder(String.valueOf(binary));
	    binValue = sb.reverse().toString();  
	}
	
	public void convertToDecimal() {
		decValue = 0;
		String digits = "0123456789ABCDEF";
		hexValue = hexValue.toUpperCase();
		for (int i = 0; i < hexValue.length(); i++) {
		    int d = digits.indexOf(hexValue.charAt(i));
		    decValue = 16 * decValue + d;
		}
	}
}
