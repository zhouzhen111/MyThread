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
public class TemplateMethod {

    public final void printf(String message){
        System.out.println("#####################");
        warpPrint(message);
        System.out.println("#####################");
    }

    protected void warpPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod templateMethod1 = new TemplateMethod() {
            @Override
            protected void warpPrint(String message) {
                System.out.println("#" + message + "#");
            }
        };
        TemplateMethod templateMethod2 = new TemplateMethod() {
            @Override
            protected void warpPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };

        templateMethod1.printf("Hello World");
        templateMethod2.printf("Hello World");

    }

}
