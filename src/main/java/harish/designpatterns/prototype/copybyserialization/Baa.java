package harish.designpatterns.prototype.copybyserialization;

import java.io.Serializable;

public class Baa implements Serializable {

    public Foo foo;
    public int baValue;

    public Baa(Foo foo, int baValue) {
        this.foo = foo;
        this.baValue = baValue;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public int getBaValue() {
        return baValue;
    }

    public void setBaValue(int baValue) {
        this.baValue = baValue;
    }

    @Override
    public String toString() {
        return "Baa{" +
                "foo=" + foo +
                ", baValue=" + baValue +
                '}';
    }
}
