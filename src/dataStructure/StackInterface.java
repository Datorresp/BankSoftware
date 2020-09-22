package dataStructure;

public interface StackInterface <E>{
	
	public void push(E newE);
	public boolean isEmpty();
	public E top();
	public E pop();
	public void clear();
	public int size();

}
