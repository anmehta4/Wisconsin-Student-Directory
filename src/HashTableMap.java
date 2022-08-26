// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVWriter;

/**
 * 
 * @author ishitadhoot
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  int capacity; // the maximum number of key value pairs the array can hold
  int size; // the number of key value pairs currently in the array
  LinkedList<KeyValue<KeyType, ValueType>>[] keyValuePairs; // the array that holds key value pairs

  /**
   * The constructor that gets invoked if the capacity is specified. Assigns the class array to have
   * the specified capacity
   * 
   * @param capacity - the maximum number of key value pairs the array can hold
   */
  @SuppressWarnings("unchecked")
  public HashTableMap(int capacity) {
    this.capacity = capacity; // assigns capacity with the specified number
    size = 0;
    keyValuePairs = new LinkedList[this.capacity]; // creates an array with the specified capacity
  }

  /**
   * 
   * The constructor that gets invoked if the capacity is not specified. Assigns the class array to
   * hold at least 10 key value pairs by default.
   * 
   */
  @SuppressWarnings("unchecked")
  public HashTableMap() {
    this.capacity = 10; // assigns capacity 10
    size = 0;
    keyValuePairs = new LinkedList[this.capacity]; // creates an array to hold 10 key value pairs at
                                                   // least
  }

  /**
   * Insert a key value pair into the array if that key doesn't exist already. If there is a hash
   * collision, it gets added as a linked list at the calculated index of the array. Should the
   * addition of a key value pair occupy 80% of the array, the array is doubled and rehashed
   * 
   * @return true if the key value pair was inserted and false otherwise
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    // TODO Auto-generated method stub
    int index = Math.abs(key.hashCode()) % this.capacity; // calculates index to store the key value
                                                          // based on the
                                                          // key

    if (keyValuePairs[index] != null) {
      for (int i = 0; i < keyValuePairs[index].size(); i++) { // checks if the key is already exists
                                                              // at that index
                                                              // and returns false if so
        if ((keyValuePairs[index].get(i)).getKey().equals(key)) {
          return false;
        }
      }
    }
    if (keyValuePairs[index] == null) { // if the index is empty a new Linked list is created to add
                                        // the pairs of
                                        // type KeyValue
      keyValuePairs[index] = new LinkedList<KeyValue<KeyType, ValueType>>();
    }
    keyValuePairs[index].add(new KeyValue<KeyType, ValueType>(key, value)); // adds the KeyValue to
                                                                            // the table
    size++; // increments the size

    if (size >= 0.8 * (this.capacity)) { // checks if the recent addition increases the size to
                                         // equal or more than
                                         // 80% of the capacity
      this.capacity = 2 * this.capacity; // doubles the capacity
      @SuppressWarnings("unchecked")
      LinkedList<KeyValue<KeyType, ValueType>>[] temp = new LinkedList[this.capacity]; // creates a
                                                                                       // temporary
                                                                                       // array
      for (int i = 0; i < keyValuePairs.length; i++) { // steps through each index to copy the
                                                       // elements into new
                                                       // calculated indices
        if (keyValuePairs[i] != null) {
          for (int j = 0; j < keyValuePairs[i].size(); j++) {
            int newIndex = Math.abs(keyValuePairs[i].get(j).getKey().hashCode()) % this.capacity;
            if (temp[newIndex] == null) {
              temp[newIndex] = new LinkedList<KeyValue<KeyType, ValueType>>();
            }
            temp[newIndex].add(keyValuePairs[i].get(j));
          }
        }
      }
      keyValuePairs = temp;

    }
    return true;

  }

  /**
   * Returns the value of ValueType of the key specified if it exists in the hash table. Otherwise
   * throws a NoScuhElementException
   * 
   * @param key
   * @throws NoSuchElementException if the key is not found in the table
   * @return value of the key value pair
   */
  @Override
  public ArrayList<String> get(KeyType key) throws NoSuchElementException {
    // TODO Auto-generated method stub
    ArrayList<String> values = new ArrayList<String>();
    if (keyValuePairs[Math.abs(key.hashCode()) % this.capacity] != null) {

      for (int i = 0; i < keyValuePairs[Math.abs(key.hashCode()) % this.capacity].size(); i++) { // steps
                                                                                                 // through
                                                                                                 // each
                                                                                                 // element
                                                                                                 // at
                                                                                                 // that
                                                                                                 // index
                                                                                                 // to
                                                                                                 // see
                                                                                                 // if
                                                                                                 // the
                                                                                                 // key
                                                                                                 // exist
                                                                                                 // and
                                                                                                 // returns
                                                                                                 // true
                                                                                                 // if
                                                                                                 // so
        if (keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getKey().equals(key)) {
          values.add(String
              .valueOf(keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getKey()));
          values.add(String
              .valueOf(keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getValue()));
          return values;
        }
      }

    }

    for (int i = 0; i < keyValuePairs.length; i++) {
      if (keyValuePairs[i] != null) {
        for (int j = 0; j < keyValuePairs[i].size(); j++) {
          Pattern pattern = Pattern.compile((String) key, Pattern.CASE_INSENSITIVE);
          Matcher matcher = pattern.matcher((CharSequence) keyValuePairs[i].get(j).getKey());
          boolean matchFound = matcher.find();
          if (matchFound) {
            values.add(String.valueOf(keyValuePairs[i].get(j).getKey()));
            values.add(Integer.toString((int) keyValuePairs[i].get(j).getValue()));
          }
        }
      }
    }

    if (values != null) {
      return values;
    }

    throw new NoSuchElementException("This key does not exist!");
  }

  /**
   * Retrieves the number of key value pairs in the table currently
   * 
   * @return the size of the array
   */
  @Override
  public int size() {
    // TODO Auto-generated method stub
    return this.size; // returns the size
  }

  /**
   * Steps through each node to look for the key specified.
   * 
   * @param key of KeyType to look it up in the hash table
   * @return true if the key exists on the table, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    // TODO Auto-generated method stub
    if (keyValuePairs[Math.abs(key.hashCode()) % this.capacity] != null) { // checks if there is a
                                                                           // linked list at
                                                                           // calculated index based
                                                                           // on the hash
                                                                           // code of key
      for (int i = 0; i < keyValuePairs[Math.abs(key.hashCode()) % this.capacity].size(); i++) { // steps
                                                                                                 // through
                                                                                                 // each
                                                                                                 // node
                                                                                                 // of
                                                                                                 // the
                                                                                                 // linked
                                                                                                 // list
                                                                                                 // to
                                                                                                 // see
                                                                                                 // if
                                                                                                 // the
                                                                                                 // key
                                                                                                 // is
                                                                                                 // in
                                                                                                 // the
                                                                                                 // table
        if (keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getKey().equals(key)) {
          return true;
        }
      }
    }
    for (int i = 0; i < keyValuePairs.length; i++) {
      if (keyValuePairs[i] != null) {
        for (int j = 0; j < keyValuePairs[i].size(); j++) {
          Pattern pattern = Pattern.compile((String) key, Pattern.CASE_INSENSITIVE);
          Matcher matcher = pattern.matcher((CharSequence) keyValuePairs[i].get(j).getKey());
          // System.out.println(keyValuePairs[i].get(j).getKey());
          boolean matchFound = matcher.find();
          if (matchFound) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Retrieves the value of the key looking for. Should that key not exist, it returns null.
   * 
   * @param key of KeyType to look it up in the hash table
   * @return value of ValueType that corresponds to the key specified
   */
  @Override
  public ValueType remove(KeyType key) {
    // TODO Auto-generated method stub
    for (int i = 0; i < keyValuePairs[Math.abs(key.hashCode()) % this.capacity].size(); i++) {// steps
                                                                                              // through
                                                                                              // each
                                                                                              // node
                                                                                              // of
                                                                                              // the
                                                                                              // linked
                                                                                              // list
                                                                                              // to
                                                                                              // see
                                                                                              // if
                                                                                              // the
                                                                                              // key
                                                                                              // is
                                                                                              // in
                                                                                              // the
                                                                                              // table
      if (keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getKey().equals(key)) {
        size--; // the size decrements
        ValueType valueRemoved =
            keyValuePairs[Math.abs(key.hashCode()) % this.capacity].get(i).getValue();
        keyValuePairs[Math.abs(key.hashCode()) % this.capacity].remove(i); // removes that key value
                                                                           // pair from
                                                                           // the linked list
        return valueRemoved;
      }
    }

    return null;
  }

  /**
   * Clears the hash table so it is now empty
   */
  @Override
  public void clear() {
    // TODO Auto-generated method stub
    for (int i = 0; i < keyValuePairs.length; i++) { // steps through each index of the array and
                                                     // sets it to null
      keyValuePairs[i] = null;
    }
    this.size = 0;

  }

  public void mapToCsv() {

    try {
      // create FileWriter object with file as parameter
      FileWriter outputfile = new FileWriter("students.csv");

      // create CSVWriter object filewriter object as parameter
      CSVWriter writer = new CSVWriter(outputfile);

      // adding header to csv
      String[] header = {"Username", "Email ID", "NetID"};
      writer.writeNext(header);

      for (int i = 0; i < keyValuePairs.length; i++) {
        if (keyValuePairs[i] != null) {
          keyValuePairs[i].forEach((temp) -> {
            String[] data = {(String) temp.getKey(), (String) temp.getKey() + "@wisc.edu",
                Integer.toString((int) temp.getValue())};
            writer.writeNext(data);
          });
        }
      }
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
