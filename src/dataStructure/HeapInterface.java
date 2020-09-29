package dataStructure;

public interface HeapInterface <E>{
	
	public void buildMaxHeap ();
	public void maxHeapify (int i, int a);
	public void heapSort ();
	public int right(int i);
	public int left (int i);
	public int parent (int i);
	

}
