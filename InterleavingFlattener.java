import java.util.Arrays;
import java.util.Iterator;

public class InterleavingFlattener<T> {
  CircularLinkedList<Iterator<T>> list;
  
  public InterleavingFlattener(Iterator<T>[] iterlist){
    Iterator<Iterator<T>> it = Arrays.asList(iterlist).iterator();
    list = new CircularLinkedList<>();
    while (it.hasNext()) {
      list.addNode(it.next());
    }
  }

  public T next(){
    Iterator<T> element = list.head.getVal();
    
    while (list.head != null) {
      if (element.hasNext()) {
        list.rotate();
        while (list.head != null && !list.head.getVal().hasNext()) {
          list.removeHead();
        }
        return element.next();
      } else {
        list.removeHead();
        if (list.head != null)
          element = list.head.getVal();
      }
    }
    return null;
  }
  
  public boolean hasNext() {
    if (list.head == null) return false;
    return list.head.getVal().hasNext();
  }
}