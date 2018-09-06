package com.mythread.chapter01;

import java.util.concurrent.TimeUnit;

/***
 *
 * @Project MyThread
 * @Package com.mythread
 * @author zhouzhen
 * @Date 2018年08月25日
 * @version v1.0
 *
 */
public class MyThread {

    public static void watchTV(){
        for(;;){
            System.out.println("oh,I'm watch TV");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void driverWhiter(){

        for (;;){
            System.out.println("oh,I'm driver whiter");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                watchTV();
            }
        };



        Thread thread2 = new Thread(){
            @Override
            public void run(){
                driverWhiter();
            }
        };
        thread1.start();
        thread2.start();


    }
}
