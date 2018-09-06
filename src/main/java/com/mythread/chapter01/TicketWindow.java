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
public class TicketWindow extends Thread {

    private final static int MAX = 500;

    private final String name;

    private static int index = 1;

    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run(){
        while (index<=MAX){
            System.out.println("柜台:"+this.name + ",当前的号码是:"+index++);
        }
    }

    public static void main(String[] args) {
        TicketWindow window1 = new TicketWindow("一号机器");
        window1.start();
        TicketWindow window2 = new TicketWindow("二号机器");
        window2.start();
        TicketWindow window3 = new TicketWindow("三号机器");
        window3.start();
        TicketWindow window4 = new TicketWindow("四号机器");
        window4.start();
        TicketWindow window5 = new TicketWindow("五号机器");
        window5.start();


    }
}
