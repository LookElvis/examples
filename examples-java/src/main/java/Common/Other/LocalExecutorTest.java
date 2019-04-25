package Common.Other;

import Project.ObjectToSql.Student;
import com.lucloud.cloudmining.runtime.local.callback.ConvertCallback;
import com.lucloud.cloudmining.runtime.local.work.MysqlWorker;

import java.util.ArrayList;
import java.util.List;

public class LocalExecutorTest {
	
	public static void main(String[] args) {
		ConvertCallback<String,List<Object[]>> callback  = a -> {
			//a 为 传入的json串。 
			//直接转换成List<Object[]> 。 Object[]数组的长度为参数的个数
			//模拟将json转转换成对象。  具体转换需要调用方转换
			Object[] rows1 = new Object[] {"row1 c1 values", "row2 c2 values"};
			Object[] rows2 = new Object[] {"row2 c1 values", "row2 c2 values"};
			Student aa = new Student(2, "a", 20);

			List<Object[]> rowvlues = new ArrayList<Object[]>();
			rowvlues.add(rows1);
			rowvlues.add(rows2);
			
			return rowvlues ;
			
		};
		
//		MysqlWorker.fromJson("insert into tablename(c1,c2) values(?,?)", "[{a:1,b:2},{a1:1,b2:2}]",  callback) ;
		MysqlWorker.fromJson("insert into ldaresult_copy(word,weight) values(?,?)", "[{a:1,b:2},{a1:1,b2:2}]",  callback) ;

		//来源于对象
		List<Object> a = null ;
		ConvertCallback<Object,List<Object[]>> callback2  = b -> {
			//同上转换
			System.out.println(b);
			return null ;
			
		};
		//MysqlWorker.fromObject("insert into tablename(c1,c2) values(?,?)", a,  callback2) ;
		
	}

}
