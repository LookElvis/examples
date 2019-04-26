package Common.MoveTest;

import com.lucloud.cloudmining.datamove.operator.MysqlOperator;

/**
 * Created by liuxiang on 2018/7/18.
 */
public class MysqlTest {
    public static void main(String args[]) throws Exception{
        //创建mysql操作类
        MysqlOperator mysqlOperator = new MysqlOperator();

        //提供sql语句和对象进行插入操作
        String sql = "insert into tablename(c1,c2) values(?,?)";
        Object[] object = new Object[] {"value1", "value2"}	;
        mysqlOperator.insertWithSql(sql, object);

        //提供字段名和字段对应的值进行插入操作
//        String tableName = "tableName";
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", 1013);
//        map.put("name", "JDBCUtil测试");
//        map.put("salary", 10000);
//        map.put("date", new java.sql.Date(System.currentTimeMillis()));
//        mysqlOperator.insertWithoutSql(tableName, map);
    }
}
