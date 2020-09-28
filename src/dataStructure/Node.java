package dataStructure;

public class Node<E>  {
    
    private E type;
    private Node<E> next;
    private Node<E> prev;

    public Node(E type) {
        this.type = type;
        next = null;
        prev = null;
    }

    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
