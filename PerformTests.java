import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Performs tests on LinkedList, ArrayList, and HashMap collections.
 */
public class PerformTests implements CollectionTest {
    private int size;

    LinkedList<Person> linkedList;
    ArrayList<Person> arrayList;
    HashMap<Integer, Person> hashMap;

    /**
     * Default constructor for PerformTests.
     */
    public PerformTests() {}

    /**
     * Sets the size for the collections.
     *
     * @param size The size to be set.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Adds people to a LinkedList.
     */
    public void addLinkedList() {
        linkedList = new LinkedList<Person>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            linkedList.add(new Person("Person" + i+1, random.nextInt(100))); // Choose a random age up to 100
        }
    }

    /**
     * Gets the Person at the specified index from a LinkedList.
     *
     * @param linkedList The LinkedList to get the index from.
     * @param index The index to retrieve the Person from.
     * @return The Person at the specified index.
     */
    public Person indexLinkedList(LinkedList<Person> linkedList, int index) {
        return linkedList.get(index);
    }

    /**
     * Searches for a Person in a LinkedList.
     *
     * @param linkedList The LinkedList to search in.
     * @param name The name of the Person to search for.
     * @return The found Person or null if not found.
     */
    public Person searchLinkedList(LinkedList<Person> linkedList, String name) {
        for(Person person : linkedList) {
            if(person.getName().equals(name))
                return person;
        }
        return null;
    }

    /**
     * Adds people to an ArrayList.
     */
    public void addArrayList() {
        arrayList = new ArrayList<Person>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            arrayList.add(new Person("Person" + i+1, random.nextInt(100)));
        }
    }

    /**
     * Gets the Person at the specified index from an ArrayList.
     *
     * @param arrayList The ArrayList to get the index from.
     * @param index The index to retrieve the Person from.
     * @return The Person at the specified index.
     */
    public Person indexArrayList(ArrayList<Person> arrayList, int index) {
        return arrayList.get(index);
    }

    /**
     * Searches for a Person in an ArrayList using binary search.
     *
     * @param arrayList The ArrayList to search in.
     * @param name The name of the Person to search for.
     * @return The found Person or null if not found.
     */
    public Person searchArrayList(ArrayList<Person> arrayList, String name) {
        int low = 0;
        int high = arrayList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Person person = arrayList.get(mid);
            if (person.getName().equals(name))
                return person;
            else if (person.getName().compareTo(name) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    /**
     * Adds people to a HashMap.
     */
    public void addHashMap() {
        hashMap = new HashMap<Integer, Person>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            hashMap.put(i+1, new Person("Person" + i+1, random.nextInt(100)));
        }
    }

    /**
     * Gets the Person at the specified index from a HashMap.
     *
     * @param hashMap The HashMap to get the index from.
     * @param index The index to retrieve the Person from.
     * @return The Person at the specified index.
     */
    public Person indexHashMap(HashMap<Integer, Person> hashMap, int index) {
        return hashMap.get(index);
    }

    /**
     * Searches for a Person in a HashMap using the hash code of the name.
     *
     * @param hashMap The HashMap to search in.
     * @param name The name of the Person to search for.
     * @return The found Person or null if not found.
     */
    public Person searchHashMap(HashMap<Integer, Person> hashMap, String name) {
        return hashMap.get(name.hashCode());
    }

    /**
     * Runs tests on the specified collection type and test type for a given number of iterations.
     *
     * @param type The collection type to test (LINKED_LIST, ARRAY_LIST, HASH_MAP).
     * @param test The test type to perform (ADD, INDEX, SEARCH).
     * @param iterations The number of iterations to run the test.
     */
    public void runTest(CollectionType type, TestType test, int iterations) {
        for(int i = 0; i < iterations; i++) {
            switch(type) {
                case LINKED_LIST:
                    switch(test) {
                        case ADD:
                            addLinkedList();
                            break;
                        case INDEX:
                            indexLinkedList(linkedList, size/2);
                            break;
                        case SEARCH:
                            searchLinkedList(linkedList, "Person" + size/2);
                            break;
                    }
                    break;

                case ARRAY_LIST:
                    switch(test) {
                        case ADD:
                            addArrayList();
                            break;
                        case INDEX:
                            indexArrayList(arrayList, size/2);
                            break;
                        case SEARCH:
                            searchArrayList(arrayList, "Person" + size/2);
                    }
                    break;
                case HASH_MAP:
                    switch(test) {
                        case ADD:
                            addHashMap();
                            break;
                        case INDEX:
                            indexHashMap(hashMap, size/2);
                            break;
                        case SEARCH:
                            searchHashMap(hashMap, "Person" + size/2);
                            break;
                    }
                    break;
            }
        }
    }
}
