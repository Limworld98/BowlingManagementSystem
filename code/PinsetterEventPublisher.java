import java.util.ArrayList;

public class PinsetterEventPublisher {
  private ArrayList<PinsetterObserver> subscribes;
  public PinsetterEventPublisher() {
    subscribes = new ArrayList<PinsetterObserver>();
  }

  public void attach(PinsetterObserver observer) {
    subscribes.add(observer);
  }

  public void detach(PinsetterObserver observer) {
    subscribes.remove(observer);
  }

  public void notify(PinsetterEvent event) {
    for (PinsetterObserver observer : subscribes) {
      observer.updatePinsetterEvent(event);
    }
  }
}
