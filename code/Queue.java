/* Queue.java
 *
 *  Version
 *  $Id$
 * 
 *  Revisions:
 * 		$Log$
 * 
 */
 
import java.util.Vector;
 
public class Queue<T> {
	private Vector<T> v;
	
	/** Queue()
	 *
	 * creates a new queue
	 */
	public Queue() {
		v = new Vector<T>();
	}
	
	public T next() {
		return v.remove(0);
	}

	public void add(T o) {
		v.addElement(o);
	}
	
	public boolean hasMoreElements() {
		return v.size() != 0;
	}

	public Vector<T> asVector() {
		return v;
	}
	
}
