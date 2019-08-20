import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class AdminLogin extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 200, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AdminLogin");
		lblNewLabel.setBounds(5, 5, 424, 18);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(107, 80, 90, 14);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(107, 134, 82, 14);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(222, 79, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);		
		passwordField = new JPasswordField();
		passwordField.setBounds(222, 133, 105, 20);
		contentPane.add(passwordField);
		JButton btnClick = new JButton("Login");
		btnClick.setBounds(151, 198, 89, 23);
		btnClick.setBackground(UIManager.getColor("Button.background"));
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu mu=new menu();
				mu.setVisible(true);
				String name=textField.getText();
				String password=String.valueOf(passwordField.getPassword());
				if(name.equals("sowmya")&&password.equals("123"))
				{		
				}else{
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
				}	
			
				
		});
		btnClick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnClick);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Billing bg=new Billing();
				setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(310, 200, 89, 23);
		contentPane.add(btnBack);
	}
}
