package harish.designpatterns.observer;

public class Subscriber {

  private String name;
  private Channel channel = new Channel();

  public Subscriber(String name) {
    this.name = name;
  }

  public void update() {
    System.out.println("Hey " + name + " New video added.");
  }

  public void subscribeChannel(Channel ch) {
    channel = ch;
  }

}
