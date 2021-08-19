import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu implements ActionListener{
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JButton binToHex = new JButton();
	private JButton binToDec = new JButton();
	private JButton hexToBin = new JButton();
	private JButton hexToDec = new JButton();
	private JButton decToHex = new JButton();
	private JButton decToBin = new JButton();
	private Decimal decimal;
	private Binary binary;
	private Hexadecimal hexadecimal;
	
	public Menu(Decimal dec, Binary bin, Hexadecimal hex) {
		super();
		this.decimal = dec;
		this.binary = bin;
		this.hexadecimal = hex;
	}
	
	public void show() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(binToDec);
		panel.add(binToHex);
		panel.add(decToBin);
		panel.add(decToHex);
		panel.add(hexToBin);
		panel.add(hexToDec);
		binToDec.setText("Bin To Dec");
		binToHex.setText("Bin To Hex");
		decToBin.setText("Dec To Bin");
		decToHex.setText("Dec To Hex");
		hexToBin.setText("Hex To Bin");
		hexToDec.setText("Hex To Dec");
		frame.pack();
		binToDec.addActionListener(this);
		binToHex.addActionListener(this);
		decToBin.addActionListener(this);
		decToHex.addActionListener(this);
		hexToBin.addActionListener(this);
		hexToDec.addActionListener(this);
	}
	
	private String inputValue (String s) {
		return JOptionPane.showInputDialog("Enter " + s +" number:");
	}
	
	private void showResult(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "test");
		if(e.getSource()==binToHex){
			binary.setBinValue(inputValue("binary"));
			binary.convertToHexadecimal();
			showResult("Binary number: " + binary.getBinValue() + ", Hex number: " + binary.getHexValue());
	    }
		if(e.getSource()==binToDec){
			binary.setBinValue(inputValue("binary"));
			binary.convertToDecimal();
			showResult("Binary number: " + binary.getBinValue() + ", Decimal number: " + binary.getDecValue());
		}
		if(e.getSource()==decToBin){
			decimal.setDecValue(Integer.parseInt(inputValue("decimal")));
			decimal.convertToBinary();
			showResult("Decimal number: " + decimal.getDecValue() + ", Binary number: " + decimal.getBinValue());
		}
		if(e.getSource()==decToHex){
			decimal.setDecValue(Integer.parseInt(inputValue("decimal")));
			decimal.convertToHexadecimal();
			showResult("Decimal number: " + decimal.getDecValue() + ", Hex number: " + decimal.getHexValue());
		}
		if(e.getSource()==hexToBin){
			hexadecimal.setHexValue(inputValue("hexadecimal"));
			hexadecimal.convertToBinary();
			showResult("Hex number: " + hexadecimal.getHexValue() + ", Binary number: " + hexadecimal.getBinValue());
		}
		if(e.getSource()==hexToDec){
			hexadecimal.setHexValue(inputValue("hexadecimal"));
			hexadecimal.convertToDecimal();
			showResult("Hex number: " + hexadecimal.getHexValue() + ", Decimal number: " + hexadecimal.getDecValue());
		}
	}
}
