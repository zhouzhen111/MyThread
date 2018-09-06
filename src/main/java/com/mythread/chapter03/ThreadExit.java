package com.mythread.chapter03;

import tool.SleepTimeUnit;

import java.util.concurrent.TimeUnit;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter03
 * @author zhouzhen
 * @Date 2018年09月05日
 * @version v1.0
 *
 */
public class ThreadExit {

    public static void main(String[] args) {

        Thread thread1 = new Thread(){
            @Override
            public void run(){
                System.out.println("1线程开始");
                while (!isInterrupted()){
                    //工作
                }
                System.out.println("1我将退出");
            }
        };

        thread1.start();
        SleepTimeUnit.secondsSleep(1);
        System.out.println("系统中断");
        thread1.interrupt();

        Thread thread2 = new Thread(){
            @Override
            public void run(){
                System.out.println("2线程开始");
                for (;;){
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("2我将退出");
            }
        };

        thread2.start();
        SleepTimeUnit.secondsSleep(10);
        System.out.println("系统中断");
        thread2.interrupt();

    }


}
