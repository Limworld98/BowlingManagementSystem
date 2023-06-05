import java.util.Iterator;
import java.util.Vector;

public class ControlDeskEventPublisher {
    private Vector subscribers;

    public ControlDeskEventPublisher() {
        subscribers = new Vector();
    }

    /**
     * Allows objects to subscribe as observers
     *
     * @param adding	the ControlDeskObserver that will be subscribed
     *
     */

    public void subscribe(ControlDeskObserver adding) {
        subscribers.add(adding);
    }

    /**
     * Broadcast an event to subscribing objects.
     *
     * @param vector    current party information snapshot
     *
     */

    public void publish(Vector vector) {
        Iterator eventIterator = subscribers.iterator();
        while (eventIterator.hasNext()) {
            (
                    (ControlDeskObserver) eventIterator
                            .next())
                    .receiveControlDeskEvent(
                            new ControlDeskEvent(vector));
        }
    }
}
