package com.ycx.wpp.core.learning;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by apple on 2018/3/17.
 */
public class ListCopyTest {

    public static void main(String[] args) {
        System.out.println("run");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("start");
        alocateM();
        System.out.println("stop");
//        System.gc();
        try {
            Thread.sleep(200000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void alocateM() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<byte[]> list = new ArrayList<byte[]>();

        // 480m
        int size = 1024 * 1024 * 480;

        int len = size / (20 * 1024);
        System.out.println(len);
        for (int i=0 ;i<len ;i++){
            try {
                byte[] bytes = new byte[20*1024];
                list.add(bytes);
            }catch (OutOfMemoryError e){

            }
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
