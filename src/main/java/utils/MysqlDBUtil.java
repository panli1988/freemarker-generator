package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  数据库连接工具类（仅mysql）
 * 〈功能详细描述〉
 *
 * @author lipan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MysqlDBUtil {

    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static String DRIVER;
    static{
        URL = "jdbc:mysql://localhost:3306/lpan?useSSL=false&serverTimezone=UTC";
        USER = "root";
        PASSWORD = "1234";
        DRIVER = "com.mysql.cj.jdbc.Driver";
    }

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
