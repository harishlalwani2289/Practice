package practice.harish.designpatterns.singleton;

public enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    EnumBasedSingleton () {
        value = 42;
    }
}
