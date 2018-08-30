package edu.ics211.h03;

/**
 * List interface for ics211 homework 3.
 *
 * @author Ryota Seki
 * @param <E> The generic object E
 */
public interface IList211<E> {
  
  /**
   * Gets the index of the list.
   * @param index The corresponding index of the list
   * @return The index of the list
   */
  E get(int index);
  
  
  /**
   * Sets a given element in the array list, at the given index.
   * @param index The index that you want to add to
   * @param element The element/object that you want to add
   * @return The set object
   */
  E set(int index, E element);
  
  
  /**
   * Gets the index of the given object.
   * @param obj The object that you would like the index of
   * @return The location/index of the object
   */
  int indexOf(Object obj);
  
  
  /**
   * Gets the size of the list.
   * @return The size of the list
   */
  int size();
  
  
  /**
   * Adds an object at the end the list.
   * @param e The object being added
   * @return The object that was added
   */
  boolean add(E e);
  
  
  /**
   * Adds an object at the given index.
   * @param index The index that you'd like the object added
   * @param element The object that you want to add
   */
  void add(int index, E element);
  
  
  /**
   * Removes an element at the given index.
   * @param index The index of the object/element to be removed
   * @return The removed object
   */
  E remove(int index);

}
