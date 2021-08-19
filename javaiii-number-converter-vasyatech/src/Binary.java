import javax.swing.JOptionPane;

public class Binary {
	private String binValue;
	private String hexValue;
	private int decValue;
	
	public void setBinValue(String binValue) {
		this.binValue = binValue;
	}
	public String getBinValue() {
		return binValue;
	}

	public String getHexValue() {
		return hexValue;
	}

	public int getDecValue() {
		return decValue;
	}
	
	public void convertToHexadecimal() {
		hexValue = "";
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		convertToDecimal();
		while (decValue > 0) {
			hexValue = hexDigits[decValue % 16] + hexValue;
			decValue /= 16;
		}
	}
	
	public void convertToDecimal() {
		decValue = 0;
		int rank = binValue.length() - 1;
		char[] digits = binValue.toCharArray();
		for (char digit : digits) {
			if (String.valueOf(digit).equals("1")) {
				decValue += Math.pow(2, rank);
			}
			--rank;
		}
	}
}
