package Common.Other;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Elvis on 2019/12/12.
 */
class Animal{
    public Animal() {
        System.out.println("我是父类动物");
    }
}

class Humanity extends Animal{
    public Humanity() {
        System.out.println("我是父类人类");
    }
}

public class Student extends Humanity{

    public Student() {
        System.out.println("我是子类学生");
    }

//    public static void main(String[] args) {
//        Student student=new Student();
//        final int a = 0;
//        System.out.println(a);
//
//    }

    public static void main(String[] args) throws Exception {
//        ArrayList<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        list.getClass().getMethod("add",Object.class).invoke(list, "asd");
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("121");
        list.add(new Date());
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }
}
