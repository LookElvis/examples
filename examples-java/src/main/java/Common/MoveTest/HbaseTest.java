package Common.MoveTest;

import com.lucloud.cloudmining.datamove.operator.HbaseOperator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiang on 2018/7/23.
 */
public class HbaseTest {
    public static void main(String[] args) {
        //创建hbase操作类
        //默认从conf/path.properties中获取tableName和familyName
        //也可以通过hbaseOperator.setHbase(tableName, famiilyName)方法设置该次操作的Hbase
        HbaseOperator hbaseOperator = new HbaseOperator();
//        hbaseOperator.setHbase("tableName", "familyName");

        //若当前Hbase不存在数据表，则调用该方法创建
        //创建包含多个列族的表
        String[] families = {"Test1", "Test2"};
        hbaseOperator.createTable("HBaseTest1", families);
        //创建包含单个列族的表
        hbaseOperator.createTable("HBaseTest2", "Test3");

        //切换操作的Hbase
        hbaseOperator.setHbase("HBaseTest2", "Test3");

        //插入单列数据
        hbaseOperator.putOne("key1","column","value");
        //插入多列数据
        List<String> columns = new ArrayList<>();
        columns.add("column1");
        columns.add("column2");
        List<String> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        hbaseOperator.putSome("key2", columns, values);
    }
}
