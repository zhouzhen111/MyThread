package com.mythread.chapter05;

import java.util.LinkedList;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter05
 * @author zhouzhen
 * @Date 2018年09月06日
 * @version v1.0
 *
 * 解决了多线程之间的通讯问题
 *
 */
public class EventQueueImprovement {

    private final int max ;

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueueImprovement(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueueImprovement(int max) {
        this.max = max;
    }

    public static class Event{
        private String name ;

        public Event(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public void offer(Event event){
        synchronized (eventQueue){
            while (eventQueue.size()>= max){
                try {
                    console("当前任务队列满了");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    int b;
                    e.printStackTrace();
                }
            }

            console("新的任务"+event.getName()+"被提交");
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }


    public Event take(){

        synchronized (eventQueue){
            while (eventQueue.isEmpty()){
                try {
                    console("当前队列是空的,没有任务可返回");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    int a;
                    e.printStackTrace();
                }
            }

            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console("任务["+event.getName()+"]被处理,可以继续提交任务");
            return event;
        }

    }


    private void console(String message) {
        System.out.printf("%s : %s \r\n" ,Thread.currentThread().getName() , message );
    }

}
