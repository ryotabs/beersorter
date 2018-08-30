package edu.ics211.h03;

import java.util.Comparator;

/**
 * Implements sorts and gets the number of swaps/comparisons.
 *
 * @author Ryota Seki
 *
 * @param <E> Generic object
 */
public interface ISortableList<E> {

  /**
   * Implements insertion sort.
   * @param compare The object being compared
   */
  void insertionSort(Comparator<E> compare);
  
  
  /**
   * Implements bubble sort.
   * @param compare Object being compared
   */
  void bubbleSort(Comparator<E> compare);
  
  
  /**
   * Implements selection sort.
   * @param compare Object being compared
   */
  void selectionSort(Comparator<E> compare);
  
  
  /**
   * Gets number of swaps.
   * @return Number of swaps
   */
  int getNumberOfSwaps();
  
  
  /**
   * Gets number of comparisons.
   * @return Number of comparisons
   */
  int getNumberOfComparisons();
  
  
  /**
   * Gets sort time.
   * @return Gets sort time
   */
  double getSortTime();
  
  
}
