import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PerformTests implements CollectionTest {
    private int size;

    LinkedList<Person> linkedList;
    ArrayList<Person> arrayList;
    HashMap<Integer, Person> hashMap;


    public PerformTests() {}


    public void setSize(int size) {
        this.size = size;
    }

    

    public void addLinkedList() {
        linkedList = new LinkedList<Person>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            linkedList.add(new Person("Person" + i+1, random.nextInt(100))); // Choose a random age up to 100
        }
    }


    public Person indexLinkedList(LinkedList<Person> linkedList) {
        return (linkedList.get(size/2));
    }


    public Person searchLinkedList(LinkedList<Person> linkedList) {
        for(Person person : linkedList) {
            if(person.getName().equals("Person"+Integer.toString(size/2)))
                return person;
        }
        return null;
    }



    public void addArrayList() {
        arrayList = new ArrayList<Person>();
        for(int i = 0; i < size; i++) {
            Random random = new Random();
            arrayList.add(new Person("Person" + i+1, random.nextInt(100)));
        }
    }


    public void indexArrayList() {

    }


    public void searchArrayList() {

    }



    public void addHashMap() {

    }


    public void indexHashMap() {

    }


    public void searchHashMap() {

    }


    // Uses switch to execute test
    public void runTest(CollectionType type, TestType test, int iterations) {
        for(int i = 0; i < iterations; i++) {
            switch(type) {
                case LINKED_LIST:
                    switch(test) {
                        case ADD:
                            addLinkedList();
                            break;
                        case INDEX:
                            indexLinkedList(linkedList);
                            break;
                        case SEARCH:
                            searchLinkedList(linkedList);
                            break;
                    }
                    break;

                case ARRAY_LIST:
                
                    break;
                case HASH_MAP:

                    break;
            }
        }
    }
}
