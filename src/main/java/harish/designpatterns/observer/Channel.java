package harish.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
  List<Subscriber> subs = new ArrayList<>();
  private String title;

  public void subscribe(Subscriber subscriber) {
    subs.add(subscriber);
  }

  public void  unSubscribe(Subscriber subscriber) {
    subs.remove(subscriber);
  }

  public void notifyAllSubscribers() {
    for(Subscriber subscriber : subs) {
      subscriber.update();
    }
  }

  public void upload(String title) {
    this.title = title;
    notifyAllSubscribers();
  }

}
