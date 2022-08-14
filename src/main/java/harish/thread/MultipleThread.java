package harish.thread;

public class MultipleThread {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountDownThread thread1 = new CountDownThread(countdown);
        thread1.setName("Thread 1");
        CountDownThread thread2 = new CountDownThread(countdown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

    }
}

class Countdown {
    // We are using the same variable being shared by all the threads which are running this class' methods
    private int i;

    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_PURPLE;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_GREEN;
                break;
            default:
                color = ThreadColor.ANSI_RED;
                break;
        }
        synchronized (this){
            for (i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + "  i = " + i);
            }
        }
    }
}

class CountDownThread extends Thread {
    Countdown threadCountDown;

    public CountDownThread(Countdown countdown) {
        threadCountDown = countdown;
    }

    public void run() {
        threadCountDown.doCountdown();
    }
}
