package harish.thread;

import leetcode.RansomNote;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadColor.ANSI_BLUE + "Hello from another thread " + i + " from thread " + Thread.currentThread().getName());
            System.out.println(RansomNote.canConstruct("ededoiud", "ddeefdd"));
        }
    }
}
