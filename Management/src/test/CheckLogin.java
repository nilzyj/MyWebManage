//package test;
//
//import java.sql.*;
//
//public class CheckLogin {
//	public static String check(String name, String password) {
//		Connection con = null;
//		Statement sm = null;
//		ResultSet rs = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			String url = "jdbc:mysql://localhost/mydb";
//			con = DriverManager.getConnection(url,"root","root");
//			sm = con.createStatement();
//			rs = sm.executeQuery("select * from stu_account where stu_name='"+name+"'");
//			if(rs.next()) {
//				if(rs.getString("stu_password").equals(password))
//				{
//					return "1";//������ȷ
//				}
//				else
//				{
//					return "2";//�������
//				}
//			}
//			else
//			{
//				return "0";//�û���������
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			if(rs != null)
//			{
//				try{rs.close();}catch(Exception e){e.printStackTrace();};
//			}
//			if(sm != null)
//			{
//				try{sm.close();}catch(Exception e){e.printStackTrace();}
//			}
//			if(con != null)
//			{
//				try{con.close();}catch(Exception e){e.printStackTrace();}
//			}
//		}
//		return "�������ݿ� ����";
//	}
//}