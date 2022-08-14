package harish.thread;

import leetcode.RansomNote;

import static harish.thread.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(ANSI_RED + "Hello from myRunnable thread " + i + " from thread " + Thread.currentThread().getName());
//            System.out.println(RansomNote.canConstruct("ededoiud", "ddeefdd"));
        }
    }
}
