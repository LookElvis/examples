package ProjectTest.ObjectToSQL;

import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import scala.Tuple5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by xiao on 2017/3/9.
 */
public class JavaLocal2SQL {
    public List<String> search(SparkContext sc, String url, String tableName, String[] condition) {
        Properties prop = new Properties();
        SQLContext sqlContext = new SQLContext(sc);
        List<Row> dataset = sqlContext.read().jdbc(url, tableName, condition, prop).toJavaRDD().collect();
        final ArrayList<String> list = new ArrayList<String>();
        for (Row row : dataset) {
            String str = "";
            for (int i = 0; i < row.length(); i++) {
                str += row.get(i).toString() + "\t";
                list.add(str);
            }
        }
        return list;
    }

    public void insert(SparkContext sc, String path, final String url, final String sql) {
        SQLContext sqlContext = new SQLContext(sc);
        JavaSparkContext ctx = JavaSparkContext.fromSparkContext(sc);
        JavaRDD<String> data = ctx.textFile(path);
        final JavaRDD<Tuple5<Integer, String, String, Integer, String>> record = data.map(new Function<String, Tuple5<Integer, String, String, Integer, String>>() {

            public Tuple5<Integer, String, String, Integer, String> call(String s) throws Exception {
                if (s.split("\\s+").length < 5) {
                    throw new IllegalArgumentException("the number of filed must more 5");
                }
                int strNo = Integer.parseInt(s.split("\\s+")[0]);
                String name = s.split("\\s+")[1];
                String sex = s.split("\\s+")[2];
                int age = Integer.parseInt(s.split("\\s+")[3]);
                String address = s.split("\\s+")[4];
                return new Tuple5<Integer, String, String, Integer, String>(strNo, name, sex, age, address);
            }
        });

        record.map(new Function<Tuple5<Integer, String, String, Integer, String>, Object>() {
            @Override
            public Object call(Tuple5<Integer, String, String, Integer, String> record) throws ClassNotFoundException, SQLException {
                Connection conn = null;
                PreparedStatement ps = null;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url);
                ps = conn.prepareStatement(sql);
                ps.setInt(1, record._1());
                ps.setString(2, record._2());
                ps.setString(3, record._3());
                ps.setInt(4, record._4());
                ps.setString(5, record._5());
                ps.executeUpdate();
                ps.close();
                conn.close();
                return record;
            }
        }).count();
    }
}
