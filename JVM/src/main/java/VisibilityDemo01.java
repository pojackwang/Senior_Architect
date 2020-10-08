/**
 * Copyright (C), 2018-2020
 * FileName: VisibilityDemo01
 * Author:   xjl
 * Date:     2020/10/8 15:25
 * Description: 目标是多线程下的访问的不可见性的现象
 */

/**
 * 在多线程的下的内存不可见的的现象
 */

public class VisibilityDemo01 {

    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();

        //主线程
        while (true) {
            if (mythread.isFlag()) {
                System.out.println("主线程进入循环的执行");
            }
        }

    }
}

class Mythread extends Thread {
    //成员变量
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
        super.run();
    }

    public boolean isFlag() {
        return flag;
    }
}
