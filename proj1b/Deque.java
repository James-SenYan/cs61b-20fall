/**
 * @author Sen Yan
 * @create 2021-04-18-14:06
 */
public interface Deque<Item> {
    void addFirst(Item x);
    void addLast(Item x);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();
    void printDeque();
    Item removeFirst();
    Item removeLast();
    Item get(int index);
}
