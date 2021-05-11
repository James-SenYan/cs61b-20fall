import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Sen Yan
 * @create 2021-04-25-14:04
 */
public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map.
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null){
            throw new IllegalArgumentException("key can not be null");
        }
        if (contains(x)){
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer returnStr = new StringBuffer("[");
        for (int i = 0; i < size - 1; i ++){
            returnStr.append(items[i].toString());
            returnStr.append(", ");
        }
        returnStr.append(items[size - 1]);
        return returnStr.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArraySet<?> arraySet = (ArraySet<?>) o;
        return size == arraySet.size &&
                Arrays.equals(items, arraySet.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        //s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
        System.out.println(s);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    public class ArraySetIterator implements Iterator<T>{
        private int position;

        public ArraySetIterator(){
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            T nextItem = items[size];
            position += 1;
            return nextItem;
        }
    }


    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
