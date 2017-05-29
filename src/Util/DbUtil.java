package Util;

import java.sql.*;

public class DbUtil {

    private static String dbDriver = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String dbUser = "root";
    private static String dbPwd = "root";

    public static Connection getConn() {
        System.out.println("连接数据库。。。");
        Connection conn = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void dbClose(Connection con, Statement sm, ResultSet rs) {
        System.out.println("断开数据库。。。");
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (sm != null) {
            try {
                sm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}