// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.ArrayList;
import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {
    public boolean put(KeyType key, ValueType value);

    public ArrayList<String> get(KeyType key) throws NoSuchElementException;

    public int size();

    public boolean containsKey(KeyType key);

    public ValueType remove(KeyType key);

    public void clear();
}