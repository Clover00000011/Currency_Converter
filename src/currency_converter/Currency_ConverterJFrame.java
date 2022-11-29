// JFrame version
package currency_converter;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class Currency_ConverterJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String dollar = "Dollar";
	String rupee = "Rupee";
	String euro = "Euro";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Currency_ConverterJFrame frame = new Currency_ConverterJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Currency_ConverterJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Create textField for input
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 68, 240, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// Create labels to display converted amounts
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 110, 414, 14);
		contentPane.add(label);
		
		JLabel label2 = new JLabel("");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(10, 135, 414, 14);
		contentPane.add(label2);
		
		JLabel label3 = new JLabel("");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(10, 160, 414, 14);
		contentPane.add(label3);
		
		// Create button to convert
		JButton btn = new JButton("Convert");
		btn.setBorderPainted(false);
		btn.setBackground(new Color(0, 255, 64));
		btn.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btn.setBounds(150, 193, 136, 57);
		contentPane.add(btn);
		
		// Create comboBox to switch between currency
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(260, 67, 164, 22);
		comboBox.addItem(dollar);
		comboBox.addItem(rupee);
		comboBox.addItem(euro);
		contentPane.add(comboBox);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// Change label color to red, which will separate the default input from the two others
				label.setForeground(new Color(255, 0, 0));
				// Make textField type double
				double input = Double.parseDouble(textField.getText());
				// Dollar Conversion
				if(comboBox.getSelectedItem().equals(dollar)) {
					double rupeeAmount = input * 79.37;
		        	double euroAmount = input * 0.98;
					btn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							label.setText(String.format("$%.2f", input));
							label2.setText(String.format("₹%.2f", rupeeAmount));
							label3.setText(String.format("€%.2f", euroAmount));
						}
					});
					
				} 
				// Rupee Conversion
				else if (comboBox.getSelectedItem().equals(rupee)) {
		        	double euroAmount = input * 0.012;
		        	double dollarAmount = input * 0.013;
					label.setText(String.format("₹%.2f", input));
					label2.setText(String.format("$%.2f", dollarAmount));
					label3.setText(String.format("€%.2f", euroAmount));
				} 
				// Euro Conversion
				else {
		        	double rupeeAmount = input * 80.85;
		        	double dollarAmount = input * 1.02;
					label.setText(String.format("€%.2f", input));
					label2.setText(String.format("$%.2f", dollarAmount));
					label3.setText(String.format("₹%.2f", rupeeAmount));
				}
			}
		});
	}
}
