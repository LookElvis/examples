//package ProjectTest.ObjectToSQL;
//
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.sql.DataFrame;
//import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.SaveMode;
//
//import java.io.Serializable;
//import java.util.Properties;
//
///**
// * Created by liuxiang on 2018/7/5.
// */
//public class SparkSQLTest implements Serializable {
//    private static final long serialVersionUID = -8513279306224995844L;
//    private static final String MYSQL_USERNAME = "root";
//    private static final String MYSQL_PWD = "123456";
//    private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://115.157.201.160:3306/StudyTest";
//    private static final JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("SparkSaveToDb").setMaster("local"));
//    private static final SQLContext sqlContext = new SQLContext(sc);
//    public static void main(String[] args) {
//// Sample data-frame loaded from a JSON file
//        DataFrame usersDf = sqlContext.read().json(args[0]);
//// Save data-frame to MySQL (or any other JDBC supported databases)
//        Properties connectionProperties = new Properties();
//        connectionProperties.put("user", MYSQL_USERNAME);
//        connectionProperties.put("password", MYSQL_PWD);
//// write dataframe to jdbc mysql
//        usersDf.write().mode(SaveMode.Append).jdbc(MYSQL_CONNECTION_URL, args[1], connectionProperties);
//    }
//}
