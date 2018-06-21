package sample.util;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-06-20 16:12
 * description
 */
public class JdbcUtil {
    //数据库用户名
    private static final String USERNAME = "root";
    //数据库密码
    private static final String PASSWORD = "123456";
    //驱动信息
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库地址
    private static final String URL = "jdbc:mysql://localhost:3306/CRMS";
    /**
     * 获得数据库的连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            System.out.println("数据库连接成功！");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
