import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class total extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	Vector<Object> columnNames ;
	Vector<Object> data;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					total frame = new total();
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
	public total() {
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
		setBounds(100, 100, 587, 398);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductdetails = new JLabel("productDetails");
		lblProductdetails.setBounds(230, 11, 156, 14);
		contentPane.add(lblProductdetails);
		
		JLabel lblPname = new JLabel("Product_Name");
		lblPname.setBounds(20, 68, 123, 14);
		contentPane.add(lblPname);
		
		JLabel lblPid = new JLabel("Product_Id");
		lblPid.setBounds(20, 97, 123, 14);
		contentPane.add(lblPid);
		
		JLabel lblPtype = new JLabel("Product_Type");
		lblPtype.setBounds(20, 122, 123, 14);
		contentPane.add(lblPtype);
		
		JLabel lblPquantity = new JLabel("Product_quantity");
		lblPquantity.setBounds(20, 147, 123, 14);
		contentPane.add(lblPquantity);
		
		JLabel lblPprice = new JLabel("Product_Price");
		lblPprice.setBounds(20, 172, 106, 14);
		contentPane.add(lblPprice);
		
				JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu mu=new menu();
				setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBounds(142, 325, 89, 23);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(153, 65, 99, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(153, 94, 99, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(153, 119, 99, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(153, 144, 99, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setBounds(153, 169, 99, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 253, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 203, 253, 156);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(10, 24, 89, 23);
		panel_1.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc");
					PreparedStatement ps=con.prepareStatement("insert into product (product_Name,product_id,product_Type,product_quantity,product_Price) values (?,?,?,?,?)");
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textField_3.getText());
					ps.setString(5,textField_4.getText());
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
			}
				
				
				
				
			
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(273, 36, 254, 263);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 221, 232);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int i = table.getSelectedRow();
				TableModel roomObj_Model = table.getModel();
				
				textField.setText(roomObj_Model.getValueAt(i,0).toString());
	    	    textField_1.setText(roomObj_Model.getValueAt(i,1).toString());
	    	    textField_2.setText(roomObj_Model.getValueAt(i,2).toString());
	    	   textField_3.setText(roomObj_Model.getValueAt(i,3).toString());
	    	   textField_4.setText(roomObj_Model.getValueAt(i,4).toString());
			}
		});
		table.setModel(new DefaultTableModel(data,columnNames));
		scrollPane.setViewportView(table);
	}
}
