/**
 * @author Sen Yan
 * @create 2021-04-18-14:28
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDeque<>();
        for (char c : word.toCharArray()){
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() == 1 || deque.size() == 0){
            return true;
        }
        Character first = deque.removeFirst();
        Character last = deque.removeLast();
        if(first != last){
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1));
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque = wordToDeque(word);
        if (deque.size() == 1 || deque.size() == 0){
            return true;
        }
        Character first = deque.removeFirst();
        Character last = deque.removeLast();
        if(!cc.equalChars(first, last)){
            return false;
        }
        return isPalindrome(word.substring(1, word.length() - 1), cc);
    }
}
