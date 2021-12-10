package harish.designpatterns.observer;

public class ObserverPatternDemo {

  public static void main(String[] args) {
    Subject subject = new Subject();
    new BinaryObserver(subject);
    new OctalObserver(subject);

    subject.setState(10);
  }

}
