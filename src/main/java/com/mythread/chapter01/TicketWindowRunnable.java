package com.mythread.chapter01;

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

    private final static int MAX = 50;

    private int index=1;

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread().getName()+"当前号码是:"+index++);
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();

        Thread thread1 = new Thread(task, "一号机器");
        thread1.start();
        Thread thread2 = new Thread(task, "二号机器");
        thread2.start();
        Thread thread3 = new Thread(task, "三号机器");
        thread3.start();
    }
}
