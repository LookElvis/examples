package Project.ObjectToSql;

import UtilsPackage.JDBCConnectionTool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by liuxiang on 2018/7/2.
 */
public class ObjectToSql {
    public static void main(String[] args) throws Exception{
        Student aa = new Student(2, "a", 20);
        String sql = toSql("Student", aa);
        System.out.println("sqlSentence:" + sql);
        Connection conn = JDBCConnectionTool.getConn();
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("====== insert into mysql successfully!! ======");
        JDBCConnectionTool.free(st, conn);
    }

    public static String toSql(String tableName, Object o) {
        String sql = "insert into " + tableName + " values(";
        final String ddd = "insert into Student values(1,'a',20)";

        String[] typesArray = getFiledTypes(o);
        Object[] valuesArray = getFiledValues(o);
        for(int i=0; i<valuesArray.length; i++){
            if(i==valuesArray.length - 1) {
                sql += conString(typesArray[i], valuesArray[i]) + ")";
            }
            else {
                sql += conString(typesArray[i], valuesArray[i]) + ",";
            }
        }

        return sql;
    }

    /**
     *判断属性是否是字符串类型
     * */
    public static String conString(String type, Object value) {
        if(type.equals("class java.lang.String"))
            return "'"+value+"'";
        else
            return value.toString();
    }

    /**
     * 根据属性名获取属性值
     * */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取属性名数组
     * */
    public static String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 获取属性类型
     * */
    public static String[] getFiledTypes(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldTypes=new String[fields.length];
        for(int i=0;i<fields.length;i++){
            fieldTypes[i]=fields[i].getType().toString();
        }
        return fieldTypes;
    }

    /**
     * 获取对象的所有属性值，返回一个对象数组
     * */
    public static Object[] getFiledValues(Object o){
        String[] fieldNames= getFiledName(o);
        Object[] value=new Object[fieldNames.length];
        for(int i=0;i<fieldNames.length;i++){
            value[i] = getFieldValueByName(fieldNames[i], o);
        }
        return value;
    }

}
