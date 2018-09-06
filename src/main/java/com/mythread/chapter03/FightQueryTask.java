package com.mythread.chapter03;

import tool.SleepTimeUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter03
 * @author zhouzhen
 * @Date 2018年09月05日
 * @version v1.0
 *
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;

    private final String destination;

    private final List<String> flightList = new ArrayList<>();

    public FightQueryTask(String fightCompany,String origin, String destination ) {
        super("["+fightCompany+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void run(){
        System.out.printf("%s---查询从 %s 到 %s 的航班\r\n",getName(),origin,destination);
        int randomVal = ThreadLocalRandom.current().nextInt(10);
        SleepTimeUnit.secondsSleep(randomVal);
        flightList.add(getName()+"---"+randomVal);
        System.out.printf("%s 查询完成\r\n",getName());

    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
