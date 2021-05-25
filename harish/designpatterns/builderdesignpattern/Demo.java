package practice.harish.designpatterns.builderdesignpattern;

public class Demo {

    public static void main(String[] args) {

        HtmlBuilder builder = new HtmlBuilder("ul");
        builder
            .addChild("li", "hello")
            .addChild("li", "world");
        System.out.println(builder);

        PhoneBuilder phoneBuilder = new PhoneBuilder();
        Phone nokia = phoneBuilder.addName("Nokia").addSize(2).build();
        System.out.println("Phone name is :" + nokia.getName() + " with size :" + nokia.getSize());
    }
}
