import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class WisconsinDirectroyTest implements WiscIDList {

  static HashTableMap<String, Integer> map = new HashTableMap<String, Integer>(5);

  /**
   * This method tests the functioning of the getUsername() method from the WiscID class
   * 
   * @return a boolean value depending on the result of the test
   */
  public static boolean getUsernameMethodTest() {

    if (!WiscIDList.Student18.getUsername().equals("mjordan")) {
      return false;
    }

    if (!WiscIDList.Student45.getUsername().equals("tpaine")) {
      return false;
    }
    return true;
  }

  /**
   * This method tests the functioning of the getID() method from the WiscID class
   * 
   * @return a boolean value depending on the result of the test
   */
  public static boolean getIdMethodTest() {

    if (!(WiscIDList.Student19.getID() == 1012145342)) {
      return false;
    }

    if (!(WiscIDList.Student39.getID() == 1012156912)) {
      return false;
    }
    return true;
  }

  /**
   * This method tests the functioning of the get() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */
  public static boolean hashTableMapGetMethodTest() {
    ArrayList<String> wiscNames = new ArrayList<String>();

    wiscNames = map.get("james");
    if (!(wiscNames.size() == 4 && wiscNames.contains("1012160492")
        && wiscNames.contains("1012132039") && wiscNames.contains("hjames")
        && wiscNames.contains("djames")))
      return false;

    wiscNames = map.get("Smith");
    if (!(wiscNames.size() == 4 && wiscNames.contains("1012184392")
        && wiscNames.contains("1012190334") && wiscNames.contains("wsmith")
        && wiscNames.contains("jsmith")))
      return false;

    return true;
  }

  /**
   * This method tests the functioning of the containsKey() method from the HashTableMap class
   * 
   * @return a boolean value depending on the result of the test
   */
  public static boolean hashTableMapContainsKeyMethodTest() {

    if (!map.containsKey("ppewds"))
      return false;

    if (!map.containsKey("vdavid"))
      return false;

    return true;
  }

  public static boolean testOne() throws FileNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    PrintStream old = System.out; // Saves the old System.out
    System.setOut(ps); // Tells Java to use your special stream
    File file = new File("testOne.txt"); // This file simulates user inputs with corner years
                                             // and finally the
                                             // option to quit the application
    StudentDirectory.scanner = new Scanner(file);
    StudentDirectory.runApp(); // runs the app
    System.out.flush(); // Captures the output
    System.setOut(old);
    String expected = "Please Enter your option:-\n" + 
        "1. Search for Student with NetID or Last Name\n" + 
        "2. Exit.\n" + 
        "1\n" + 
        "Enter NetID or Last name of Student: \n" + 
        "xyz\n" + 
        "Student does not exist.\n" + 
        "Please Enter your option:-\n" + 
        "1. Search for Student with NetID or Last Name\n" + 
        "2. Exit.\n" + 
        "2\n" + 
        "Goodbye.";
    if (!baos.toString().equals(expected)) {
      return false;
    }
    return true;
  }


  // The Main Method is being used to run the tests.
  public static void main(String[] args) throws FileNotFoundException {
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
    System.out.println(map.size());
    System.out.println("Test 1: " + getUsernameMethodTest());
    System.out.println("Test 2: " + getIdMethodTest());
    System.out.println("Test 3: " + hashTableMapGetMethodTest());
    System.out.println("Test 4: " + hashTableMapContainsKeyMethodTest());
    System.out.println("Test 5: " + testOne());

  }

}
