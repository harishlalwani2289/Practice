package practice.harish.designpatterns.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }

    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized (LazySingleton.class)
            {
                if(instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }

    // Double check locking

}
