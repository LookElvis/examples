package Interview;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuxiang on 2019/9/4.
 */
public class Alibaba {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        List<Data> dataList = new LinkedList<>();
        List<Result> resultList = new LinkedList<>();
        while (input.hasNext()) {
            String id = input.next();
            //终止循环
            if (id.equals("-1")) {
                break;
            }
            String time = input.next() + " " + input.next();
            double index = input. nextDouble();
            String ds = input.next();
            dataList.add(new Data(id, time, index, ds));
        }

        String idPointer = "";
        String dsPointer = "";
        long timeBegin = -1;
        long timeEnd = -1;
        for (int i = 0; i < dataList.size(); i++) {
            Data tmp = dataList.get(i);
            //路口切换
            if (!tmp.getInter_id().equals(idPointer)) {
                idPointer = tmp.getInter_id();
                dsPointer = tmp.getDs();
                timeBegin = -1;
                timeEnd = -1;
            }

            //如果拥堵
            if (tmp.getCong_index() >= 2.0) {
                //切换路口则更新指针为初始值
                dsPointer = timeEnd == -1 ? tmp.getDs(): dsPointer;
                timeBegin = timeBegin == -1 ? tmp.getTime(): timeBegin;
                timeEnd = timeEnd == -1 ? tmp.getTime(): timeEnd;

                //如果间隔在10分钟以内，将现在的时间赋给end
                if (tmp.getTime() - timeEnd <= 10 * 60) {
                    timeEnd = tmp.getTime();
                } else {  //如果间隔超出10分钟，则可以将之前的值输出，并对begin和end重新定义为当前时间
                    Date date1 = new Date(timeBegin * 1000);
                    Date date2 = new Date(timeEnd * 1000);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    Result result = new Result(idPointer, " [" + format.format(date1) + "," + format.format(date2) + ") ", dsPointer);
                    resultList.add(result);
                    timeBegin = tmp.getTime();
                    timeEnd = tmp.getTime();
                }
            }
        }

        //添加最后一次结果
        Date date1 = new Date(timeBegin * 1000);
        Date date2 = new Date(timeEnd * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Result result = new Result(idPointer, " [" + format.format(date1) + "," + format.format(date2) + ") ", dsPointer);
        resultList.add(result);

        for (int j = 0; j < resultList.size(); j++) {
            Result tmp = resultList.get(j);
            System.out.println(tmp.getInter_id() + " " + tmp.getTime_period() + " " + tmp.getDs());
        }
    }
}

class Result {
    private String inter_id;
    private String time_period;
    private String ds;

    public Result(String inter_id, String time_period, String ds) {
        this.inter_id = inter_id;
        this.time_period = time_period;
        this.ds = ds;
    }

    public String getInter_id() {
        return inter_id;
    }

    public void setInter_id(String inter_id) {
        this.inter_id = inter_id;
    }

    public String getTime_period() {
        return time_period;
    }

    public void setTime_period(String time_period) {
        this.time_period = time_period;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}

class Data {
    private String inter_id;
    private long time;
    private double cong_index;
    private String ds;

    public Data(String inter_id, String date, double cong_index, String ds) {
        this.inter_id = inter_id;
        this.cong_index = cong_index;
        this.ds = ds;
        try {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));
            this.time = calendar2.getTimeInMillis()/ 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getInter_id() {
        return inter_id;
    }

    public void setInter_id(String inter_id) {
        this.inter_id = inter_id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getCong_index() {
        return cong_index;
    }

    public void setCong_index(double cong_index) {
        this.cong_index = cong_index;
    }

    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }
}
