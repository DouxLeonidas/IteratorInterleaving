public class CircularLinkedList<T> {
  public Node head;
  public Node tail;
  
  public class Node {
    T val;
    Node next;
    public Node(T val) {
      this.val = val;
    }

    public T getVal() {
      return val;
    }
  }

  public void addNode(T value) {
    Node newNode = new Node(value);

    if (head == null) {
        head = newNode;
    } else {
        tail.next = newNode;
    }

    tail = newNode;
    tail.next = head;
  }

  public void removeHead() {
    if (head == tail) {
      head = null;
      tail = null;
    } else {
      tail.next = head.next;
      head = head.next;
    }
  }

  public void rotate() {
    if (head != null) {
      tail = tail.next;
      head = head.next;
    }
  }

}