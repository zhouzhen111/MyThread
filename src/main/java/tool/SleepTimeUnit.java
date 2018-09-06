package tool;

import java.util.concurrent.TimeUnit;

/***
 *
 * @Project MyThread
 * @Package com.mythread
 * @author zhouzhen
 * @Date 2018年09月05日
 * @version v1.0
 *
 */
public class SleepTimeUnit {

    public static void millisecondsSleep(int seconds){
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void secondsSleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void minutesSleep(int seconds){
        try {
            TimeUnit.MINUTES.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hoursSleep(int seconds){
        try {
            TimeUnit.HOURS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
