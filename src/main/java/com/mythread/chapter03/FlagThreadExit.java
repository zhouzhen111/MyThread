package com.mythread.chapter03;

import tool.SleepTimeUnit;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter03
 * @author zhouzhen
 * @Date 2018年09月05日
 * @version v1.0
 *
 */
public class FlagThreadExit {

    static class MyThread extends Thread{

        private volatile boolean flag = false;

        @Override
        public void run(){
            System.out.println("我开始工作");
            while (!isInterrupted() && !flag){
                //work
            }
            System.out.println("我马上结束");
        }

        public void close(){
            this.flag = true;
            this.interrupt();
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        SleepTimeUnit.secondsSleep(10);
        System.out.println("系统关闭线程");
        myThread.close();

    }

}
