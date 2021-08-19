package GuestBook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class ContactViewController implements ActionListener{
	private JTextArea textArea = new JTextArea(6, 25);
	private JTextField firstNameTextField = new JTextField(20);
	private JTextField lastNameTextField = new JTextField(20);
	private JTextField addressNameTextField = new JTextField(20);
	private JTextField phoneNameTextField = new JTextField(20);
	private JButton button = new JButton("Submit");
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	public ContactViewController() {
		super();
		show();
	}
	public void show() {
	    JFrame frame = new JFrame();
		JLabel firstNameLabel = new JLabel("First Name");
		JLabel lastNameLabel = new JLabel("Last Name");
		JLabel addressLabel =  new JLabel("Address");
		JLabel phoneLabel =    new JLabel("Phone");
		button.addActionListener(this);

		frame.setResizable(false);
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		frame.add(leftPanel);
		frame.add(rightPanel);
		frame.setLayout(new GridLayout(0,2));
		
		leftPanel.setLayout(new GridBagLayout());
		leftPanel.setBackground(UIManager.getColor("control"));
	    GridBagConstraints gbc = new GridBagConstraints();

	    gbc.gridx = 0;
	    gbc.gridy = GridBagConstraints.RELATIVE;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    gbc.insets = new Insets(2, 2, 2, 2);
	    gbc.anchor = GridBagConstraints.EAST;

	    leftPanel.add(firstNameLabel, gbc);
	    leftPanel.add(lastNameLabel, gbc);
	    leftPanel.add(addressLabel, gbc);
	    leftPanel.add(phoneLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gbc.weightx = 1.0;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.anchor = GridBagConstraints.CENTER;
	    leftPanel.add(firstNameTextField, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = GridBagConstraints.RELATIVE;
	    leftPanel.add(lastNameTextField, gbc);
	    leftPanel.add(addressNameTextField, gbc);
	    leftPanel.add(phoneNameTextField, gbc);
	    gbc.weightx = 0.0;
	    gbc.fill = GridBagConstraints.NONE;
	    leftPanel.add(button, gbc);
	    
		textArea.setEditable(false);
	    rightPanel.add(textArea);
	    JScrollPane scrollPane = new JScrollPane (textArea, 
	    		   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    rightPanel.add(scrollPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		Contact contact;
		if(e.getSource()==button){
			if (firstNameTextField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(firstNameTextField, "First Name required");
				return;
			}
			contact = new Contact(firstNameTextField.getText(),
								  lastNameTextField.getText(),
								  addressNameTextField.getText(), 
								  phoneNameTextField.getText());
			for (Contact c : contacts) {
				if (c.getContact().equals(contact.getContact())) {
					JOptionPane.showMessageDialog(null, "A duplicate contact cannot be submitted");
					return;
				}
			}
			
			contacts.add(contact);
			Collections.sort(contacts);
			
			firstNameTextField.setText("");
			lastNameTextField.setText("");
			addressNameTextField.setText("");
			phoneNameTextField.setText("");
			textArea.setText("");
			for (Contact c : contacts) {
				textArea.append(c.getContact());
			}
	    }
	}
}
