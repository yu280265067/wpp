package com.ycx.wpp.core.learning;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2018/5/7.
 */
public class SplitTest {
    public static final String strTest = "";
    public static void main3(String[] args) throws InterruptedException {

        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 10000; i++) {
            Map<String,String> map = Maps.newHashMap();
            for (int j = 1; j < 100; j++) {
                Integer t = new Random().nextInt(50);
                map.put(t.toString(),new String("美团_外卖"+t.toString()));
            }
            map.entrySet().stream().forEach(e->{
//                String[] ss = e.getValue().split("_");
//                System.out.println(ss);
                String temp = e.toString();
            });
//            Thread.sleep(100);
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void main2(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            Integer t = new Random().nextInt(50);
            String str = new String("美团_外卖" + t.toString());
            String[] arr = str.split("_");
            System.out.println(arr);
            Thread.sleep(100);
        }
    }
    public static void main(String[] args) {
            String dateStr =  "2018-05-07 14:30";
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(date.getTime());

        }

}

