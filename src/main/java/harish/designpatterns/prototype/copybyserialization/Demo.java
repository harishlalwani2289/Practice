package harish.designpatterns.prototype.copybyserialization;

import org.apache.commons.lang3.SerializationUtils;

public class Demo {

    public static void main(String[] args) {
        Foo foo = new Foo(24, "peek");

        Baa baa = new Baa(foo, 12);
        Baa baaClone = SerializationUtils.clone(baa);
        baaClone.getFoo().whatever = "Peek changed";
        baaClone.getFoo().stuff = 0;

        System.out.println(baa);
        System.out.println(baaClone);

    }
}
