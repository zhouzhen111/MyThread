package com.mythread.chapter05;

import tool.SleepTimeUnit;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter05
 * @author zhouzhen
 * @Date 2018年09月06日
 * @version v1.0
 *
 */
public class EventClient {

    public static void main(String[] args) {

        final EventQueue eventQueue = new EventQueue();

        new Thread(() -> {
            int i = 1;
            for(;;i++){
                eventQueue.offer(new EventQueue.Event(i+"号"));
                SleepTimeUnit.secondsSleep(1);
            }
        },"生产者--producer").start();
        new Thread(()-> {
            while (true){
                EventQueue.Event take = eventQueue.take();
                SleepTimeUnit.secondsSleep(10);
            }
        },"消费者--consumer").start();
    }

}
