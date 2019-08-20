package Dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;

	import DB.employee;

	public class categoryDao {
	public static int save(int category_id,String category_type ){
		int status=0;
		try{
			Connection con=employee.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into category(category_id,category_type values(?,?)");
			ps.setInt(1,category_id);
			ps.setString(3,category_type);
			
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean checkemployee(int category_id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
