package dataStructure;

public class Satck <E> implements StackInterface <E>{

	private Node <E> top;
	private int size;
	
	@Override
	public void push(E newE) { // agregar
		
		Node <E> apilar = new Node <E> (newE);
		
		if(top != null) {
			apilar.setSiguiente(top);
			top.setAnterior(apilar);
			size++;
		}
		setTop(apilar);
		
		
	}

	@Override
	public boolean isEmpty() { //esta vacio
		
		boolean empty = false;
		
		if (top==null) {
			empty = true;
		}
	
		return empty;
	}

	@Override
	public E top() { //primer valor
		
		E topValue = null;
		if (top != null) {
			topValue = top.getDato();
			
		}
		
		return topValue;
	}

	@Override
	public E pop() { // eliminar (lifo)
		
		E delete = null;
		
		if (top != null) {
			delete = top.getDato();
			Node<E> second = top.getSiguiente();
			
			if (second != null) {
				second.setAnterior(null);
				
			}
			setTop(second);
			
		}

		return delete;
	}

	@Override
	public void clear() { // eliminar stack
		
		top = null;
	
	}

	@Override
	public int size() { // retorna el tamaño
		
		return size;
	}
	
	private void setTop(Node<E> top) {
		this.top = top;
	}

}
