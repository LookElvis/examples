package Common.MoveTest;

import com.lucloud.cloudmining.datamove.operator.RedisOperator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxiang on 2018/7/24.
 */
public class RedisTest {
    public static void main(String[] args) {
        //创建redis操作类
        RedisOperator redisOperator = new RedisOperator();
        //K-V对中的值为String类型
        String key1 = "key1";
        String value1 = "value1";
        redisOperator.insertString(key1, value1);

        //K-V对中的值为Map<String, String>类型
        String key2 = "key2";
        Map<String, String> value2 = new HashMap<>();
        value2.put("test2", "value2");
        value2.put("test3", "value3");
        redisOperator.insertHashSet(key2, value2);

        //K-V对中的值为String不定类型
        String key3 = "key3";
        redisOperator.insertList(key3, "value4", "value5");

        //关闭
        redisOperator.close();
    }
}
