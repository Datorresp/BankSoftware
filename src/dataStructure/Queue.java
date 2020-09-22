package dataStructure;


public class Queue<T> {

    private QueueNode<T> primero;
    private QueueNode<T> ultimo;
    private int size;

    public Queue() {
        primero = null;
        ultimo = null;
        size  = 0;
    }

    public void encolar(T elemento) {
        QueueNode<T> newNode = new QueueNode<>(elemento);
        if (ultimo == null) {
            primero = newNode;
        }else{
            QueueNode<T> temp = ultimo;
            newNode.setSiguiente(temp);
            temp.setAnterior(newNode);
        }
        ultimo = newNode;
        size += 1;
    }

    public T desencolar() {
        QueueNode<T> temp = primero;
        if (temp !=null) {
            primero = primero.getAnterior();
            size -= 1;
            return temp.getDato();
        }
        return null;
    }

    public QueueNode<T> mostrar() {
        return primero;
    }

    public int size() {
        return size;
    }
}
