import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField;
	public Bill() {
		getContentPane().setLayout(null);
	}
	
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public void Bill() {
		Vector<Object> columnNames = new Vector<Object>();
	    Vector<Object> data = new Vector<Object>();
	    try{
	    	//Utility u = new Utility();
    		Class.forName("oracle.jdbc.driver.OracleDriver");   
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"system","abc"); 
			//int i=stmt.executeUpdate(); 
    		//Connection con= u.getconnection();
    	
    	//PreparedStatement stmt=con.prepareStatement("select * from staff");
    	 String sql = "Select * from product";
    	 
         Statement stmt = con.createStatement();
    	ResultSet rs = stmt.executeQuery( sql );
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        for (int i = 1; i <= columns; i++)
        {
            columnNames.addElement( md.getColumnName(i) );
        }
        while (rs.next())
        {
            Vector<Object> row = new Vector<Object>(columns);
 
            for (int i = 1; i <= columns; i++)
            {
                row.addElement( rs.getObject(i) );
            }
 
            data.addElement( row );
        }
        rs.close();
        stmt.close();
        con.close();
    	}
		
		catch(Exception e1){ System.out.println(e1);}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductname = new JLabel("product_Name");
		lblProductname.setBounds(10, 76, 86, 14);
		contentPane.add(lblProductname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 73, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblProduct_Price = new JLabel("Product_Price");
		lblProduct_Price.setBounds(10, 113, 67, 14);
		contentPane.add(lblProduct_Price);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 110, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblProductid = new JLabel("product_Id");
		lblProductid.setBounds(10, 38, 67, 14);
		contentPane.add(lblProductid);
		
		JButton btnGrandtotal = new JButton("grandtotal");
		btnGrandtotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGrandtotal.setBounds(252, 196, 89, 23);
		contentPane.add(btnGrandtotal);
		
		JLabel lblBillDate = new JLabel("Bill date");
		lblBillDate.setBounds(228, 11, 46, 14);
		contentPane.add(lblBillDate);
		
		textField_4 = new JTextField();
		textField_4.setBounds(284, 8, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblProductquantity = new JLabel("product_Quantity");
		lblProductquantity.setBounds(10, 151, 89, 14);
		contentPane.add(lblProductquantity);
		textField = new JTextField();
		
		textField.setBounds(103, 148, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		btnInsert.setBounds(7, 227, 89, 23);
		contentPane.add(btnInsert);
		
		JPanel panel = new JPanel();
		panel.setBounds(209, 42, 215, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 195, 121);
		panel.add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setRowHeaderView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
					}	
			
		});
		comboBox.setBounds(83, 35, 96, 20);
		contentPane.add(comboBox);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int 
				i = table.getSelectedRow();
				TableModel roomObj_Model = table.getModel();
				
				textField.setText(roomObj_Model.getValueAt(i,0).toString());
	    	    textField_1.setText(roomObj_Model.getValueAt(i,1).toString());
	    	    textField_2.setText(roomObj_Model.getValueAt(i,2).toString());
	    	   textField_4.setText(roomObj_Model.getValueAt(i,3).toString());						
			
			}
		});
		
		
		
		
		
		
		
		
		
		
	


