import java.util.Iterator;
import java.util.Set;

/**
 * @author Sen Yan
 * @create 2021-05-10-8:50
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private Node root;

    private class Node{
        private K key;
        private V val;
        private Node left;
        private Node right;
        private int size;

        public Node(K key, V val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BSTMap(){
    }

    @Override
    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null){
            return 0;
        }else{
            return x.size;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key){
        if (key == null){
            throw new IllegalArgumentException("calls to get() with a null key");
        }
        if (x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            return get(x.left, key);
        }else if (cmp > 0){
            return get(x.right, key);
        }else{
            return x.val;
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null){
            throw new IllegalArgumentException("key can not be null");
        }
        if (value == null){
            remove(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V val){
        if (key == null){
            throw new IllegalArgumentException("key can not be null");
        }
        if (x == null){
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = put(x.left, key, val);
        }else if (cmp > 0){
            x.right = put(x.right, key, val);
        }else{
            x.val = val;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
