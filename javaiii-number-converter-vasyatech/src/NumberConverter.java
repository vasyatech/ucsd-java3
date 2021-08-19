
public class NumberConverter {
	public static void main(String[] args) {
		//Converts dec to bin and dec to hex
		Decimal dec = new Decimal();
		
		//Converts bin to dec and bin to hex
		Binary bin = new Binary();
		
		//Converts hex To dec and hex to bin
		Hexadecimal hex = new Hexadecimal();
		
		//Create and displays menu
		Menu menu = new Menu(dec, bin, hex);
		menu.show();
	}
}