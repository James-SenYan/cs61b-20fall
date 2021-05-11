/**
 * @author Sen Yan
 * @create 2021-04-18-14:08
 */
public class LinkedListDeque<T> implements Deque<T> {
    private class Node{
        private Node pre;
        private T item;
        private Node next;

        public Node(Node pre, T item, Node next){
            this.pre = pre;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentF;
    private int size;
    private Node sentB;

    public LinkedListDeque(){
        sentF = new Node(null, null, null);
        sentB = new Node(null, null, null);
        sentF.next = sentB;
        sentB.pre = sentF;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        size += 1;
        Node newNode = new Node(null, item,null);
        Node oldNode = sentF.next;
        oldNode.pre = newNode;
        newNode.pre = sentF;
        newNode.next = oldNode;
        sentF.next = newNode;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        Node newNode = new Node(null, item, null);
        Node oldNode = sentB.pre;
        oldNode.next = newNode;
        newNode.next = sentB;
        newNode.pre = oldNode;
        sentB.pre = newNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = this.sentF;
        while(p.next != sentB){
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if(sentF.next == sentB){
            return null;
        }else{
            T result =  sentF.next.item;
            sentF.next = sentF.next.next;
            sentF.next.pre = sentF;
            size -= 1;
            return  result;
        }
    }

    @Override
    public T removeLast() {
        if(sentB.pre == sentF){
            return null;
        }else{
            T result = sentB.pre.item;
            sentB.pre = sentB.pre.pre;
            sentB.pre.next = sentB;
            size -= 1;
            return result;
        }
    }

    @Override
    public T get(int index) {
        Node p = sentF.next;
        while (index > 0){
            p = p.next;
            index -= 1;
        }
        return p.item;
    }
}
