package harish.designpatterns.observer;

public class Youtube {

  public static void main(String[] args) {
    Channel telusko = new Channel();
    Subscriber s1 = new Subscriber("Harish");
    Subscriber s2 = new Subscriber("Harish1");
    Subscriber s3 = new Subscriber("Harish2");
    Subscriber s4 = new Subscriber("Harish3");
    Subscriber s5 = new Subscriber("Harish4");

    telusko.subscribe(s1);
    telusko.subscribe(s2);
    telusko.subscribe(s3);
    telusko.subscribe(s4);
    telusko.subscribe(s5);

//    s1.subscribeChannel(telusko);
//    s2.subscribeChannel(telusko);
//    s3.subscribeChannel(telusko);
//    s4.subscribeChannel(telusko);
//    s5.subscribeChannel(telusko);

    telusko.upload(("How to run program!!"));
  }

}
