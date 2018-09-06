package com.mythread.chapter04;

import tool.SleepTimeUnit;

import java.util.Random;

/***
 *
 * @Project MyThread
 * @Package com.mythread
 * @author zhouzhen
 * @Date 2018年08月25日
 * @version v1.0
 *
 */
public class TicketWindowRunnable implements Runnable {

    private final static int MAX = 500;

    private int index=1;

    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX){
            while (index <= MAX){

                System.out.println(Thread.currentThread().getName()+"当前号码是:"+index++);
                try {
                    MUTEX.wait((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();

        Thread thread1 = new Thread(task, "一号机器");

        Thread thread2 = new Thread(task, "二号机器");

        Thread thread3 = new Thread(task, "三号机器");
        Thread thread4 = new Thread(task, "四号机器");
        Thread thread5 = new Thread(task, "五号机器");
        Thread thread6 = new Thread(task, "六号机器");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
