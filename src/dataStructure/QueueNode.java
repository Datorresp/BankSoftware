package dataStructure;

public class QueueNode<T>  {
    private T dato;
    private QueueNode<T> siguiente;
    private QueueNode<T> anterior;

    public QueueNode(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public QueueNode<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(QueueNode<T> siguiente) {
        this.siguiente = siguiente;
    }

    public QueueNode<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(QueueNode<T> anterior) {
        this.anterior = anterior;
    }
}
