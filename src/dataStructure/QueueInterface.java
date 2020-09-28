package dataStructure;

public interface QueueInterface <T>{
	
    public void offer(T newE);
    public boolean isEmpty();
    public T peek();
    public T poll();
    public void clear();
    public int size();

}
