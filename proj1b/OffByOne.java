/**
 * @author Sen Yan
 * @create 2021-04-18-15:04
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
