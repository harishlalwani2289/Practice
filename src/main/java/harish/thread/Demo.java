package harish.thread;

import harish.dynamicprogramming.Fibonacci;
import leetcode.FizzBuzz;
import leetcode.RansomNote;

public class Demo {
    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_CYAN + "Hello from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from anonymous thread " + i + " from thread " + "Anonymous");
                System.out.println(RansomNote.canConstruct("ededoiud", "ddeefdd"));
            }
        }).start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        Thread anotherThread2 = new AnotherThread();
        anotherThread2.setName("Thread 2");
        anotherThread2.start();
    }
}
