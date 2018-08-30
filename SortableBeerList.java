
package edu.ics211.h03;

import edu.ics211.h01.Beer;
import java.util.Comparator;

/**
 * Sorts beer list, implements IList211.
 * @author Ryota Seki
 */
public class SortableBeerList implements IList211<Beer> {
  private SortableList<Beer> listOfBeers;
  private Comparator<Beer> compare;
  
  /**
   * Sorts the beers implementing the different sorting methods based upon their values.
   * @param beer The beer that is compared and sorted
   */
  public SortableBeerList(Comparator<Beer> beer) {  
    this.listOfBeers = new SortableList<Beer>(beer);
    this.compare = beer;
  }
  
  

  /**
   * Sets a beer in the list to a specific location/index in the list.
   * @param index The desired location of the beer
   * @param element The beer that you'd like to insert in the list
   */
  @Override
  public Beer set(int index, Beer element) {
    Beer copy = listOfBeers.set(index, element);
    listOfBeers.insertionSort(compare);
    return copy;
  }

  /**
   * Gets and returns the index of the given object.
   * @param obj The given object
   */
  @Override
  public int indexOf(Object obj) {
    return listOfBeers.indexOf(obj);
  }

  /**
   * Returns the size of the list.
   */
  @Override
  public int size() {
    return listOfBeers.size();
  }

  /**
   * Adds a beer at the end of the list.
   */
  @Override
  public boolean add(Beer beer) {
    listOfBeers.insertionSort(compare);
    return listOfBeers.add(beer);
  }

  /**
   * Adds a given beer at the given index.
   */
  @Override
  public void add(int index, Beer element) {
    listOfBeers.add(index, element);
    listOfBeers.insertionSort(compare);
  }
/**
   * Gets gets the beer at the desired index.
   * @param index The index of the list that the desired Beer is at
   */
  @Override
  public Beer get(int index) {
    return listOfBeers.get(index);
  }
  /**
   * Removes the beer at the provided index.
   */
  @Override
  public Beer remove(int index) {
    return listOfBeers.remove(index);
  }
}
