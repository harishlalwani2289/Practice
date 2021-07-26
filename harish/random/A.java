package practice.harish.random;

import java.io.IOException;

public class A {

    public void doSomething() {

    }

    public static void main(String[] args) throws IOException {
        A a = new B();
        a.doSomething();
    }
}

class B extends A {
    public void doSomething() throws RuntimeException {

    }
}
