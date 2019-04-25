package ProjectTest.ObjectToSQL;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by liuxiang on 2018/7/3
 */
 public class JDBCConnectionTool {
    public static Properties getConfigProp() throws IOException {
        InputStream in = JDBCConnectionTool.class.getClassLoader().getResourceAsStream("conf/jdbc.properties"); // 需要指定资源的路径，这样类加载器才找的到资源
        Properties prop = new Properties();
        prop.load(in);
        System.out.println("====== JDBC properteis file is load successfully ======");
        return prop;
    }

    public static Connection getConn() {
        Properties prop = null;
        try {
             prop = getConfigProp();
        } catch (IOException e) {
            System.out.println("====== JDBC properties file is load failed =====");
            throw new RuntimeException(e.getMessage(),e);
        }
        String driver = prop.getProperty("driver");
        String url = prop.getProperty("url");
        String username = prop.getProperty("userName");
        String password = prop.getProperty("password");
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void free(Statement st, Connection conn) {
        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }
}
