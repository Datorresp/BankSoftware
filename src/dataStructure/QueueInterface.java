package dataStructure;

public interface QueueInterface <E>{
	
    public void offer(E newE);
    public boolean isEmpty();
    public E peek();
    public E poll();
    public void clear();
    public int size();

}
