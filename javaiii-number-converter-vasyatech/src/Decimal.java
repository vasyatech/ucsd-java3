import java.util.Arrays;

public class Decimal {
	private String binValue;
	private String hexValue;
	private int decValue;
	
	public int getDecValue() {
		return decValue;
	}

	public void setDecValue(int decValue) {
		this.decValue = decValue;
	}

	public String getBinValue() {
		return binValue;
	}

	public String getHexValue() {
		return hexValue;
	}

	public void convertToBinary() {
		binValue = "";
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
	
	public void convertToHexadecimal() {
		hexValue = "";
		int tmpDec = decValue;
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(tmpDec > 0)
		{
			hexValue=hexDigits[tmpDec % 16] + hexValue; 
			tmpDec /= 16;
		}
	}
}
