package GUI;

//My package
import CurrencyConverter.CurrencyConverter;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Encriptador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4418328719146293610L;
	private JPanel MainPanel;
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encriptador frame = new Encriptador();
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
	public Encriptador() {
		setType(Type.UTILITY);
		//setUndecorated(true);
		setTitle("Encriptador_Challenge1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		
		//Panel principal.
		MainPanel = new JPanel();
		MainPanel.setBorder(null);

		setContentPane(MainPanel);
		MainPanel.setLayout(null);
		
		JComboBox<Object> cbCurrenyFrom = new JComboBox<Object>();
		cbCurrenyFrom.setModel(new DefaultComboBoxModel<Object>(new String[] {"Dolar (US)", "Euro (EUR)", "British Pound (GBP)", "Yen (JPY)", "Won (KRW)", "Peso (MXN)"}));
		cbCurrenyFrom.setBounds(228, 109, 190, 30);
		MainPanel.add(cbCurrenyFrom);
		
		JLabel lblTittle = new JLabel("Currenci Conversor.");
		lblTittle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTittle.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTittle.setBounds(254, 0, 189, 52);
		MainPanel.add(lblTittle);
		
		JComboBox<Object> cbCurrencyTo = new JComboBox<Object>();
		cbCurrencyTo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Dolar (US)", "Euro (EUR)", "British Pound (GBP)", "Yen (JPY)", "Won (KRW)", "Peso (MXN)"}));
		cbCurrencyTo.setBounds(495, 109, 190, 30);
		MainPanel.add(cbCurrencyTo);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(40, 110, 132, 30);
		MainPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblAmount.setBounds(40, 84, 68, 15);
		MainPanel.add(lblAmount);
		
		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFrom.setBounds(228, 84, 46, 14);
		MainPanel.add(lblFrom);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblTo.setBounds(495, 84, 46, 14);
		MainPanel.add(lblTo);
		
		JButton btnChangeCountry = new JButton("");
		btnChangeCountry.setBackground(UIManager.getColor("Button.background"));
		btnChangeCountry.setIcon(new ImageIcon("C:\\Users\\johan\\Downloads\\exchange.png"));
		btnChangeCountry.setBounds(446, 109, 30, 30);
		MainPanel.add(btnChangeCountry);
		
		JTextArea txtrResult = new JTextArea();
		txtrResult.setFont(new Font("Century Gothic", Font.BOLD, 17));
		txtrResult.setEnabled(false);
		txtrResult.setText("resultado\r\ndfsd\r\ndsfs");
		txtrResult.setBounds(40, 150, 645, 102);
		MainPanel.add(txtrResult);
		
		JButton btnNewButton = new JButton("Conversion.");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(574, 263, 111, 30);
		MainPanel.add(btnNewButton);
		
		//Change position of country selected to conversion.
		btnChangeCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countryFromIndex = cbCurrenyFrom.getSelectedIndex();
				int countryToIndex = cbCurrencyTo.getSelectedIndex();
				
				cbCurrencyTo.setSelectedIndex(countryFromIndex);
				cbCurrenyFrom.setSelectedIndex(countryToIndex);
			}
		});
		//Execute conversion.
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CurrencyConverter converter = new CurrencyConverter();
				try {
					Double amount = Double.parseDouble(txtAmount.getText());
					String countryFrom = converter.getContentInParenthesis(cbCurrenyFrom.getSelectedItem().toString());
					String countryTo =converter.getContentInParenthesis(cbCurrencyTo.getSelectedItem().toString());
					String result = converter.converterCurrency(amount, countryFrom, countryTo);
					
					txtrResult.setText(amount + " " + countryFrom + " Equivale a " + result + countryTo);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, error.getMessage() + "\nFavor de ingresar un número valido.", "Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
