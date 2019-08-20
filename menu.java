import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class menu extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employee ep=new employee();
				ep.setVisible(true);
			}
		});
		btnEmployee.setBounds(160, 37, 89, 23);
		getContentPane().add(btnEmployee);
		
		JButton btnCategory = new JButton("category");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category cy=new category();
				cy.setVisible(true);
			}
		});
		btnCategory.setBounds(160, 176, 89, 23);
		getContentPane().add(btnCategory);
		
		JButton btnProduct = new JButton("product");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product pt=new product();
				pt.setVisible(true);
			}
		});
		btnProduct.setBounds(160, 105, 89, 23);
		getContentPane().add(btnProduct);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin al=new AdminLogin();
				setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(299, 206, 89, 23);
		getContentPane().add(btnBack);
	}
}
