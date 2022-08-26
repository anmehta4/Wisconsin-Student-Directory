// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

/**
 * 
 * @author Arnav - class to test different methods of the HashMapTable
 *
 */
class TestClass implements WiscIDList {

  static HashTableMap<String, Integer> map = new HashTableMap<String, Integer>(5);

  @BeforeEach
  public void insertKeyValuePair() {
    map.put(Student1.getUsername(), Student1.getID());
    map.put(Student2.getUsername(), Student2.getID());
    map.put(Student3.getUsername(), Student3.getID());
    map.put(Student4.getUsername(), Student4.getID());
    map.put(Student5.getUsername(), Student5.getID());
    map.put(Student6.getUsername(), Student6.getID());
    map.put(Student7.getUsername(), Student7.getID());
    map.put(Student8.getUsername(), Student8.getID());
    map.put(Student9.getUsername(), Student9.getID());
    map.put(Student10.getUsername(), Student10.getID());
    map.put(Student11.getUsername(), Student11.getID());
    map.put(Student15.getUsername(), Student15.getID());
    map.put(Student16.getUsername(), Student16.getID());
  }

  /**
   * This method tests the functioning of the getUsername() method from the WiscID class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void getUsernameMethodTest() {

    if (!Student18.getUsername().equals("mjordan")) {
      fail("WiscID getUsername() method incorrectly implemented");
    }

    if (!Student45.getUsername().equals("tpaine")) {
      fail("WiscID getUsername() method incorrectly implemented");
    }
  }

  /**
   * This method tests the functioning of the getID() method from the WiscID class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void getIdMethodTest() {

    if (!(Student19.getID() == 1012145342)) {
      fail("WiscID getID() method incorrectly implemented");
    }

    if (!(Student39.getID() == 1012156912)) {
      fail("WiscID getID() method incorrectly implemented");
    }
  }

  /**
   * This method tests the functioning of the clear() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void hashTableMapClearMethodTest() {
    
    map.clear();
    if (!(map.size()==0))
        fail("HashMap clear() method incorrectly implemented");

  }
  
  /**
   * This method tests the functioning of the size() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void hashTableMapSizeMethodTest() {
    
    if (!(map.size()==13))
        fail("HashMap size() method incorrectly implemented");

    map.remove(Student2.getUsername());
    
    if (!(map.size()==12))
        fail("HashMap size() method incorrectly implemented");
  }
  
  /**
   * This method tests the functioning of the remove() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void hashTableMapRemoveMethodTest() {
    
    Integer remove = map.remove(Student1.getUsername());
    if (map.containsKey(Student1.getUsername()) && remove == Student1.getID())
        fail("HashMap remove() method incorrectly implemented");

    remove = map.remove(Student2.getUsername());
    if (map.containsKey(Student2.getUsername()) && remove == Student2.getID())
        fail("HashMap remove() method incorrectly implemented");
  }

  /**
   * This method tests the functioning of the get() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */

  @Test
  public void hashTableMapGetMethodTest() {
    ArrayList<String> wiscNames = new ArrayList<String>();

    wiscNames = map.get("james");
    if (!(wiscNames.size() == 4 && wiscNames.contains("1012160492")
        && wiscNames.contains("1012132039") && wiscNames.contains("hjames")
        && wiscNames.contains("djames")))
      fail("HashMap get() method incorrectly implemented");

    wiscNames = map.get("Smith");
    if (!(wiscNames.size() == 4 && wiscNames.contains("1012184392")
        && wiscNames.contains("1012190334") && wiscNames.contains("wsmith")
        && wiscNames.contains("jsmith")))
      fail("HashMap get() method incorrectly implemented");

  }

  /**
   * This method tests the functioning of the containsKey() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */
  @Test
  public void hashTableMapContainsKeyMethodTest() {

    if (!map.containsKey("ppewds"))
      fail("HashMap containsKey() method incorrectly implemented");

    if (!map.containsKey("vdavid"))
      fail("HashMap containsKey() method incorrectly implemented");
  }
}
