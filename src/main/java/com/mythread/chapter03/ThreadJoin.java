package com.mythread.chapter03;

import tool.SleepTimeUnit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter03
 * @author zhouzhen
 * @Date 2018年09月04日
 * @version v1.0
 *
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1,3)
                .mapToObj(ThreadJoin::create).collect(Collectors.toList());

        threadList.stream().forEach(Thread::start);

        for (Thread thread : threadList) {
            thread.join();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"#"+i);
            SleepTimeUnit.secondsSleep(1);
        }

    }

    private static Thread create(int seq){
        return new Thread(() -> {
            for (int i = 0; i<10 ; i++){
                System.out.println(Thread.currentThread().getName()+"#"+i);
                SleepTimeUnit.secondsSleep(1);
            }
        },String.valueOf(seq));
    }

}
