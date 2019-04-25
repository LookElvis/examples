package Common.MoveTest;

import com.lucloud.cloudmining.datamove.operator.HdfsOperator;


/**
 * Created by liuxiang on 2018/7/16.
 */
public class HdfsTest {
    public static void main(String[] args) throws Exception{
        //创建mysql操作类
        HdfsOperator hdfsOperator = new HdfsOperator();
        //设置本地文件的绝对路径
        String localFile = "D:/KmeansTest.txt";
        //设置hdfs上的文件名
        String remoteFile = "KmeansTest.txt";
        hdfsOperator.upload2Hdfs(localFile, remoteFile);
    }
}
