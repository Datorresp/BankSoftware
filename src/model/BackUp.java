package model;

import dataStructure.QueueNode;

public class BackUp<T>  {

    private QueueNode<T> stack;

    public BackUp() {
        stack = null;
    }

    public void apilar(T elemento) {
        QueueNode<T> node = new QueueNode<>(elemento);
        node.setSiguiente(stack);
        stack.setAnterior(node);
        stack = node;
    }

    public T desapilar() {
        QueueNode<T> temp = stack;
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
