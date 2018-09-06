package com.mythread.chapter03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @Project MyThread
 * @Package com.mythread.chapter03
 * @author zhouzhen
 * @Date 2018年09月05日
 * @version v1.0
 *
 */
public class FightQueryExample {

    //各大航空公司
    private static List<String> fightCompanys = Arrays.asList("海南航空","南方航空","国际航空");

    public static void main(String[] args) {
        List<String> results = search("[北京]","[上海]");
        System.out.println("=============结果===============");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin , String dest){

        List<String> results = new ArrayList<>();

        List<FightQueryTask> fightQueryTasks = fightCompanys.stream()
                .map(f -> createFightQueryTask(f,origin,dest)).collect(Collectors.toList());

        fightQueryTasks.forEach(Thread::start);

        fightQueryTasks.forEach( f ->{
            try {
                f.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        fightQueryTasks.stream().map(FightQueryTask :: get).forEach(results::addAll);

        return results;
    }

    private static FightQueryTask createFightQueryTask(String fightCompany, String origin, String dest) {
        return new FightQueryTask(fightCompany,origin,dest);
    }

}
