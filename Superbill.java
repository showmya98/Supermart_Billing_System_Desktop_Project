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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Superbill extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_3;
	private JTextField txtField_2;
	private JButton btnPrint;
	private JButton btnAdd;
	private JTable table;
	Vector<Object> columnNames1 ;
	Vector<Object> data;
	private JLabel lblProductid;
	private JComboBox comboBox;
	private JLabel lblProductname;
	private JTextField textField;
	private JLabel lblDate;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Superbill frame = new Superbill();
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
	public Superbill() {
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
    	 String sql = "Select * from Superbill";
    	 
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
		
		JLabel lblProductprice = new JLabel("product_Price");
		lblProductprice.setBounds(29, 138, 81, 14);
		contentPane.add(lblProductprice);
		
		txtField_3 = new JTextField();
		txtField_3.setBounds(119, 135, 86, 20);
		contentPane.add(txtField_3);
		txtField_3.setColumns(10);
		
		JLabel lblProductquantity = new JLabel("product_Quantity");
		lblProductquantity.setBounds(29, 98, 98, 14);
		contentPane.add(lblProductquantity);
		
		txtField_2 = new JTextField();
		txtField_2.setBounds(119, 95, 86, 20);
		contentPane.add(txtField_2);
		txtField_2.setColumns(10);
		
		btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrint.setBounds(287, 227, 89, 23);
		contentPane.add(btnPrint);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc");
					PreparedStatement ps=con.prepareStatement("insert into Superbill(product_Name,product_Quantity,product_Price) values(?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,txtField_2.getText());
					ps.setString(3,txtField_3.getText());
					int i=ps.executeUpdate();
					//con.close();
					if( i>0)
					{
						JOptionPane.showMessageDialog(null,"inserted successfully");
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"inserted  not successfully");
					}
					con.close();
					}
				catch(Exception e1){System.out.println(e1);}
				//return status;

				
				
				}
			});	
				
				
				
		
		btnAdd.setBounds(33, 227, 89, 23);
		contentPane.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(229, 0, 195, 208);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 175, 186);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null,null},
				{null,null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"product_Name", "product_Quantity", "product_Price"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int 
				i = table.getSelectedRow();
				TableModel roomObj_Model = table.getModel();
				
				textField.setText(roomObj_Model.getValueAt(i,0).toString());
	    	    txtField_2.setText(roomObj_Model.getValueAt(i,1).toString());
	    	    txtField_3.setText(roomObj_Model.getValueAt(i,2).toString());
	    	   // textField_3.setText(roomObj_Model.getValueAt(i,3).toString());
	    	    
				

									
				
			}
		});
		table.setModel(new DefaultTableModel(data,columnNames));
		scrollPane.setViewportView(table);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnTotal.setBounds(53, 182, 89, 23);
		contentPane.add(btnTotal);
		
		lblProductid = new JLabel("product_Id");
		lblProductid.setBounds(29, 39, 66, 14);
		contentPane.add(lblProductid);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"101", "102", "103", "104"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(119, 36, 79, 20);
		contentPane.add(comboBox);
		
		lblProductname = new JLabel("product_Name");
		lblProductname.setBounds(29, 73, 81, 14);
		contentPane.add(lblProductname);
		
		textField = new JTextField();
		textField.setBounds(119, 67, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblDate = new JLabel("Date");
		lblDate.setBounds(10, 14, 46, 14);
		contentPane.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(53, 8, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
