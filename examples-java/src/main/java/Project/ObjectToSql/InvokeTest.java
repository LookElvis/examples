package Project.ObjectToSql;

import java.lang.reflect.Constructor;

/**
 * Created by liuxiang on 2018/7/3.
 */
public class InvokeTest {
    public static void main(String[] args) throws Exception {
        Student stu1 = new Student(2, "a", 20);
        String temp = stu1.getClass().getName();
        Class clazz = Class.forName(temp);
        Constructor[] conArray = clazz.getConstructors();
        Object o = conArray[1].newInstance(1, "1", 20);
        Student stu = (Student) o;
        System.out.println(stu.getName());

//        Field[] filedArray = clazz.getDeclaredFields();
//        for (Field f : filedArray) {
//            System.out.println(f.getType());
//        }
//
//        Class c = getMethodC(filedArray[0].getType().toString());
//        System.out.println(c);
    }

    public static Class getMethodC(String type){
        Class cs = Integer.TYPE;
            if(!type.trim().equals("")||type!=null){
                if(type.equals("int")||type.equals("Integer")){
                    cs=Integer.TYPE;
                }else if(type.equals("float")||type.equals("Float")){
                    cs=Float.TYPE;
                }else if(type.equals("double")||type.equals("Double")){
                    cs=Double.TYPE;
                }else if(type.equals("boolean")||type.equals("Boolean")){
                    cs=Boolean.TYPE;
                }else{
                    cs=String.class;
                }
            }
        return cs;
    }


    public static Class[] getMethodClass(String[] type){
        Class[] cs = new Class[type.length];
        for (int i = 0; i < cs.length; i++) {
            if(!type[i].trim().equals("")||type[i]!=null){
                if(type[i].equals("int")||type[i].equals("Integer")){
                    cs[i]=Integer.TYPE;
                }else if(type[i].equals("float")||type[i].equals("Float")){
                    cs[i]=Float.TYPE;
                }else if(type[i].equals("double")||type[i].equals("Double")){
                    cs[i]=Double.TYPE;
                }else if(type[i].equals("boolean")||type[i].equals("Boolean")){
                    cs[i]=Boolean.TYPE;
                }else{
                    cs[i]=String.class;
                }
            }
        }
        return cs;
    }

}
