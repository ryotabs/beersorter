
package edu.ics211.h03;

import java.util.Arrays;
import java.util.Comparator;
import edu.ics211.h01.Beer;

/**
 * Creates a list of beers that is sortable. All methods taken from Data Structures: Abstraction and Design Using Java,
 * Sec. 2.4
 * 
 * @author Ryota Seki
 * @param <E> The object that is created
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private static final int INITIAL_CAPACITY_OF_BEERS = 10;
  private E[] beers;
  private int beersSize = 0;
  private int beersCapacity = 0;
  private double startTime;
  private double totalTime;
  private int numberOfComparisons;
  private int numberOfSwaps;
  private Comparator<E> compare;


  /**
   * Constructor method for SortableList, initializes the array.
   * @param compare Compares the beers
   */
  @SuppressWarnings("unchecked")
  public SortableList(Comparator<E> compare) {
    beersCapacity = INITIAL_CAPACITY_OF_BEERS;
    beers = (E[]) new Object[beersCapacity];
    this.compare = compare;
  }


  /**
   * Gets the location of the element in the list at the given index.
   */
  @Override
  public E get(int index) {
    if (index < 0 || index >= beersSize) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    insertionSort(compare);
    return beers[index];
  }


  /**
   * Sets a new element in the list at the given index.
   */
  @Override
  public E set(int index, E newElement) {
    if (index < 0 || index >= size()) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    E oldElement = beers[index];
    beers[index] = newElement;
    insertionSort(compare);
    return oldElement;
  }


  /**
   * Returns the index of the provided object. Taken from
   * https://stackoverflow.com/questions/19625257/arraylist-implementation-of-indexoft-t-method
   */
  @Override
  public int indexOf(Object obj) {
    for (int i = 0; i < size(); i++) {
      if (obj.equals(beers[i])) {
        return i;
      }
    }
    return -1;
  }


  /**
   * Returns the size of the list.
   */
  @Override
  public int size() {
    return beersSize;
  }


  /**
   * Adds an element at the end of the array.
   */
  @Override
  public boolean add(E e) {
    if (size() == beersCapacity) {
      reallocate();
    }
    beers[beersSize++] = e;
    insertionSort(compare);
    return true;
  }


  /**
   * Adds an element to the list at the given index.
   * 
   * @param index The index that the element is inserted
   * @param newElement The element that is inserted in the list
   */
  @Override
  public void add(int index, E newElement) {
    if (index < 0 || index > beersSize) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    if (size() == beersCapacity) {
      reallocate();
    }

    for (int i = beersSize; i > index; i--) {
      beers[i] = beers[i - 1];
    }
    beers[index] = newElement;
    beersSize++;
    insertionSort(compare);
  }


  /**
   * Removes the element at the given index.
   */
  @Override
  public E remove(int index) {
    if (index < 0 || index > beersSize) {
      throw new ArrayIndexOutOfBoundsException(index);
    }
    E removedElement = beers[index];
    for (int i = index + 1; i < beersSize; i++) {
      beers[i - 1] = beers[i];
    }
    beersSize--;
    return removedElement;
  }


  /**
   * Reallocates the array if size is equal to capacity.
   */
  private void reallocate() {
    beersCapacity = 2 * beersCapacity;
    beers = Arrays.copyOf(beers, beersCapacity);
  }


  /**
   * Implements insertion sort. Taken from Data Structures: Abstraction and Design using Java p. 385
   * 
   * @param compare The comparator doing the comparison
   */
  @Override
  public void insertionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    numberOfComparisons = 0;
    numberOfSwaps = 0;
    // for each array element from the second (nextPos = 1) to the last
    for (int newVal = 1; newVal < beersSize; newVal++) {
      E nextVal = beers[newVal];
      int nextPos = newVal;
      while (nextPos > 0 && compare.compare(nextVal, beers[nextPos - 1]) < 0) {
        beers[nextPos] = beers[nextPos - 1];
        nextPos--;
      }
      // old value becomes next value
      beers[nextPos] = nextVal;
      numberOfComparisons++;
    }
    totalTime = System.nanoTime() - startTime;
  }


  /**
   * Implements the bubble sort for the array list of beers. Taken from
   * http://courses.ics.hawaii.edu/ics211s18-2/morea/060.simple-sorting/experience-sorting-practice.html
   * 
   * @param compare The object being compared
   */
  @Override
  public void bubbleSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    numberOfComparisons = 0;
    numberOfSwaps = 0;
    boolean exchange = false;
    int pass = 0;
    do {
      exchange = false;
      for (int i = 1; i < size() - pass; i++) {
        int result = compare.compare(beers[i - 1], beers[i]);
        numberOfComparisons++;
        if (result > 0) {
          E temp = beers[i];
          beers[i] = beers[i - 1];
          beers[i - 1] = temp;
          exchange = true;
          numberOfSwaps++;
        }
      }
      pass++;
    }
    while (exchange);
    totalTime = System.nanoTime() - startTime;
  }


  /**
   * Implements selection sort. Taken from Data Structures: Abstraction and Design Using Java p. 382
   * 
   * @param compare The object being compared
   */
  @Override
  public void selectionSort(Comparator<E> compare) {
    startTime = System.nanoTime();
    numberOfComparisons = 0;
    numberOfSwaps = 0;
    for (int fill = 0; fill < size(); fill++) {
      int posMin = fill;
      for (int next = fill + 1; next < size(); next++) {
        numberOfComparisons++;
        if (compare.compare(beers[posMin], beers[next]) > 0) {
          posMin = next;
        }
      }
      if (fill != posMin) {
        E temp = beers[fill];
        beers[fill] = beers[posMin];
        beers[posMin] = temp;
        numberOfSwaps++;
      }
    }
    totalTime = System.nanoTime() - startTime;
  }


  /**
   * Returns the number of swaps.
   */
  @Override
  public int getNumberOfSwaps() {
    return numberOfSwaps;
  }


  /**
   * Gets/returns number of comparisons.
   */
  @Override
  public int getNumberOfComparisons() {
    return numberOfComparisons;
  }


  /**
   * Gets/returns the time it took to sort data.
   */
  @Override
  public double getSortTime() {
    return totalTime;
  }

}
