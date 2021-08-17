package harish.methodrefrences;

interface Messageable{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.print(msg);
    }
}


public class MethodReferenceConstructorExample {
    public static void main(String[] args) {
        Messageable messageable = Message::new;
        messageable.getMessage("Hello");
    }
}
