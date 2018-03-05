package arrayIndexList;

import java.lang.reflect.Array;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 
	//value of empty positions in current instance
	private int empties;

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
		empties = INITCAP;
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		// ADD CODE AS REQUESTED BY EXERCISES
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("add: Invalid index = " + index);
		
		if(size == element.length){
			changeCapacity(CAPTOAR);
			empties = empties + CAPTOAR;
		}
		
		if(element[index] != null)
			moveDataOnePositionTR(index, size-1);
		
		element[index] = e;
		size++;
		empties--;
	}


	public void add(E e) {
		// ADD CODE AS REQUESTED BY EXERCISES
		
		if(size == element.length){
			changeCapacity(CAPTOAR);
			empties = empties + CAPTOAR;
		}
		
		element[size] = e;
		size++;
		empties--;
	}


	public E get(int index) throws IndexOutOfBoundsException {
		// ADD AND MODIGY CODE AS REQUESTED BY EXERCISES
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("get: Invalid index = " + index);
		
		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		E temp = element[index];
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("remove: Invalid index = " + index);
		
		if(index < size)
			moveDataOnePositionTL(index+1, size-1);
		
		if(empties >= MAXEMPTYPOS) {
			changeCapacity(-CAPTOAR);
			empties = empties - CAPTOAR;
		}
		
		size--;
		empties++;
		return temp;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		// ADD AND MODIFY CODE AS REQUESTED BY EXERCISES
		E orig = element[index];
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException("set: Invalid index = " + index);
		
		element[index] = e;
		return orig;
	}


	public int size() {
		return size;
	}	
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}


	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		// TODO es in Exercise 3
		Object[] arr = new Object[size];
		int i = 0;
		for(E e: element) {
			arr[i] = e;
			i++;
		}
		return arr;
	}


	
	@Override
	public <T1> T1[] toArray(T1[] array) {
		// TODO as in Exercise 3
		if(array.length < this.size()) {
			T1[] newInstance = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.size());
			array = newInstance;
		}
		else if(array.length > this.size()) {
			for(int j=this.size(); j<array.length; j++) {
				array[j] = null;
			}
		}
		
		for(int i=0; i<this.size(); i++) {
			T1 t1 = (T1) element[i];
			array[i] = t1;
		}

		return array;
	}


	@Override
	public int capacity() {
		return element.length;
	}
	
	

}
