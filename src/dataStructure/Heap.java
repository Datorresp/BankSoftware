package dataStructure;

public class Heap <E extends Comparable<E>> implements HeapInterface <E>{
	
	private int arraySize;
	private int heapSize;
	private E [] array;
	
	public Heap(int arraySize, int heapSize) {
		this.arraySize = arraySize;
		this.heapSize = heapSize;
		array = (E[]) new Comparable [arraySize];
	}

	@Override
	public void buildMaxHeap() {
		heapSize = arraySize;
		for (int i = heapSize/2 ; i >0 ; i--) {
			maxHeapify (i,0);
		}
		
	}

	@Override
	public void maxHeapify(int i, int a) {
		int l,r;
		if (a==0) {
			l = left(i);
			r = right(i);
			i--;
			
		} else {
			l = 2*i+1;
			r = 2*i+2;
		}
		
		a++;
		int total = i;
		if (exists(l) && l<=heapSize && (array[l].compareTo(array[i])>0)) {
			total = l;
			
		}
		if (exists(r) && r<=heapSize && (array[r].compareTo(array[total])>0)){
			total = r;
			
		}
		if (total != i) {
			swap(i,total);
			maxHeapify(total, a);
			
		}
	
	}
        
//    public void priorityInsert(int key, E element) throws SmallerKeyException {
//        
//        heapSize++;
//        if(heapSize > arraysize) {
//                reSize();
//        }
//        elements[heapSize-1] = element;
//        keys[heapSize-1] = Integer.MIN_VALUE;
//        increaseKey(heapSize-1, key);
////    }   
//        
//        @SuppressWarnings("unchecked")
//	@Override
//	public void reSize() {
//		int newArraySize;
//		if (arraysize == 0) {
//			newArraySize = 1;
//		} else {
//			newArraySize = arraysize * 2;
//		}
//		E[] tmpE = (E[]) new Comparable[newArraySize];
//		int[] tmpKeys = new int[newArraySize];
//		for(int i = 0; i < arraysize; i++) {
//			tmpE[i] = elements[i];
//			tmpKeys[i] = keys[i];
//		}
//		setElements(tmpE);
//		setKeys(tmpKeys);
//		arraysize = newArraySize;
//	}

	
	public void swap (int i, int j) {
		E tmp = array[i];
		array [i] = array [j];
		array [j] = tmp;
		
	}
	
	public boolean exists (int i) {
		return i<heapSize;
		
	}

	@Override
	public void heapSort() {
		buildMaxHeap();
		int counter ;
		for (int i = arraySize-1; i > 0; i--) {
			swap(0,i);
			heapSize--;
			counter = 0;
			maxHeapify(1, counter);
		}
	
		
	}

	@Override
	public int right(int i) {
		return (int)Math.floor(i*2+1);
	}

	@Override
	public int left(int i) {
		return (int)Math.floor(i*2);
	}

	@Override
	public int parent(int i) {
		return (int)Math.floor(i/2);
		
	}
	
	public E[] getArray() {
		return array;
	}

	public void setArray(E[] array) {
		setArraySize(array.length);
		setHeapSize(array.length);
		this.array = array;
	}

	public int getArraySize() {
		return arraySize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}
	
}