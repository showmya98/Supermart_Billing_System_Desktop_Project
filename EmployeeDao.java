package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DB.employee;

public class EmployeeDao {
public static int save(String employee_name,int employee_id,int employee_phno ){
	int status=0;
	try{
		Connection con=employee.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into Employee(employee_name,employee_id,employee_phno values(?,?,?)");
		ps.setString(1,employee_name);
		ps.setInt(2,employee_id);
		ps.setInt(3,employee_phno);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static boolean checkemployee(int employee_id) {
	
	return false;
}

public static int save(String employee_name, int employee_id, String employee_phno) {
	// TODO Auto-generated method stub
	return 0;
}

public static boolean checkBook(int employee_id) {
	// TODO Auto-generated method stub
	return false;
}


}



