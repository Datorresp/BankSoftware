package model;

public class BackUp<T>  {

    private Node<T> stack;

    public BackUp() {
        stack = null;
    }

    public void apilar(T elemento) {
        Node<T> node = new Node<>(elemento);
        node.setSiguiente(stack);
        stack.setAnterior(node);
        stack = node;
    }

    public T desapilar() {
        Node<T> temp = stack;
        stack = stack.getSiguiente();
        stack.setAnterior(null);
        return temp.getDato();
    }

    public T consultar() {
        return stack.getDato();
    }

    public boolean estaVacia() {
        if (stack == null) {
            return true;
        }
        return false;
    }
}
