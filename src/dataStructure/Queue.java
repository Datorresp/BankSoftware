package dataStructure;


public class Queue<T> {

    private Node<T> primero;
    private Node<T> ultimo;
    private int size;

    public Queue() {
        primero = null;
        ultimo = null;
        size  = 0;
    }

    public void encolar(T elemento) {
        Node<T> newNode = new Node<>(elemento);
        if (ultimo == null) {
            primero = newNode;
        }else{
            Node<T> temp = ultimo;
            newNode.setSiguiente(temp);
            temp.setAnterior(newNode);
        }
        ultimo = newNode;
        size += 1;
    }

    public T desencolar() {
        Node<T> temp = primero;
        if (temp !=null) {
            primero = primero.getAnterior();
            size -= 1;
            return temp.getDato();
        }
        return null;
    }

    public Node<T> mostrar() {
        return primero;
    }

    public int size() {
        return size;
    }
}
