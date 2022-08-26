// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

/**
 * 
 * @author ishitadhoot
 *
 * @param <KeyType>
 * @param <ValueType>
 */
public class KeyValue<KeyType, ValueType> {

	private KeyType key; // Type of Key object for the Key-Value Pair
	private ValueType value; // Type of Value object for the Key-Value Pair

	/**
	 * 
	 * The constructor that makes a KeyValue object and assigns key and value
	 * 
	 * @param key
	 * @param value
	 * 
	 */
	public KeyValue(KeyType key, ValueType value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * Retrieves the key from the key value pair
	 * 
	 * @return key of type K
	 */
	public KeyType getKey() {
		return this.key;
	}

	/**
	 * Retrieves the value from the key value pair
	 * 
	 * @return value of type V
	 */
	public ValueType getValue() {
		return this.value;
	}

}
