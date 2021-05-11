package es.datastructur.synthesizer;

/**
 * @author Sen Yan
 * @create 2021-04-27-13:59
 */
public interface BoundedQueue<T> {
    void enqueue(T x);
    T dequeue();
    T peek();
    int capacity();
    int fillCount();
    default boolean isEmpty(){
        return fillCount() == 0;
    }
    default boolean isFull(){
        return capacity() == fillCount();
    }
}
