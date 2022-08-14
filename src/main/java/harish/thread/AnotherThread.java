package harish.thread;

import leetcode.RansomNote;

import static harish.thread.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            System.out.println(ANSI_BLUE + "Hello from another thread " + i + " from thread " + Thread.currentThread().getName());
            System.out.println(RansomNote.canConstruct("ededoiud", "ddeefdd"));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(ANSI_BLUE + "Another thread woke me up");
            }

            System.out.println(ANSI_BLUE + "Three seconds have passed and now I am awake");
        }
    }
}
