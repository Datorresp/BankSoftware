package dataStructure;


public class GenericsQueue<E> implements QueueInterface<E>{

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public GenericsQueue() {
        head = null;
        tail = null;
        size  = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void offer(E newE) {
             
        Node<E> newNode = new Node<>(newE);
        
        if (head == null) {
            
            head = newNode;
            tail = newNode;
        }else{
            
            tail.setNext(newNode);
            tail = newNode;
        }
        
        size++;
    }

    @Override
    public boolean isEmpty() {
        
        return head == null;
    }

    @Override
    public E peek() {
        
        if (head != null) {
            
            return head.getType();
        }else{
            
            return null;
        }
    }

    @Override
    public E poll() {
        
        E dev = null;
        if (head != null) {
            
            dev = head.getType();
            head = head.getNext();
        }
       
        return dev;
    }

    @Override
    public void clear() {
        
    }

    @Override
    public int size() {
        
        return size;
    }

    
}
