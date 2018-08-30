
package edu.ics211.h03;

import static org.junit.Assert.*;

import edu.ics211.h01.ManoaBrewing;
import edu.ics211.h01.Pilsner;
import edu.ics211.h01.AbvComparator;
import edu.ics211.h01.IbuComparator;

import java.util.Comparator;

import org.junit.Test;
import org.junit.Before;


/**
 * Tests SortableList, tests methods and sorts. 
 * A LOT of code was taken from http://courses.ics.hawaii.edu/ics211s18-2/morea/070.lists/experience-H03.html
 * Testing strategy was to figure out why insertion sort wasn't working, but didn't get anything to work.
 * @author Ryota Seki
 *
 */
public class SortableListTest {
  private ManoaBrewing brewery;
  private IbuComparator ibuC;
  private AbvComparator abvC;
  private Pilsner[] listOfPilsners;
  private SortableList bitters;
  private SortableList strongs;
  
  
  /**
   * Initializes the array list by instantiating beers.
   */
  @Before
  public void initialize() {
    brewery = ManoaBrewing.getInstance();
    ibuC = new IbuComparator();
    abvC = new AbvComparator();
    listOfPilsners = new Pilsner[3];
    listOfPilsners[0] = (Pilsner) brewery.brewPilsner("pils1", 30, 4.5);
    listOfPilsners[1] = (Pilsner) brewery.brewPilsner("pils2", 45, 5.2);
    
  }
  
  /**
   * Test method for {@link edu.ics211.h03.SortableList#get(int)}.
   */
  @Test
  public void testGet() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#set(int, java.lang.Object)}.
   */
  @Test
  public void testSet() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#indexOf(java.lang.Object)}.
   */
  @Test
  public void testIndexOf() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#size()}.
   */
  @Test
  public void testSize() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#add(java.lang.Object)}.
   */
  @Test
  public void testAddE() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#add(int, java.lang.Object)}.
   */
  @Test
  public void testAddIntE() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#remove(int)}.
   */
  @Test
  public void testRemove() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#insertionSort(java.util.Comparator)}.
   */
  @Test
  public void testInsertionSort() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#bubbleSort(java.util.Comparator)}.
   */
  @Test
  public void testBubbleSort() {
    fail("Not yet implemented");
  }


  /**
   * Test method for {@link edu.ics211.h03.SortableList#selectionSort(java.util.Comparator)}.
   */
  @Test
  public void testSelectionSort() {
    fail("Not yet implemented");
  }

}
