package harish.thread;

import leetcode.RansomNote;

import static harish.thread.ThreadColor.ANSI_GREEN;
import static java.lang.Thread.currentThread;

public class Demo {
    public static void main(String[] args) {

        System.out.println(ThreadColor.ANSI_CYAN + "Hello from main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(ANSI_GREEN + "Hello from anonymous thread " + i + " from thread " + "Anonymous");
//                System.out.println(RansomNote.canConstruct("ededoiud", "ddeefdd"));
                try {
                    Thread.sleep(1000);
                    if(i>=5) {
                        anotherThread.join(2000);
                        System.out.println(ANSI_GREEN + "Another thread completed or timed out, now I am running again");
                    }

                } catch (InterruptedException e) {
                    System.out.println(ANSI_GREEN + "I couldn't wait after all. I was interrupted");
                }
            }
        }).start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.setName("== My Runnable ==");
//        myRunnableThread.start();

//        /**
//         *
//         * It is used to interrupt an executing thread
//         *
//         * Interrupt method will work only when it is sleeping or waiting state
//         *
//         * If it is called on sleeping or waiting state then it will perform normallly and we will not see any effect
//         *
//         * When we use interrup mwthod, it throws an exception InterruptedException
//         */
//        anotherThread.interrupt();

        System.out.println("Hello again from main thread " + currentThread().getName());

//        Thread anotherThread2 = new AnotherThread();
//        anotherThread2.setName("Thread 2");
//        anotherThread2.start();
    }
}
